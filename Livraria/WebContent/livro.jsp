<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

<link rel="stylesheet" href="./css/style.css">
<title>Cadastro - Livro</title>
</head>
<body>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

	<div>
		<jsp:include page="menu.jsp" />
	</div>

<div class="container">

    <div align="center">
					<c:if test="${not empty erro }">
						<H4>
							<c:out value="${erro }" />
						</H4>
					</c:if>
				</div>
				<div align="center">
					<c:if test="${not empty saida }">
						<H4>
							<c:out value="${saida }" />
						</H4>
					</c:if>
				</div>
				
  <form action="livro" method="post">
    <div class="row">
      <h4> Imagem </h4>
      <div class="input-group input-group-icon">
        <input type="text" placeholder="EM MANUTENÇÃO" name="AUSENTE" id="AUSENTE"/>
        <div class="input-icon"><i class="fa fa-user"></i></div>
      </div>
      
      <h4> Dados do livro </h4>
      <div class="input-group input-group-icon">
        <input type="number" placeholder="ID" name="id" id="id"/>
        <div class="input-icon"><i class="fa fa-user"></i></div>
      </div>
      
      <div class="input-group input-group-icon">
        <input type="text" placeholder="Nome" name="nome" id="nome"/>
        <div class="input-icon"><i class="fa fa-envelope"></i></div>
      </div>
      
      <div class="input-group input-group-icon">
        <input type="text" placeholder="Autor" name="autor" id="autor"/>
        <div class="input-icon"><i class="fa fa-envelope"></i></div>
      </div>
      
      <div class="input-group input-group-icon">
        <input type="text" placeholder="Editora" name="editora" id="editora"/>
        <div class="input-icon"><i class="fa fa-envelope"></i></div>
      </div>
      
      <div class="input-group input-group-icon">
        <input type="number" placeholder="Ano" name="ano" id="ano"/>
        <div class="input-icon"><i class="fa fa-envelope"></i></div>
      </div>
      
      <div class="input-group input-group-icon">
        <input type="text" placeholder="Area" name="area" id="area"/>
        <div class="input-icon"><i class="fa fa-envelope"></i></div>
      </div>
      
      <div class="input-group input-group-icon">
        <input type="text" placeholder="Caminho" name="caminho" id="caminho"/>
        <div class="input-icon"><i class="fa fa-envelope"></i></div>
      </div>
      
      <div class="input-group input-group-icon">
        <input type="text" placeholder="Disponibilidade" name="disponibilidade" id="disponibilidade"/>
        <div class="input-icon"><i class="fa fa-envelope"></i></div>
      </div>
      
	    </div>
	    	<input type="submit" id="botao" name="botao" value="Salvar"> 
	    </div>
	    
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