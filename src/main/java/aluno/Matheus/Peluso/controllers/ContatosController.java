package aluno.Matheus.Peluso.controllers;

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

@RestController
@RequestMapping("api/contatos")
public class ContatosController {
	
	@PostMapping
	public void post(@RequestBody ContatoRequestDto request) throws Exception{
		//TODO
	}
	
	@PutMapping("{id}")
	public void put(@PathVariable UUID idContato, @RequestBody ContatoRequestDto request) throws Exception{
		//TODO
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable UUID idContato) throws Exception{
		//TODO
	}
	
	@GetMapping
	public void get() throws Exception{
		//TODO
	}
}
