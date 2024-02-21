<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
 <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
<script><%@include file="/resources/js/Script.js"%></script>
<link rel="stylesheet" href="../css/menu-topo.css">
</head>
<body>
	<%@ include file="../cabecalhos/menu.jsp" %>




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