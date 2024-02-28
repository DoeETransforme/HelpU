<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<!DOCTYPE html>
		<html lang="pt-br">

		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>HelpU</title>
			<link rel="stylesheet" href="../css/estilo.css">
			<script><%@include file = "/resources/js/Script.js" %></script>

			<style type="text/css">
				<%@include file="../css/menu-topo.css" %>
			</style>
			<style type="text/css">
				<%@include file="../css/estilo.css" %>
			</style>

			<script><%@include file = "/resources/js/menu-topo.js" %></script>
			<link rel="stylesheet" href="../css/historico-doacoes.css">


			<style type="text/css">
				<%@include file="../css/historico-doacoes.css" %>
			</style>

		</head>

		<body>
			<%@ include file="../cabecalhos/menu.jsp" %>

				<main>
					<div class="titulo">
						<h1>Seu histórico de doações</h1>
					</div>

					<div id="display">
						<c:forEach var="propostaDoacao" items="${propostasDoacoes}">
							
								<div class="card-proposta1">
									<div class="conteudo1">
										<p class="paragrafo-historico">Doação para:${propostaDoacao.pedidoDoacao.ong.nome}</p>
										<p>Por: ${propostaDoacao.doador.nome}</p>
										<p>Status: ${propostaDoacao.statusProposta}</p>
										<a class="botao-pedido"
											href="<%=request.getContextPath()%>/descricao-proposta?id=<c:out value='${propostaDoacao.id}'/>">Descrição</a>
									</div>
								</div>
								
						
							
							
							
						</c:forEach>



					
					</div>
				</main>
		</body>

		</html>