<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<%@ page isELIgnored="false" %>
			<!DOCTYPE html>
			<html lang="pt-br">

			<head>
				<meta charset="UTF-8">
				<meta name="viewport" content="width=
    , initial-scale=1.0">
				<title>HelpU</title>
				<link rel="stylesheet" href="../css/estilo.css">
				 <!-- <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style> --> 

			</head>

			<body>
				<c:choose>
					<c:when test="${tipoUsuario == 2}">

						<%@ include file="menu.jsp" %>

					</c:when>
				</c:choose>

				<main>

					<div class="titulo">
						<h1>
							Titulo:
							<c:out value="${pedidoDoacao.titulo}" />
						</h1>
					</div>


					<div class="imagem-do-pedido"><img src="../imagens/imagem-pedido.png" alt="" id="capa_pedido">

						<div class="informacao-pedido">
							<img src="../imagens/perfil-icon.png" alt="">
							<p>
								de: <span id="NomeCompletoOng">
									<c:out value="${pedidoDoacao.ong.nome}" />
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
							<h4>Status do Pedido: <p>
									<c:out value="${pedidoDoacao.StatusPedido }" />
								</p>
							</h4>
						</div>


					</div>
					<div class="ajude-pedido">

						<a href="Cadastro_proposta.jsp">
							<button type="button" class="padrao-input">Ajude e doe
								agora mesmo!</button>
						</a>

					</div>

					<div class="titulo">
						<h2>Doadores:</h2>
					</div>

					<div class="doadores-pedido">
						<img src="../imagens/perfil-icon.png" alt="Foto de Perfil">
						<p>Enya Lohana doou <strong>5kg</strong> de <strong>arroz</strong></p>
					</div>
					<div class="doadores-pedido">
						<img src="../imagens/perfil-icon.png" alt="Foto de Perfil">
						<p>Enya Lohana doou <strong>5kg</strong> de <strong>arroz</strong></p>
					</div>
					<br>

					<div class="titulo">
						<h3>Conheça outros projetos de doações:</h3>
					</div>


					<div class="conheca-pedidos">
						<div class="card-pedido">
							<img src="../imagens/Sem título.png" alt="capa de projeto" id="capa_pedido">
							<div class="conteudo-pedido">
								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ab possimus itaque veniam natus saepem. Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nesciunt, vero aspernatur? Aliquam, optio necessitatibus ab ullam aspernatur atque repudiandae dolorem, dolorum voluptatum numquam itaque facilis nisi omnis alias quaerat eveniet.</p>
							</div>
							<button> Connheça</button>
						</div>
						<div class="card-pedido">
							<img src="../imagens/Sem título.png" alt="capa de projeto" id="capa_pedido">
							<div class="conteudo-pedido">
								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ab possimus itaque veniam natus saepem. Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nesciunt, vero aspernatur? Aliquam, optio necessitatibus ab ullam aspernatur atque repudiandae dolorem, dolorum voluptatum numquam itaque facilis nisi omnis alias quaerat eveniet.</p>
							</div>
							<button> Connheça</button>
						</div>
						<div class="card-pedido">
							<img src="../imagens/Sem título.png" alt="capa de projeto" id="capa_pedido">
							<div class="conteudo-pedido">
								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ab possimus itaque veniam natus saepem. Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nesciunt, vero aspernatur? Aliquam, optio necessitatibus ab ullam aspernatur atque repudiandae dolorem, dolorum voluptatum numquam itaque facilis nisi omnis alias quaerat eveniet.</p>
							</div>
							<button> Connheça</button>
						</div>
					</div>
					
					
					<div class="">
						<img src="imagem.jpg" alt="capa de projeto" id="capa_pedido">
					</div>
				</main>
			</body>

			</html>