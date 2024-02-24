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
				<%@ include file="../cabecalhos/menu.jsp" %>


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
									 <img alt="foto do ong" id="foto-ong-pedido" src="<c:out value='${ongFoto.fotoUsuario.urlFoto()}'/>">
									 <span id="NomeCompletoOng">
										De <c:out value="${pedido.ong.nome}" />
									 </span>
									 <span id="DataPedido">
										em <c:out value="${pedido.data}" />
									</span>
								</div>
						</div>
					</div>


					<br>


					<div class="descricao-pedido">
						<h2 class="titulo">SOBRE O PEDIDO:</h2>
						<span id="DescricaoPedido">
									<c:out value="${pedido.descricao}" />
								</span>

						<br>
						<div class="status-pedido">
							<h4>Status do Pedido: </h4>
							<span id="ativo"><c:out value="${pedido.statusPedido}" /></span>						
						</div>
						
						<div class="progresso-doacao">
							<h4 class="titulo-progresso">Progressão da doação:</h4>
							<div id="barra-progressao"></div>
								<!-- <div class="barra-progresso">
									<progress value="50" max="100"></progress>
								</div> -->
						</div>

						

					</div>
					<div class="ajude-pedido">
							<button id="cadastrar-proposta-descricao"  type="button" class="padrao-submit"><a href="<%=request.getContextPath()%>/cadastro-proposta?id=<c:out value='${pedido.id}'/>">Cadastrar Proposta</a></button>

					</div>

					<div class="titulo">
						<h2>Doadores:</h2>
					</div>
					
							
							<c:forEach var="propostas" items="${propostas}">  
								<a href="<%=request.getContextPath()%>/descricao-proposta?id=<c:out value='${propostas.id}'/>">	
          							<tr>			
				          				<td><c:out value="${propostas.doador.nome}" /></td>				          								          			                   
          							</tr>
          							
          							<c:forEach var="item" items="${propostas.itens}">
								            <span> <c:out value="${item.quantidade}" /></span>
								            <span><c:out value="${item.alimento.dataValidade}" /></span>
	           						</c:forEach>             							 
          						</a>
							</c:forEach>
							
							<h1> Veja outros pedidos ativos:</h1>
												
							<c:forEach var="pedido" items="${pedidos}">
								            <span> <c:out value="${pedido.titulo}" /></span>
								            <span> <c:out value="${pedido.descricao}" /></span>
								            <span> <c:out value="${pedido.data}" /></span>
								            <span> <c:out value="${pedido.metaDoacoes}" /></span>
	           				</c:forEach>         
					
					<div class="">
						<img src="imagem.jpg" alt="capa de projeto" id="capa_pedido">
					</div>
				</main>
			</body>

			</html>