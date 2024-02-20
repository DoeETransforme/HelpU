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
<script><%@include file="/resources/js/Script.js"%></script>

</head>
<body>
	<div class="menu-hamburguer" id="menu-hamburguer">
	
		<div class="hamburguer" onclick="toggleMenu()">☰</div>
	</div>
	
	<div class="menu-lateral" id="menu-lateral">
		<%@ include file="../cabecalhos/menu.jsp" %>
	</div>
<body>
	<div class="header"> 
		<p>Login</p>
		<img src="../imagens/logo-final.png" alt="imagem da ong">
	</div>

	<div class="titulo">
		<h3>Cadastre o alimento</h3>
	</div>
	<form action="inserir-alimento" method="post" class="cadastrar-alimento">
	
			<div><input type="text" name="nome" placeholder="Nome do alimento" required class= "padrao-input"id="cadastrar-nome-alimento"></div>
			<div><input type="date" name="data" required id="cadastrar-data-alimento" class="padrao-input"></div>
			<div><button type="submit" class="padrao-submit" id="submit-cadastrar-alimento">Cadastro</button></div>
	
	</form>
</body>
</html>