<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
<link rel="stylesheet" href="../css/editar-proposta.css">
</head>
<body>
	<div class="menu-hamburguer" id="menu-hamburguer">
	
		<div class="hamburguer" onclick="toggleMenu()">☰</div>
	</div>
	
	<div class="menu-lateral" id="menu-lateral">
		<c:choose>
					<c:when test="${tipoUsuario == 1}">

						<%@ include file="menu.jsp" %>

					</c:when>
				</c:choose>
	</div>



	<div class="titulo">
		<h1>Esqueceu sua senha?</h1>
		<p>Insira seu e-mail de cadastro e mandaremos um código de
			confirmação com 6 digitos para você!</p>
			<p>Se ocorrer de o código não chegar, reenvie a solicitação.</p>
	</div>

	<form action="" class="forms">
	<div><input class="padrao-input" id="emailReconfirmar" placeholder="Insira o Email" required /></div>

	<button type="submit" class="padrao-submit"  id="invalidar-proposta">Enviar Email</button>
</form>
	
</body>

</html>