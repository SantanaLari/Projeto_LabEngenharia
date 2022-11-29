create database bibilioteca1
go
use bibilioteca1
go
create table livro(
id int,
nome varchar(50),
autor varchar(30),
editora varchar(30),
ano int,
area varchar(10),
caminho varchar(25),
disponibilidade varchar(3)
primary key(id)
)
go
create table locacao(
id int,
livro int,
dataIni date,
dataFim date
primary key(id)
foreign key(livro) references livro(id)
)
go
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

--PROCEDURE PARA ATUALIZAR LIVRO
create procedure p_atualizaLivro(@id int)
as
	declare @nome varchar(30),
			@autor varchar(30),
			@editora varchar(30),
			@ano int
	set @nome = (select nome from livro where id = @id)
	set @autor = (select autor from livro where id = @id)
	set @editora = (select editora from livro where id = @id)
	set @ano = (select ano from livro where id = @id)
 
	update livro
	set nome = @nome, autor = @autor, editora = @editora, ano = @ano
	where id = @id
 
--PROCEDURE PARA MUDAR A DISPONIBILIDADE DE LIVRO
create procedure p_Disponibilidade(@id int, @valor char(3))
as
	update livro
	set disponibilidade = @valor
	where id = @id
 
--PROCEDURE PARA DEVOLUÇÃO DE LIVRO
create procedure p_devolucao(@id int)
as
	EXEC p_Disponibilidade @id, 'Sim'
 
--PROCEDURE INSERIR LOCACAO DE LIVRO
create procedure p_locacao(@nome varchar(30))
as
	declare @id int,
		    @dataIni date,
			@dataFim date
	set @id = (select id from livro where nome = @nome)
	set @dataIni = GETDATE();
	set @dataFim = DATEADD(WEEK, 2, @dataIni)
 
	update locacao
	set livro = @nome, dataIni = @dataIni, dataFim = @dataFim
	EXEC p_Disponibilidade @id, 'Não'
 
--FUNCTION QUE RETORNA A TABELA DE LOCACAO
CREATE FUNCTION fn_locacao()
RETURNS @locacao TABLE (
id INT,
livro INT,
dataIni DATE,
dataFim DATE
)
AS
BEGIN
	INSERT INTO @locacao(id, livro, dataIni, dataFim)
		SELECT id, livro, dataIni, dataFim FROM locacao
	RETURN 
END

--FUNCTION QUE RETORNA LIVROS POR AREA
CREATE FUNCTION fn_livroarea(@pesquisa varchar(250))
RETURNS @table TABLE (
nome VARCHAR (30),
disponibilidade VARCHAR (3),
caminho VARCHAR (25)
)
AS
BEGIN
	DECLARE @id int,
			@nome varchar(30), 
			@disponibilidade varchar(3), 
			@caminho varchar(25)

	SET @nome = (SELECT nome FROM livro WHERE area = @pesquisa)
	SET @id = (SELECT id FROM livro WHERE nome = @nome)
	SET @disponibilidade = (SELECT disponibilidade FROM livro WHERE id = @id)
	SET @caminho = (SELECT caminho FROM livro WHERE id = @id)

	INSERT INTO @table VALUES (@nome, @disponibilidade, @caminho)
	RETURN
END

--FUNCTION QUE RETORNA LIVROS POR NOME
CREATE FUNCTION fn_livronome(@pesquisa varchar(250))
RETURNS @table TABLE (
nome VARCHAR (30),
disponibilidade VARCHAR (3),
caminho VARCHAR (25)
)
AS
BEGIN
	DECLARE @id int,
			@nome varchar(30), 
			@disponibilidade varchar(3), 
			@caminho varchar(25)

	SET @id = (SELECT id FROM livro WHERE nome = @pesquisa)
	SET @nome = (SELECT nome FROM livro WHERE id = @id)
	SET @disponibilidade = (SELECT disponibilidade FROM livro WHERE id = @id)
	SET @caminho = (SELECT caminho FROM livro WHERE id = @id)

	INSERT INTO @table VALUES (@nome, @disponibilidade, @caminho)
	RETURN
END