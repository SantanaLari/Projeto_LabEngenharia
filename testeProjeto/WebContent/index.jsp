<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div alig="center">
		<H1> TESTE </H1>
		<hr>
	</div>
	<div align="center">
		<form action="livro" method="post">
			<table>
				<tr>
					<td>
<!-- 					<input type="submit" id="botao" name="botao" value="Salvar"> -->
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<div align="center">
		<c:if test="${not empty listLivro }">
			<table class="table_round">
				<thead>
					<tr>
						<th class="th_dash">Nome</th>
						<th class="th_dash">Disponibilidade</th>
						<th class="th_dash">Caminho</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listLivro }" var="l">
					<tr>
						<td><c:out value="${l.nomeCompleto }"/></td>
						<td><c:out value="${l.disponibilidade }"/></td>
						<td><c:out value="${l.caminho }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
<!--  	
	<div align = "center">
		<table class="table_round">
			<thead>
				<tr>
					<th class="th_dash"><b>#ID</b></th>
					<th class="th_dash"><b>Nome</b></th>
					<th class="th_dash"><b>Data de Nascimento</b></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="td_groove">1</td>
					<td class="td_groove">Fulano</td>
					<td class="td_groove" align="center">22/09/1982</td>
				</tr>
				<tr>
					<td class="td_groove">2</td>
					<td class="td_groove">Beltrano</td>
					<td class="td_groove" align="center">12/04/1973</td>
				</tr>
				<tr>
					<td class="td_groove">3</td>
					<td class="td_groove">Cicrano</td>
					<td class="td_groove" align="center">15/08/1992</td>
				</tr>
			</tbody>
		</table>
	</div>
	-->
	<div align="center">
		<c:if test="${not empty erro }">
			<H2><c:out value="${erro }" /></H2>
		</c:if>
	</div>
	<div align="center">
		<c:if test="${not empty saida }">
			<H3><c:out value="${saida }" /></H3>
		</c:if>
	</div>
	
</body>
</html>