<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pesquisa</title>
</head>
<body>
	
	<div align="center">
		<form action="pesquisa" method="post">
			<table>
				<tr>
					<td colspan="4">
						<input class="input_data" type="text" id="nome" name="nome" placeholder="Pesquisa">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Pesquisar">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<div align="center">
		<c:if test="${not empty listaLivro }">
			<table class="table_round">
				<thead>
					<tr>
						<th> Nome </th>
						<th> Disponibilidade </th>
						<th> Caminho </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaLivro }" var="livro">
						<tr>
							<td><c:out value="${livro.nome }" /></td>
							<td><c:out value="${livro.disponibilidade }" /></td>
							<td><c:out value="${livro.caminho }" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
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