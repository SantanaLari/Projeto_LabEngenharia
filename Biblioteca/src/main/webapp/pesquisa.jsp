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

	<div>
		<jsp:include page="menu.jsp" />
	</div>

	<br />

	<div align="center">
		<form action="pesquisa" method="get">
			<table>
				<tr>
					<td colspan="4"><input class="input_data" type="text"
						id="pesquisa" name="pesquisa" placeholder="Pesquise aqui"></td>
				</tr>
				<tr>
					<td><input type="submit" id="botao" name="botao"
						value="Área do Livro"></td>
					<td><input type="submit" id="botao" name="botao"
						value="Nome do Livro"></td>
				</tr>
			</table>
		</form>
	</div>

	<br />

	<div align="center">
		<c:if test="${not empty livros } ">
			<table class="table_round">
				<thead>
					<c:forEach items="${livros } " var="l">
						<tr>
							<td><c:out value="${l.nome }" /></td>
							<td><c:out value="${l.disponibilidade }" /></td>
							<td><button type="submit" aria-label="Detalhes">
									<img src="${l.caminho }">
								</button></td>
						</tr>
					</c:forEach>
				</thead>
			</table>
		</c:if>
	</div>

	<br />

	<div align="center">
		<c:if test="${not empty erro } ">
			<h2>
				<c:out value="${erro }" />
			</h2>
		</c:if>
	</div>
	<div align="center">
		<c:if test="${not empty saida } ">
			<h3>
				<c:out value="${saida }" />
			</h3>
		</c:if>
	</div>

	<div align="center">
		<c:if test="${not empty livros } ">
			<form action="pesquisa" method="post">
				<table class="table_round">
					<thead>
						<tr>
							<th><b>Nome</b></th>
							<th><b>Disponível</b></th>
						</tr>
					</thead>
				</table>
			</form>
			<tbody>
				<c:forEach items="${livros } " var="l">
					<tr>
						<td><c:out value="${l.nome }" /></td>
						<td><c:out value="${l.disponibilidade }" /></td>
						<td><button type="submit" aria-label="Detalhes">
								<img src="${l.caminho }">
							</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</c:if>
	</div>

</body>
</html>