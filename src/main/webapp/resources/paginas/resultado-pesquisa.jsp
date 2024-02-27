<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
<script><%@include file="/resources/js/Script.js"%></script>
<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
<script><%@include file="/resources/js/menu-topo.js"%></script>
</head>
<body>
    <%@ include file="../cabecalhos/menu.jsp" %>

	
	<h1>Resultados da Pesquisa</h1>

	<div>
		<h2>Perfis encontrados:</h2>

		<c:forEach var="pedido" items="${pedidos}">
			<div>
				<p>
					<c:out value="${pedido.ong.nome}" />
				</p>
			</div>
		</c:forEach>
		
	</div>
	<h2>Pedidos encontrados :</h2>
	<div>

		<c:forEach var="pedido" items="${pedidos}">
			<div class="imagem-card" id="div-imagem-card">
			<img alt="foto pedidos" id="imagem-pedidos" src="<c:out value='${pedido.foto.urlFoto()}'/>"></div>
			<div>
				<p>
					<c:out value="${pedido.titulo}" />
				</p>

				<p>
					<strong>status</strong>
					<c:out value="${pedido.statusPedido}" />
				</p>

				<p>
					<strong>Iniciada em: </strong>
					<c:out value="${pedido.data}" />
				</p>

			</div>
		</c:forEach>
	</div>
</body>
</html>