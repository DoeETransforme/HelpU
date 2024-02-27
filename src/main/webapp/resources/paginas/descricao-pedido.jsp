<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
			<!DOCTYPE html>
			<html lang="pt-br">

			<head>
				<meta charset="UTF-8">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<title>HelpU</title>
				 <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>  
				 <script><%@include file="/resources/js/Script.js"%></script>
				 <style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
				 <style type="text/css"> <%@include file="../css/descricao-pedido.css"%></style>
				<script><%@include file="/resources/js/barra-progressao.js"%></script>
			</head>

<body>
	<%@ include file="../cabecalhos/menu.jsp"%>

	<main>

		<div class="titulo">
			<h1>
				<c:out value="${pedido.titulo}" />
			</h1>
		</div>


		<div class="imagem-do-pedido">
			<img alt="foto pedido" id="imagem-pedido" src="<c:out value='${pedido.foto.urlFoto()}'/>">

			<div class="informacao-pedido">

				<div class="ong-box">
					<img alt="foto do ong" id="foto-ong-pedido"
						src="<c:out value='${ongFoto.fotoUsuario.urlFoto()}'/>"> <span
						id="NomeCompletoOng"> De <c:out value="${pedido.ong.nome}" />
					</span> <span id="DataPedido"> em <c:out value="${pedido.data}" />
					</span>
				</div>
			</div>
		</div>


		<br>


		<div class="descricao-pedido">
			<h2 class="titulo">SOBRE O PEDIDO:</h2>
			<span id="DescricaoPedido"> <c:out value="${pedido.descricao}" />
			</span>

			<div class="linha"></div>

			<div class="status-pedido">
				<h4>Status do Pedido:</h4>
				<span id="ativo"><c:out value="${pedido.statusPedido}" /></span>
			</div>

			<div class="progresso-doacao">
				<h4 class="titulo-progresso">Progressão da doação:</h4>
				<div class="barra-progresso">
					<progress value="50" max="100"></progress>
				</div>
			</div>

		</div>

		<div class="botoes">
			<c:if test="${usuario != ong}">
				<a class="botao" href="<%=request.getContextPath()%>/cadastro-proposta?id=<c:out value='${pedido.id}'/>">Ajude e doe agora mesmo!</a>
			</c:if>
			<c:if test="${usuario == ong}">
				<a class="botao" href="<%=request.getContextPath()%>/editar-pedido?id=<c:out value='${pedido.id}'/>">Deseja editar o pedido?</a>
			</c:if>
		</div>

		<div class="linha"></div>

		<div class="titulo">
			<h2>Doadores:</h2>
		</div>

		<div class="container">
			<c:forEach var="propostas" items="${propostas}">
				<%-- <a href="<%=request.getContextPath()%>/descricao-proposta?id=<c:out value='${propostas.id}'/>"> --%>

				<div class="alinhamento-descricao-proposta">
					<div>
						<img alt="foto do ong" id="foto-descricao-proposta" src="<c:out value='${ongFoto.fotoUsuario.urlFoto()}'/>">
					</div>
					<div class="alinhamento-nome">
						<span><c:out value="${propostas.doador.nome}" /></span>
					</div>
					<c:forEach var="item" items="${propostas.itens}">
						<div class="alinhamento-item">
							<span> doou <c:out value="${item.alimento.nome}" /></span>
							
						</div>
					</c:forEach>
					<div class="linha-doador"></div>
					</div>
				
				<!-- </a> -->


			</c:forEach>
		</div>

		<h1>Veja outros pedidos ativos:</h1>

		<c:forEach var="pedido" items="${pedidos}">
			<div class="card-pedidos">
				<img alt="foto do ong" id="foto-descricao-pedido" src="<c:out value='${pedido.foto.urlFoto()}'/>">
				<div class="descricao-card">
					<span class="titulo-card"><c:out value="${pedido.titulo}" /></span>
					<span class="nome-card">Por <c:out value="${pedido.ong.nome}" /></span> 
					<span class="texto-card"><c:out value="${pedido.descricao}" />
					</span> <a class="botao-pedido"href="<%request.getServletContext();%>/descricao-pedido?id=<c:out value='${pedido.id}'/>">Leia Mais</a>

				</div>
			</div>
		</c:forEach>

	</main>
</body>

</html>