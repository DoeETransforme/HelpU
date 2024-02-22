<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excluir pedido</title>
<link rel="stylesheet" href="../css/excluir-pedido.css">
<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
<!--  <script src="../js/Script.js"></script> -->
<script><%@include file="/resources/js/Script.js"%></script>
<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>

</head>
<body>
	    <div class="menu-hamburguer" id="menu-hamburguer">
	
    <div class="hamburguer" onclick="toggleMenu()">☰</div>
</div>
 
<div class="menu-lateral" id="menu-lateral">
    <c:choose>
                <c:when test="${tipoUsuario == 2}">
 
                    <%@ include file="../cabecalhos/barra-lateral.jsp" %>
 
                </c:when>
            </c:choose>
            </div>

	<div class="titulo">
		<h1>Tem certeza que deseja excluir esse pedido?</h1>
	</div>


	<div>
		<c:if test="${pedido != null}">
			<input type="hidden" name="id" value="<c:out value='${pedido.id}' />" />
		</c:if>
	</div>
	<div class="excluir-pedido">
		<a href="<%=request.getContextPath()%>/perfil-ong?id=<c:out value='${pedido.id}'/>" class="Voltar" class=""> Voltar</a>
		<a href="<%=request.getContextPath()%>/pedido-excluido?id=<c:out value='${pedido.id}'/>" class="Voltar" class="">Confirmar</a>
	</div>


</body>
</html>