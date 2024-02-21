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
</head>
<body>
 
 
 
	<h1>Invalidar Proposta</h1>
	<h2>Tem certeza que deseja invalidar essa proposta?</h2>
 
 
	<div>
		<c:if test="${proposta != null}">
			<input type="hidden" name="id"
				value="<c:out value='${proposta.id}' />" />
		</c:if>
	</div>
	<a href="historico-pedidos" class="Voltar"> Voltar</a>
	<a href="<%=request.getContextPath()%>/proposta-recusada?id=<c:out value='${proposta.id}'/>" class="Voltar">Confirmar</a>
 
 
</body>
</html>