CREATE DATABASE livraria
use livraria

CREATE TABLE Funcionario
(
email			VARCHAR(100),
senha			VARCHAR(20),
confirmaSenha	VARCHAR(20),
cargo			VARCHAR(100),
RF				VARCHAR(20),
PRIMARY KEY(email)
)

CREATE TABLE Estudante
(
email			VARCHAR(100),
senha			VARCHAR(20),
confirmaSenha	VARCHAR(20),
curso			VARCHAR(100),
RA				VARCHAR(20),
PRIMARY KEY(email)
)

CREATE TABLE livro
(
id				INT,
nome			VARCHAR(100),
autor			VARCHAR(100),
editora			VARCHAR(100),
ano				INT,
area			VARCHAR(50),
caminho			VARCHAR(50),
disponibilidade	VARCHAR(4)
PRIMARY KEY(id)
)

select nome, autor from livro WHERE disponibilidade != 'sim'

CREATE TABLE locacao
(
id		INT,
email	VARCHAR(100),
dataIni	VARCHAR(20),
dataFim	VARCHAR(20),
PRIMARY KEY(id)
)
drop table locacao

insert into locacao values
(1, 'aa', '10/12/2002', '15/01/2003')

SELECT * FROM locacao

SELECT * FROM estudante
SELECT * FROM funcionario

select * from livro

select nome, autor, disponibilidade
from livro

CREATE VIEW v_cadastros
AS
SELECT email, curso, RA
FROM Estudante
UNION
SELECT email, cargo, RF
FROM Funcionario

select * from v_cadastros

--------------------------------------- PROCEDURES
--------------------------------------- FUNCIONARIO

ALTER PROCEDURE validaFuncionario(@email VARCHAR(100), @senha VARCHAR(20), @confirmaSenha VARCHAR(20),
		@cargo VARCHAR(100), @RF VARCHAR(20))
AS
	DECLARE @validaFuncionario INT,
			@validaEstudante INT

	SET @validaFuncionario = (SELECT COUNT(*) FROM Funcionario WHERE email = @email)
	SET @validaEstudante = (SELECT COUNT(*) FROM Estudante WHERE email = @email)

	IF ((@validaFuncionario = 1) OR (@validaEstudante = 1))
	BEGIN
		RAISERROR('Esse e-mail já está cadastrado no sistema',16,1)
	END
	ELSE
	BEGIN
		PRINT 'email valido'

		IF(@senha = @confirmaSenha)
		BEGIN
			PRINT 'Senhas iguais'
			INSERT INTO Funcionario VALUES
			(@email, @senha, @confirmaSenha, @cargo, @RF)
		END
		ELSE 
		BEGIN
			RAISERROR('As senhas não são iguais',16,1)
		END
	END
----------------------------------------- ESTUDANTE
ALTER PROCEDURE validaEstudante(@email VARCHAR(100), @senha VARCHAR(20), @confirmaSenha VARCHAR(20),
		@curso VARCHAR(100), @RA VARCHAR(20))
AS
	DECLARE @validaFuncionario INT,
			@validaEstudante INT

	SET @validaFuncionario = (SELECT COUNT(*) FROM Funcionario WHERE email = @email)
	SET @validaEstudante = (SELECT COUNT(*) FROM Estudante WHERE email = @email)

	IF ((@validaFuncionario = 1) OR (@validaEstudante = 1))
	BEGIN
		RAISERROR('Esse e-mail já está cadastrado no sistema',16,1)
	END
	ELSE
	BEGIN
		PRINT 'email valido'

		IF(@senha = @confirmaSenha)
		BEGIN
			PRINT 'Senhas iguais'
			INSERT INTO Estudante VALUES
			(@email, @senha, @confirmaSenha, @curso, @RA)
		END
		ELSE 
		BEGIN
			RAISERROR('As senhas não são iguais',16,1)
		END
	END

------------------------------------ LOGIN
CREATE PROCEDURE p_validaLogin(@e VARCHAR(100), @s VARCHAR(100))
AS
	DECLARE @validaFuncionario INT,
			@validaEstudante INT,
			@senha INT

	SET @validaFuncionario = (SELECT COUNT(*) FROM Funcionario WHERE email = @e)
	SET @validaEstudante = (SELECT COUNT(*) FROM Estudante WHERE email = @e)
	

	IF(@validaFuncionario = 1) --O email é de funcionario
	BEGIN
		SET @senha = (SELECT COUNT(*) FROM Funcionario WHERE senha = @s)
		IF(@senha = 0)
		BEGIN
			RAISERROR('Email ou senha incorreto',16,1)
		END
		ELSE
		BEGIN
			PRINT 'Bem-vindo'
		END
	END
	ELSE
	IF(@validaEstudante = 1) --O email é de estudante
	BEGIN
		SET @senha = (SELECT COUNT(*) FROM Estudante WHERE senha = @s)
		IF(@senha = 0)
		BEGIN
			RAISERROR('Email ou senha incorreto',16,1)
		END
		ELSE
		BEGIN
			PRINT 'Bem-vindo'
		END
	END
----------------------------------------------------------------------------------------
 INSERT INTO livro VALUES
 --( '--------------------------------------------------', '------------------------------', '------------------------------'),
 (1, '1 Busines Venture: with pratice for the TOEIC test', 'Roger Barnard e Jeff Cady', 'Oxford', 2009, 'Outro', '/webapp/img/livro1.png', 'sim'),
 (2, '2 Busines Venture: with pratice for the TOEIC test', 'Roger Barnard e Jeff Cady', 'Oxford', 2009, 'Outro', '/webapp/img/livro2.png', 'sim'),
 (3, 'Gestão de Pessoas: Abordagem Pós-Moderna', 'Marly Cavalcanti', 'Juruá Editora', 2009, 'Outro', '/webapp/img/livro3.png', 'sim'),
 (4, 'Riscos Corporativos', 'Marly Cavalcanti', 'Editora Plêiade', 2007, 'Outro', '/webapp/img/livro4.png', 'sim'),
 (5, 'A Prática do Empreendedorismo', 'Marly Cavalcanti', 'Ottoni', 2010, 'Outro', '/webapp/img/livro5.png', 'sim'),
 (6, 'O Estrangulador', 'Sidney Sheldon', 'Record', 2012, 'Outro', '/webapp/img/livro6.png', 'sim'),
 (7, 'Fundamentos da Auditoria', 'Inaldo Araújo e Daniel Arruda', 'Saraiva', 2012, 'Outro', '/webapp/img/livro7.png', 'sim'),
 (8, 'Fundamentos e Métodos Quantitativos', 'José de Oliveira Siqueira', 'Saraiva', 2011, 'Outro', '/webapp/img/livro8.png', 'sim'),
 (9, 'Questão da Qualidade e do Meio Ambiente', 'Antonio Jr. e Valério Bonelli', 'Atlas', 2010, 'Outro', '/webapp/img/livro9.png', 'sim'),
(10, 'Os Doze Mandamentos', 'Sidney Sheldon', 'Record', 2012, 'Outro', '/webapp/img/livro10.png', 'sim'),
(11, 'Matemática Financeira', 'Aderbal Muller e Luís Antonik', 'Saraiva', 2012, 'Outro', '/webapp/img/livro11.png', 'sim'),
(12, 'A Perseguição', 'Sidney Sheldon', 'Record', 2012, 'Outro', '/webapp/img/livro12.png', 'sim'),
(13, 'Dinâmica de Grupos na Formação das Lembraças', 'Ana Gonçalves e Susan Perpétuo', 'DP&A Editora', 2009, 'Outro', '/webapp/img/livro13.png', 'sim'),
(14, 'Intercambio Comercial e Agronegocio', 'Ministério da Agricultura', 'Mapa', 2010, 'Outro', '/webapp/img/livro14.png', 'sim'),
(15, 'Marley & Eu', 'John Grogan', 'Ediouro', 2006, 'Outro', '/webapp/img/livro15.png', 'sim'),
(16, 'A Menina que Roubava Livros', 'Markus Zusak', 'Intrínseca', 2011, 'Outro', '/webapp/img/livro16.png', 'sim')


select * from livro


