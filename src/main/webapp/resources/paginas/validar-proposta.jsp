<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
<script><%@include file="/resources/js/Script.js"%></script>
<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
<link rel="stylesheet" href="../css/estilo.css">
</head>
<body>
 
	<%@ include file="../cabecalhos/menu.jsp"%>
 
	<div class="titulo">
		<h1>Validar Proposta</h1>
		<h2>Tem certeza que deseja validar essa proposta?</h2>
	</div>
 
 
	<div>
		<c:if test="${proposta != null}">
			<input type="hidden" name="id"
				value="<c:out value='${proposta.id}' />" />
		</c:if>
	</div>
	<div class="validar-proposta">
		<a href="historico-pedidos" class="Voltar"> Voltar</a>
		<a href="<%=request.getContextPath()%>/proposta-aceita?id=<c:out value='${proposta.id}'/>" class="Voltar">Confirmar</a>
	</div>
 
 
</body>
</html>