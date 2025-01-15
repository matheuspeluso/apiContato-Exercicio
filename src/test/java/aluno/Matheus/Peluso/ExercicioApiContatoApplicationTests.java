package aluno.Matheus.Peluso;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import aluno.Matheus.Peluso.dtos.ContatoRequestDto;

@SpringBootTest
@AutoConfigureMockMvc
class ExercicioApiContatoApplicationTests {
	
	@Autowired
	MockMvc mockMvc; // usado para executar chamadas de teste na API
	
	@Autowired
	ObjectMapper objectMapper; // enviar e receber dados JSON

	@Test
	public void postTests() throws Exception {
		var dto = new ContatoRequestDto();
		var faker = new Faker();
		
		// Preenchendo os dados da requisição
		dto.setNome(faker.name().fullName());
		dto.setEmail(faker.internet().emailAddress());

		// Gerar parte aleatória do telefone com código de área "(11)"
		String numeroAleatorio = faker.number().digits(5) + "-" + faker.number().digits(4);
		String telefoneFormatado = "(11) " + numeroAleatorio; 
		dto.setTelefone(telefoneFormatado);
		
		// Fazendo uma requisição para cadastrar usuário na API
		var result = mockMvc.perform(post("/api/contatos/cadastrar")
				.contentType("application/json") // definindo o formato de dados
				.content(objectMapper.writeValueAsString(dto))) // enviando os dados
				.andExpect(status().isOk()) // verificando se a resposta é OK
				.andReturn(); // capturando o resultado
		
		// Verificando a resposta obtida da API 
		String content = result.getResponse().getContentAsString(StandardCharsets.UTF_8); 
		assertTrue(content.contains("Contato cadastrado com sucesso.")); 
	}
	
/*	@Test
	public void putTests() throws Exception{
		var faker = new Faker();
		
		//id do contato que vamos atualizar
		String id = "b9898409-8745-41b4-8675-d5b4094e7d71";
		
		//criar um contato para ser atualizado
		var dto = new ContatoRequestDto();
		dto.setNome(faker.name().fullName());
		dto.setEmail(faker.internet().emailAddress());
		dto.setTelefone("(11) " + faker.number().digits(5) + "-" + faker.number().digits(4));
		
		var result = mockMvc.perform(put("/api/contatos/" + id)
	            .contentType("application/json")
	            .content(objectMapper.writeValueAsString(dto)))
	            .andExpect(status().isOk())
	            .andReturn();
		
		//Verificando a resposta da API após a atualização
	    String updateContent = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
	    assertTrue(updateContent.contains("Contato atualizado com sucesso."));
	}
	
	@Test
	public void deleteTests() {
		fail("Não implementado");
	}
	
	@Test
	public void getAllTests() {
		fail("Não implementado");
	}
	
	@Test
	public void getByIdTests() {
		fail("Não implementado");
	}*/
}
