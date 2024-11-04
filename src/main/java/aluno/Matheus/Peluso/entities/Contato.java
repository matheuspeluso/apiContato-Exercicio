package aluno.Matheus.Peluso.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_contato")
public class Contato {
	
	@Id
	@Column(name = "id")
	private UUID idContato;
	
	@Column(name = "nome" , length = 150, nullable = false)
	private String nome;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "telefone", length = 15, nullable = false, unique = true)
	private String telefone;
}
