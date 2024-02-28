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
				<link rel="stylesheet" href="../css/historico-pedidos.css">
			</head>

			<body>
				<%@ include file="../cabecalhos/menu.jsp" %>
				
							<div class="titulo1">
								<h1>Histórico de Pedidos da ONG</h1>
							</div>


		<section id="display3">
			<c:forEach var="pedidos" items="${pedidos}" >
			
						<div class="card-completo1">
							<div class="imagem-card-pedidos1">
								<img alt="foto pedido"  src="<c:out value='${pedidos.foto.urlFoto()}'/>">
								</div>
							<div class="descricao-card1">
								<p id="doacoes-para">Doações para ${pedidos.ong.nome}</p>
								<p>Status:${pedidos.statusPedido}</p>
								<p> meta de doações: ${pedidos.metaDoacoes}</p>
								<a class="botao-pedido"href="<%request.getServletContext();%>excluir-pedido?id=<c:out value='${pedidos.id}'/>">Excluir Pedido</a>
							</div>
						</div>
						
						</c:forEach>
						</section>
						
						
						
				
				
				
				



</body>

			</html>