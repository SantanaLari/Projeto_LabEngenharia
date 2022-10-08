<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<title>Login</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	
	<div class="card text-center" style="width: 18rem;">
  	<div class="card-body">
    <h5 class="card-title">LOGIN</h5>
    	<div class="input-group flex-nowrap">
  		<span class="input-group-text" id="addon-wrapping">E-mail:</span>
  		<input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
		</div>
		
		<br />
		
		<div class="input-group flex-nowrap">
  		<span class="input-group-text" id="addon-wrapping">Senha:</span>
  		<input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
		</div>
		
		<br />
		
    	<a href="#" class="btn btn-primary">Login</a>
 	</div>
	</div>

	
</body>
</html>