<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pesquisa Livro</title>
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
		<c:if test="${not empty livros }">
			<table class="table_round">
				<thead>
					<tr>
						<th class="th_dash">Nome</th>
						<th class="th_dash">Disponibilidade</th>
						<th class="th_dash">Caminho</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${livros }" var="l">
					<tr>
						<td><c:out value="${l.nome }"/></td>
						<td><c:out value="${l.disponibilidade }"/></td>
						<td><c:out value="${l.caminho }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>

	<!--  <div align="center">
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
	</div> -->

</body>
</html>