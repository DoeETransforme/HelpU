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

			</head>

			<body>
				<%@ include file="../cabecalhos/menu.jsp" %>


				<main>

					<div class="titulo">
						<h1>
							Titulo:
							<c:out value="${pedido.titulo}" />
						</h1>
					</div>


					<div class="imagem-do-pedido"><img src="../imagens/imagem-pedido.png" alt="" id="capa_pedido">

						<div class="informacao-pedido">
							<img src="../imagens/perfil-icon.png" alt="">
							<p>
								de: <span id="NomeCompletoOng">
									<c:out value="${pedido.ong.nome}" />
								</span>
								em:
							</p>
						</div>
					</div>


					<br>


					<div class="descricao-pedido">
						<h2 class="titulo">SOBRE O PEDIDO:</h2>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Sint voluptatem autem sapiente error
							quibusdam, temporibus placeat minima reprehenderit voluptatibus perspiciatis veritatis
							mollitia facilis omnis commodi? Veniam animi vel porro placeat Lorem ipsum dolor sit amet
							consectetur adipisicing elit. Aspernatur excepturi illum saepe, sapiente ipsum culpa itaque
							eligendi perspiciatis velit similique ea aperiam iure ut omnis optio repellendus facere
							nihil ad. Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt vitae neque unde
							assumenda hic, ducimus earum. Enim consequuntur vero ipsum itaque esse? Officia voluptatum,
							iusto perferendis quae dolorem ipsam nulla?</p>

						<br>


						<div class="progresso-doacao">
							<h4 class="titulo-progresso">Progressão da doação:</h3>
								<div class="barra-progresso">
									<progress value="50" max="100"></progress>
								</div>
						</div>

						<div class="status-pedido">
							<h4>Status do Pedido: </h4>
							<c:out value="${pedido.statusPedido}" />						
						</div>


					</div>
					<div class="ajude-pedido">
							<button type="button" class="botao-padrao"><a href="<%=request.getContextPath()%>/cadastro-proposta?id=<c:out value='${pedido.id}'/>">Cadastrar Proposta</a></button>

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