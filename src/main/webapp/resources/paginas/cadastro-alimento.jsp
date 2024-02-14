<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
<style type="text/css"><%@include file="/resources/css/estilo.css"%></style>
<link rel="stylesheet" href="../css/estilo.css">

</head>
<body>
	<c:choose>
		<c:when test="${tipoUsuario == 2}">

			<%@ include file="menu.jsp"%>

		</c:when>
	</c:choose>
<body>
	<div class="header"> 
		<p>Login</p>
		<img src="../imagens/logo-final.png" alt="imagem da ong">
	</div>

	<div class="titulo">
		<h1>Cadastre o alimento</h1>
	</div>
	<form action="inserir-alimento" method="post" class="cadastrar-alimento">
	
			<div><input type="text" name="nome" placeholder="Nome do alimento" required class= "padrao-input"id="cadastrar-nome-alimento"></div>
			<div><input type="date" name="data" required id="cadastrar-data-alimento" class="padrao-input"></div>
			<div><button type="submit" class="padrao-submit" id="submit-cadastrar-alimento">Cadastro</button></div>
	
	</form>
</body>
</html>