<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- CSS only
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
-->
<link rel="stylesheet" href="./css/style.css">
<title>Cadastro - Estudante</title>
</head>
<body>
	<!-- JavaScript Bundle with Popper 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
-->
	<div>
		<jsp:include page="menu.jsp" />
	</div>

	<div class="container">
		<form>
			<div class="row">
				<h4>Curso</h4>
				<div class="col-third">
					<div class="input-group">
						<select>
							<option>ADS</option>
							<option>Comex</option>
							<option>DSM</option>
						</select>
					</div>
				</div>

				<h4>Dados pessoais</h4>
				<div class="input-group input-group-icon">
					<input type="text" placeholder="E-mail" />
					<div class="input-icon">
						<i class="fa fa-user"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<input type="password" placeholder="Senha" />
					<div class="input-icon">
						<i class="fa fa-envelope"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<input type="password" placeholder="Confirmar senha" />
					<div class="input-icon">
						<i class="fa fa-key"></i>
					</div>
				</div>

				<div class="input-group input-group-icon">
					<input type="text" placeholder="RA" />
					<div class="input-icon">
						<i class="fa fa-key"></i>
					</div>
				</div>


			</div>
			<input type="submit" id="enviar" name="enviar" value="Enviar">
	</div>
	</form>
	</div>

</body>
</html>