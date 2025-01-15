CREATE TABLE contatos(
	idContato		UUID				PRIMARY KEY,
	nome			VARCHAR(250)		NOT NULL,
	email			VARCHAR(50)			NOT NULL,
	telefone		VARCHAR(20)			NOT NULL
);

--Para consultar todos os dados da tabela
SELECT * FROM contatos;