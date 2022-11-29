<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Livro</title>
</head>
<body>

	<div>
		<jsp:include page="menu.jsp" />
	</div>

	<div align="center">
		<H1>
			<b> INSERIR LIVRO </b>
		</H1>
		<form action="livro" method="post">
			<table>
				<tr>
					<td colspan="2"><input class="input_data_date" type="number" id="id" name="id" 
						placeholder="ID"></td>
					<td colspan="3"><input class="input_data" type="text" id="nome" name="nome" 
						placeholder="Nome"></td>
				</tr>
				<tr>
					<td colspan="2"><input class="input_data_date" type="text" id="disponibilidade" 
						name="disponibilidade" placeholder="Disponibilidade"></td>
					<td colspan="3"><input class="input_data" type="text"
						id="editora" name="editora" placeholder="Editora"></td>
				</tr>
				<tr>
					<td colspan="2"><input class="input_data_date" type="number" min="1900" step="1" id="ano" 
						name="ano" placeholder="Ano"></td>
					<td colspan="3"><input class="input_data" type="text" id="autor" name="autor" 
						placeholder="Autor"></td>
				</tr>
				<tr>
					<td colspan="2" class="input_data_date" id="area">
						<select>
							<option value="0">Selecione Área...</option>
						    <option>ADS</option>
						    <option>DSM</option>
						    <option>Comex</option>
						    <option>Logística</option>
						    <option>Polímeros</option>
						    <option>RH </option>
						    <option>Outro</option>
						</select>
					</td>
					<td colspan="3"><input class="input_data" type="text"
						id="imagem" name="imagem" placeholder="Caminho Imagem"></td>
				</tr>
				<tr>
					<td><input type="submit" id="botao" name="botao" value="Cadastrar"></td>
					<td><input type="submit" id="botao" name="botao" value="Atualizar"></td>
					<td><input type="submit" id="botao" name="botao" value="Deletar"></td>
				</tr>
			</table>
		</form>
	</div>

	<div align="center">
		<c:if test="${not empty erro }">
			<H2>
				<c:out value="${erro }" />
			</H2>
		</c:if>
	</div>
	<div align="center">
		<c:if test="${not empty saida }">
			<H3>
				<c:out value="${saida }" />
			</H3>
		</c:if>
	</div>

</body>
</html>