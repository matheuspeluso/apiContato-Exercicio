package aluno.Matheus.Peluso.components;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import aluno.Matheus.Peluso.entities.Contato;
import aluno.Matheus.Peluso.repositories.ContatosRepository;

@Component
public class LoadData implements ApplicationRunner {
	
	@Autowired
	ContatosRepository contatosRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		var contato = new Contato();
		contato.setIdContato(UUID.fromString("8c677515-b690-4976-a788-baf44f8a60e3"));
		contato.setNome("Matheus Peluso");
		contato.setEmail("matheuspeluso17@gmail.com");
		contato.setTelefone("(21) 99385-7520");
		
		contatosRepository.save(contato);

	}
	
}
