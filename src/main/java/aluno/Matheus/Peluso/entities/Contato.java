package aluno.Matheus.Peluso.entities;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Contato {
	private UUID idContato;
	private String nome;
	private String email;
	private String telefone;
}
