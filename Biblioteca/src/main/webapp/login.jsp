<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styleLogin.css">
<title>Login</title>
</head>
<body>
	<div class="login-root">
		<div class="box-root flex-flex flex-direction--column"
			style="min-height: 100vh; flex-grow: 1;">
			<div
				class="box-root padding-top--24 flex-flex flex-direction--column"
				style="flex-grow: 1; z-index: 9;">
				<div
					class="box-root padding-top--48 padding-bottom--24 flex-flex flex-justifyContent--center">

				</div>
				<div class="formbg-outer">
					<div class="formbg">
						<div class="formbg-inner padding-horizontal--48">
							<span class="padding-bottom--15">Login</span>

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

							<form id="stripe-login" action="login" method="post">
								<div class="field padding-bottom--24">
									<label for="email">Email</label> <input class="input_email"
										type="text" id="email" placeholder="E-mail" name="email"
										value='<c:out value="${login.email }"></c:out>'>

								</div>
								<div class="field padding-bottom--24">
									<div class="grid--50-50">
										<label for="password">Password</label>

									</div>

									<input class="input_senha" type="text" id="senha"
										placeholder="Senha" name="senha"
										value='<c:out value="${login.senha }"></c:out>'>

								</div>

								<br />
								<div class="field padding-bottom--24">
									<input type="submit" id="logar" name="logar" value="Logar">
								</div>

								<div class="footer-link padding-top--24">
									<span>Não tem conta? <a href="opcoes.jsp">Registre-se</a></span>
								</div>
							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>