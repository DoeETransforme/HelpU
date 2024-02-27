<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>HelpU</title>

			<script><%@include file="/resources/js/Script.js" %></script>
      
			<style type="text/css">
				<%@include file="/resources/css/estilo.css" %>
			</style>
			<style type="text/css">
				<%@include file="../css/menu-topo.css" %>
			</style>
			<link rel="stylesheet" href="../css/estilo.css">
		</head>

		<body>
			<%@ include file="../cabecalhos/menu.jsp" %>


				<main>

					<div class="descricao-proposta">


						<div class="avaliar-proposta">
							<img src="../imagens/perfil-icon.png" alt="Imagem de perfil do usuário"
								id="imagem-PF-avaliarProposta">
							<h2>Doação de:
								<c:out value="${proposta.doador.nome}" />
							</h2>
						</div>

						<div class="linha"></div>

						<div class="descricao-proposta-conteudo">
							<span class="descricao-span">Doação feita no pedido: ${proposta.pedidoDoacao.titulo}</span>
							<span class="descricao-span">Status da proposta: ${proposta.statusProposta}</span>
							<span class="descricao-span">Tipo de item doado: Alimento</span>

							<c:forEach var="item" items="${proposta.itens}">
								<span class="descricao-span">Quantidade Doada: ${item.quantidade}</span>
								<span class="descricao-span">Validade: ${item.alimento.dataValidade}</span>
							</c:forEach>
						</div>

						<div class="linha"></div>
						
						<div class="editar-deletar">
							<a id="editar" class="botao-link"
								href="<%=request.getContextPath()%>/editar-proposta?id=<c:out value='${proposta.id}'/>">Editar</a>
							<a id="deletar" class="botao-link"
								href="<%=request.getContextPath()%>/excluir-proposta?id=<c:out value='${proposta.id}'/>">Deletar</a>
						</div>
					</div>
					</div>








				</main>
		</body>

		</html>