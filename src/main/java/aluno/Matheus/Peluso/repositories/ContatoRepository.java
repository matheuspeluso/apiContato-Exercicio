package aluno.Matheus.Peluso.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import aluno.Matheus.Peluso.entities.Contato;
import aluno.Matheus.Peluso.factories.ConnectionFactory;

public class ContatoRepository {
	
	public void create(Contato contato) throws Exception {
		var connection = ConnectionFactory.getConnection();
		var statement = connection.prepareStatement("INSERT INTO contatos(idContato,nome,email,telefone) VALUES (?,?,?,?)");
		
		statement.setObject(1, contato.getIdContato());
		statement.setString(2, contato.getNome());
		statement.setString(3, contato.getEmail());
		statement.setString(4, contato.getTelefone());
		statement.execute();
		
		connection.close();
	}
	
	public void update(Contato contato) throws Exception {
		var connection = ConnectionFactory.getConnection();
		var statement = connection.prepareStatement("UPDATE contatos SET nome=?, email=?, telefone=? WHERE idContato =?");
		
		statement.setString(1, contato.getNome());
		statement.setString(2, contato.getEmail());
		statement.setString(3, contato.getTelefone());
		statement.setObject(4, contato.getIdContato());
		statement.execute();
		
		connection.close();
	}
	
	public void delete(UUID idAluno) throws Exception {
		var connection = ConnectionFactory.getConnection();
		var statement = connection.prepareStatement("DELETE FROM contatos WHERE idContato =?");
		
		statement.setObject(1, idAluno);
		statement.execute();
		
		connection.close();
	}
	
	public List<Contato> getAll() throws Exception {
		var connection = ConnectionFactory.getConnection();
		var statement = connection.prepareStatement("SELECT idContato, nome, email, telefone FROM contatos ORDER BY name");
		
		var lista = new ArrayList<Contato>();
		var resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			var contato =  new Contato();
			contato.setIdContato(UUID.fromString(resultSet.getString("idContato")));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));
			
			lista.add(contato);
		}
		connection.close();
		return lista;
	}
	
	public Contato getById(UUID idContato) throws Exception {
		var connection = ConnectionFactory.getConnection();
		var statement = connection.prepareStatement("SELECT idContato, nome, email, telefone FROM contatos WHERE idContato=?");
		
		statement.setObject(1, idContato);
		var resultSet = statement.executeQuery();
		
		Contato contato = null;
		
		if(resultSet.next()) {
			contato.setIdContato(UUID.fromString(resultSet.getString("idContato")));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));
		}
		connection.close();
		return contato;
		
	}
}
