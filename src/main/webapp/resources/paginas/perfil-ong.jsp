<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/estilo.css">
<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
<script><%@include file="/resources/js/Script.js"%></script>
<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
<title>Helpu</title>



</head>

<body>
	<%@ include file="../cabecalhos/menu.jsp"%>

	<main class="perfil-ong">
		<section>
			<!-- <div class="foto-capa-nome-ong">
				<img src="../imagens/Capa de Perfil da Ong.png" alt="" id="capa-ong">
 -->
				<div class="foto-nome-ong">
					<div class="foto-ong">
						<img alt="foto do ong" id="foto" src="<c:out value='${ong.fotoUsuario.urlFoto()}'/>">
					</div>
					<div class="nome-ong">
						<h2>


							
							<c:out value="${ong.nome}" />

						</h2>
					</div>
				</div>
			</div>
		</section>

		<div class="informacoes-ong">

			<div class="butoes-ong">
				<div class="contato-ong">
					<h2>Contatos</h2>
					<div class="contato-item">
						<img src="../imagens/Telefone.png" alt="">
						<p>
							Telefone:
							<c:out value="${contato.celular}" />
						</p>
					</div>
					<div class="contato-item">
						<img src="../imagens/Email.png" alt="">
						<p>
							Email:
							<c:out value="${contato.email}" />
						</p>
					</div>
				</div>

				<div class="opcoes-ong">
					<button>Histórico de pedidos</button>
					<div class="opcao-item">
						<img src="../imagens/Lapis.png" alt=""> <a>Editar Perfil</a>
					</div>
					<div class="opcao-item">
						<img src="../imagens/Mais.png" alt=""> <a>Criar novo
							Pedido</a>
					</div>
				</div>

			</div>



			<div class="ultimos-pedidos-ong">
				<div class="titulo">
					<h3>Ultimos Pedidos</h3>
				</div>

				<c:forEach var="pedidos" items="${pedidos}">
					<div class="pedidos-doacao-perfil-ong">
						<div class="imagem-pedido-perfil-ong">
							<img src="../imagens/imagem-pedido.png" alt="foto-ong"
								id="imagem-pedido-perfil-ong">
						</div>
						<div class="conteudo-pedido-perfil-ong">
							<h3>
								Titulo:<span id="TituloPedido">${pedidos.titulo}</span>
							</h3>

							<span id="TituloPedido">${pedidos.data}</span> <span>${pedidos.descricao}</span>
							<a
								href="<%=request.getContextPath()%>/descricao-pedido?id=<c:out value='${pedidos.id}'/>">Ver
								Mais</a>
						</div>
					</div>

					<div class="pedidos-doacao-perfil-ong">
						<div class="imagem-pedido-perfil-ong">
							<img src="../imagens/imagem-pedido.png" alt="foto-ong"
								id="imagem-pedido-perfil-ong">
						</div>
						<div class="conteudo-pedido-perfil-ong">
							<h3>
								Titulo:<span id="TituloPedido">${pedidos.titulo}</span>
							</h3>

							<span id="TituloPedido">${pedidos.data}</span> <span>${pedidos.descricao}</span>
							<a
								href="<%=request.getContextPath()%>/descricao-pedido?id=<c:out value='${pedidos.id}'/>">Ver
								Mais</a>
						</div>
					</div>
					</c:forEach>
					</div>
		</div>

		</div>
	</main>
	</div>
</body>

</html>