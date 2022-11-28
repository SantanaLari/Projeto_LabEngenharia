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