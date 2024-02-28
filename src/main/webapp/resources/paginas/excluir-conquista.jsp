<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excluir Conquista</title>
<link rel="stylesheet" href="../css/excluir-conquista.css">
<!-- 
<script><%@include file="/resources/js/Script.js"%></script> -->
</head>
<body>
	<div class="menu-hamburguer" id="menu-hamburguer">
	
		<div class="hamburguer" onclick="toggleMenu()">☰</div>
	</div>
	
	<div class="menu-lateral" id="menu-lateral">
		<%@ include file="../cabecalhos/menu.jsp" %>
	</div>
	<div class="titulo">
		<h1>Tem certeza que deseja excluir essa conquista?</h1>
	</div>

	<div>

		<c:if test="${conquista != null}">
			<input type="hidden" name="id"
				value="<c:out value='${conquista.id}' />" />
		</c:if>
	</div>
	<div class="excluir-conquista">
		<a href="" class="Voltar" class=""> Voltar</a>
		<a href="" class="Voltar" class="">Confirmar</a>
	</div>

</body>
</html>