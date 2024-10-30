package aluno.Matheus.Peluso.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ContatoRequestDto {
	//adicionando validações
	
	@Size(min = 8, max = 100, message = "Por favor, informe o nome de 8 a 100 caracteres.")
	@NotEmpty(message = "Por favor, informe o nome do contato.")
	private String nome;
	
	@Email(message = "Por favor, informe um endereço de email válido.")
	@NotEmpty(message = "Por favor, informe o email do usuário.")
	private String email;
	
	@Pattern(regexp = "^\\(\\d{2}\\) \\d{5}-\\d{4}$", message = "Por favor, informe um número de telefone válido.")
	private String telefone;
}
