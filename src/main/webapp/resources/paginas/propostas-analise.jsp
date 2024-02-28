
<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<!DOCTYPE html>
		<html lang="pt-br">

		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>Helpu</title>
			<style type="text/css">
				<%@include file="/resources/css/estilo.css" %>
			</style>
			<style type="text/css">
				<%@include file="/resources/css/propostas-analise.css" %>
			</style>
			<script><%@include file = "/resources/js/Script.js" %></script>
			<style type="text/css">
				<%@include file="../css/menu-topo.css" %>
			</style>
			<link rel="stylesheet" href="../css/propostas-analise.css">
		</head>

		<body>
			<%@ include file="../cabecalhos/menu.jsp" %>


				<main>
					<div>
						<div class="titulo1">
							<h1>Propostas em Análise.</h1>
						</div>

						<div  id="display2" >
							<c:forEach var="proposta" items="${propostas}">

							<div class="card-proposta2">
									<div class="imagem-card1"><img src="../imagens/perfil-icon.png" alt="">
										<p id="doacao-por">
											Doação Por: <span id="nomeUsuario">${proposta.doador.nome}</span>
										</p>
									</div>
									<div class="conteudo1">
										<p>
											No Pedido: <span id="titulo-pedido">${proposta.pedidoDoacao.titulo}</span>
										</p>
										<p>
											Status: <span>${proposta.statusProposta}</span>
										</p>
										<a
											href="<%=request.getContextPath()%>/avaliar-proposta?id=<c:out value='${proposta.id}'/>">Ver
											Mais</a>
									</div>
								</div>
								
								
								
								
								
							</c:forEach>
						</div>

					</div>
				</main>
		</body>

		</html>

