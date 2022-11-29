<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comprovante</title>
</head>
<body>

	<div>
		<jsp:include page="menu.jsp" />
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
		<H1>
			<b> EMPRESTIMO REALIZADO COM SUCESSO </b>
		</H1>
	
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