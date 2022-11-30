<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
  	
	<div align="center">
		<form action="livro" method="get">
			<table>
				<tr>
					<td>
						<input type="submit" name="botao" id="botao" value="Visualizar">  
					</td>
				</tr>
			</table>
		</form>
	</div>

<div align="center">
		<div align="center">
			<c:if test="${not empty listaLivro }">
				<table class="table_round">
					<thead>
						<tr>
							<th> Nome </th>
							<th> Autor </th>
							<th> Disponibilidade </th>
							<th> Empréstimo </th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaLivro }" var="livro">
						
						<c:set var="cond" value="0" scope="page"> </c:set>
					
							<c:forEach var="indisponivel" items="${listaIndisponivel }">
								<c:if test="${livro.disponibilidade == indisponivel.disponibilidade }">
						
									<c:set var="cond" value="2" scope="page"> </c:set>			
									<tr align="justify">
										<td style="color:#A9A9A9"><c:out value="${livro.nome }" /></td>
										<td style="color:#A9A9A9"><c:out value="${livro.autor }" /></td>
										<td style="color:#A9A9A9"><c:out value="${livro.disponibilidade }" /></td>
									
									</tr>
								</c:if>
							</c:forEach>
							
							<c:if test="${cond == 0 }">
								<tr align="justify">
									<td><c:out value="${livro.nome }" /></td>
									<td><c:out value="${livro.autor }" /></td>
									<td><c:out value="${livro.disponibilidade }" /></td>
									<td>
										<form action="locacao.jsp">
											<input type="submit" name="submit" value="Locacao">
										</form>
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
</div>

</body>
</html>