package aluno.Matheus.Peluso.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
import aluno.Matheus.Peluso.services.ContatoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/contatos")
public class ContatosController {
	
	@Autowired
	ContatoService contatoService;

	@PostMapping("cadastrar") //ok
	public String post(@RequestBody @Valid ContatoRequestDto dto) throws Exception {
		return contatoService.criarContato(dto);
		
	}

	@PutMapping("{idContato}") // ok
	public String put(@PathVariable UUID idContato, @RequestBody @Valid ContatoRequestDto dto) throws Exception  {
		return contatoService.atualizarContato(idContato, dto);
	}
	
	//FALTA FAZER

	@DeleteMapping("{idContato}")
	public String delete(@PathVariable UUID idContato) throws Exception {
		
		return contatoService.deletarContato(idContato);
	}

	@GetMapping
	public List<Contato> getAll() throws Exception  {
		
		return contatoService.buscarTodosContatos();
	}

	@GetMapping("{idContato}")
	public Contato getById(@PathVariable UUID idContato) throws Exception {
	
		return contatoService.buscarContatoById(idContato);
	}

}
