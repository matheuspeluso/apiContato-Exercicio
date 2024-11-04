package aluno.Matheus.Peluso.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aluno.Matheus.Peluso.dtos.ContatoRequestDto;
import aluno.Matheus.Peluso.entities.Contato;
import aluno.Matheus.Peluso.repositories.ContatosRepository;

@Service
public class ContatoService {
	
	@Autowired
	ContatosRepository contatosRepository;
	
	//Método para criar contato no banco de dados
	public String criarContato(ContatoRequestDto dto) {
		//regra: não permitir cadastrar 2 contatos com o mesmo telefone
		if(contatosRepository.findByTelefone(dto.getTelefone()) != null) {
			throw new IllegalArgumentException("O telefone informado já está cadastrado, tente outro.");
		}
		
		//capturando os dados do contato
		var contato =  new Contato();
		contato.setIdContato(UUID.randomUUID());
		contato.setNome(dto.getNome());
		contato.setEmail(dto.getEmail());
		contato.setTelefone(dto.getTelefone());
		
		//cadastrando contato no banco de dados
		contatosRepository.save(contato);
		
		//retornando a mensagem de sucesso
		return "Contato cadastrado com sucesso.";
	}
	
	public String atualizarContato(UUID idContato, ContatoRequestDto dto) {
		
		//busca o contato pelo ID
		var contatoExistente = contatosRepository.findById(idContato).orElse(null);
		
		if(contatoExistente == null) {
			throw new IllegalArgumentException("Contato não encontrado.");
		}
		
		//verifica se o telefone já está em uso por outro contato
		if(contatosRepository.existsByTelefoneAndNotId(dto.getTelefone(), idContato)) {
			throw new IllegalArgumentException("O telefone informado já está cadastrado em outro contato. Tente outro telefone.");
		}
		
		contatoExistente.setNome(dto.getNome());
		contatoExistente.setEmail(dto.getEmail());
		contatoExistente.setTelefone(dto.getTelefone());
		
		contatosRepository.save(contatoExistente);
		
		return "Contato atualizado com sucesso.";
	}
	
	public String deletarContato(UUID idContato) throws Exception {
		var contato = contatosRepository.findById(idContato);
		
		if(!contato.isPresent()) {
			throw new IllegalArgumentException("Contato não encontrado, verifique o ID informado.");
		}
		
		contatosRepository.deleteById(idContato);
		return "Contato excluido com sucesso.";		
	}
	
	public List<Contato> buscarTodosContatos() throws Exception{
		return contatosRepository.findAll();
	}
	
	public Contato buscarContatoById(UUID idContato) throws Exception{
		var contato = contatosRepository.findById(idContato);
		
		if(!contato.isPresent()) {
			throw new IllegalArgumentException("Contato não encontrado, verifique o ID informado.");
		}
		
		return contato.get();
	}
	
	
	
	

}
