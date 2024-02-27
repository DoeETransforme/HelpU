<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
			<!DOCTYPE html>
			<html lang="pt-br">

			<head>
				<meta charset="UTF-8">
				<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
				<title>Helpu</title>
				<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
				<script><%@include file="/resources/js/Script.js"%></script> 
				<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
				<style type="text/css"> <%@include file="../css/historico-pedidos.css"%></style>
			</head>

			<body>
				<%@ include file="../cabecalhos/menu.jsp" %>
				
							<div class="titulo">
								<h1>Histórico de Pedidos da ONG</h1>
							</div>

	<div class="container">
		<c:forEach var="pedidos" items="${pedidos}">

			<div class="card-pedidos">
				<img alt="foto pedido" id="foto-descricao-pedido" src="<c:out value='${pedidos.foto.urlFoto()}'/>">
			<div class="descricao-card">
				<span class="titulo-card">Doações para ${pedidos.ong.nome}</span> 
				<span class="texto-card">Status:${pedidos.statusPedido}</span> 
				<span class="texto-card">Meta de doações: ${pedidos.metaDoacoes}</span> 
				<a class="botao-pedido" <%-- href="<%request.getServletContext();%>excluir-pedido?id=<c:out value='${pedidos.id}'/>" --%>>Lista de Propostas</a>
			</div>
			</div>
		</c:forEach>
	</div>

</body>

			</html>