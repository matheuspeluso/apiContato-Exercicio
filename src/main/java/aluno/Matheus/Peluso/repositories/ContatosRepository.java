package aluno.Matheus.Peluso.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import aluno.Matheus.Peluso.entities.Contato;

@Repository
public interface ContatosRepository extends JpaRepository<Contato, UUID> {
	
	//Método para consultar 1 contato no bando de dados atravez do telefone
	@Query("FROM Contato ctt WHERE ctt.telefone = :telefone")
	Contato findByTelefone(@Param("telefone") String telefone);
	
	//permite que você verifique se existe um contato com o mesmo telefone e um idContato diferente, tratando corretamente a identificação com UUID.
	@Query("SELECT CASE WHEN COUNT(ctt) > 0 THEN true ELSE false END FROM Contato ctt WHERE ctt.telefone = :telefone AND ctt.idContato <> :idContato")
	boolean existsByTelefoneAndNotId(@Param("telefone") String telefone, @Param("idContato") UUID idContato);

}
