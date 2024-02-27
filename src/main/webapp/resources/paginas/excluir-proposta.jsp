<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excluir proposta</title>
<style type="text/css"> <%@include file="../css/excluir-proposta.css"%></style>
<script><%@include file="/resources/js/Script.js"%></script>
<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
<style type="text/css"> <%@include file="../css/estilo.css"%></style>
</head>
<body>
		<%@ include file="../cabecalhos/menu.jsp" %>
	
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
		<a href="<%=request.getContextPath()%>/propostas-pendentes?id=<c:out value='${proposta.id}'/>" class="Voltar">Confirmar</a>
	</div>


</body>
</html>