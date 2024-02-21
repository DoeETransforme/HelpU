<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excluir proposta</title>
<link rel="stylesheet" href="../css/excluir-proposta.css">
<!-- <script><%@include file="/resources/js/Script.js"%></script> -->
</head>
<body>
	<div class="menu-hamburguer" id="menu-hamburguer">
	
		<div class="hamburguer" onclick="toggleMenu()">☰</div>
	</div>
	
	<div class="menu-lateral" id="menu-lateral">
		<c:choose>
					<c:when test="${tipoUsuario == 2}">

						<%@ include file="menu.jsp" %>

					</c:when>
				</c:choose>
	</div>
	<div class="titulo">
		<h1>Excluir Proposta</h1>
		<h2>Tem certeza que deseja excluir essa proposta?</h2>
	</div>


	<div>
		<c:if test="${proposta != null}">
			<input type="hidden" name="id"
				value="<c:out value='${proposta.id}' />" />
		</c:if>
	</div>
	<div class="excluir-proposta">
		<a href="<%=request.getContextPath()%>/perfil-doador?id=<c:out value='${proposta.id}'/>" class="Voltar"> Voltar</a>
		<a href="<%=request.getContextPath()%>/proposta-excluida?id=<c:out value='${proposta.id}'/>" class="Voltar">Confirmar</a>
	</div>


</body>
</html>