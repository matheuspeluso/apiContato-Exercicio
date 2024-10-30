package aluno.Matheus.Peluso.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aluno.Matheus.Peluso.dtos.ContatoRequestDto;
import aluno.Matheus.Peluso.entities.Contato;
import aluno.Matheus.Peluso.repositories.ContatoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/contatos")
public class ContatosController {
	
	@PostMapping
	public String post(@RequestBody @Valid ContatoRequestDto request) throws Exception{
		Contato contato = new Contato();
		
		contato.setIdContato(UUID.randomUUID());
		contato.setNome(request.getNome());
		contato.setEmail(request.getEmail());
		contato.setTelefone(request.getTelefone());
		
		ContatoRepository contatoRepository = new ContatoRepository();
		
		contatoRepository.create(contato);
		return "Contato criado com sucesso!";
	}
	
	@PutMapping("{idContato}")
	public String put(@PathVariable UUID idContato, @RequestBody @Valid ContatoRequestDto request) throws Exception{
		
		ContatoRepository contatoRepository = new ContatoRepository();
		var contato = contatoRepository.getById(idContato);
		
		if (contato != null) {
			contato.setNome(request.getNome());
			contato.setEmail(request.getEmail());
			contato.setTelefone(request.getTelefone());
			
			if(!contatoRepository.isExistsByTelefone(contato.getTelefone(), contato.getIdContato())){
				contatoRepository.update(contato);
				return "Contato atualizado com sucesso!";
			}else {
				return "Não é possível atualizar os dados pois o Telefone '"
						+ contato.getTelefone() +"' já pertence a outro contato.";
			}
			
		}else {
			return "Contato não encontrado! Verifique o ID informado.";
		}
		
	}
	
	@DeleteMapping("{idContato}")
	public String delete(@PathVariable UUID idContato) throws Exception{
		ContatoRepository contatoRepository = new ContatoRepository();
		var contato = contatoRepository.getById(idContato);
		
		if(contato != null) {
			contatoRepository.delete(idContato);
			return "Contato excluido com sucesso!";
		}
		return "Contato não encontrado! Verifique o ID informado.";
	}
	
	@GetMapping
	public List<Contato> getAll() throws Exception{
		ContatoRepository contatoRepository = new ContatoRepository();
		return contatoRepository.getAll();
	}
	
	@GetMapping("{idContato}")
	public Contato getById(@PathVariable UUID id) throws Exception {
	
	var contatoRepository = new ContatoRepository();
	return contatoRepository.getById(id);
	}

}
