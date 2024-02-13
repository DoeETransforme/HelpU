<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=
    , initial-scale=1.0">
<title>HelpU</title>
<link rel="stylesheet" href="../css/estilo.css">
    <!--<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>-->

</head>

<body>
	<c:choose>
		<c:when test="${tipoUsuario == 2}">

			<%@ include file="menu.jsp"%>

		</c:when>
	</c:choose>

	<main>

		<div class="titulo">
			<h1>
				Titulo:
				<c:out value="${pedidoDoacao.titulo}" />
			</h1>
			<img src="Imagem.png" alt="" id="capa_pedido"> <img src=""
				alt="" class="ImagemPerfil_PF">
			<p>
				Por: <span id="NomeCompletoOng"> <c:out
						value="${pedidoDoacao.ong.nome}" />
				</span>
			</p>
		</div>




		<div class="descricao">
			<p>DESCRIÇÃO DO PEDIDO:</p>
			<div>
				<h3>Progressão do Pedido:</h3>
				<h4>Status do Pedido:</h4>
				<p>
					<span id="Status_pedido"> <c:out
							value="${pedidoDoacao.StatusPedido }" />
					</span>
				</p>
			</div>
			<!--barra de progresso-->
			<div class="barra-progresso">
				<progress value="50" max="100"></progress>
			</div>
		</div>
		<div>

			<a href="Cadastro_proposta.jsp">
				<button type="button" class="padrao-input">Ajude e doe
					agora mesmo!</button>
			</a>

		</div>

		<div class="titulo">
			<h2>Doadores:</h2>
		</div>

		<div class="imagem-com-descricao">
			<img src="../imagens/perfil-icon.png" alt="Foto de Perfil">
			<p>Enya Lohana doou 5kg de arroz</p>
		</div>
		<div class="titulo">
			<h3>Conheça outros projetos de doações:</h3>
		</div>


		<div class="">
			<img src="imagem.jpg" alt="capa de projeto" id="capa_pedido">
		</div>
		<div>
			<img src="imagem.jpg" alt="capa de projeto" id="capa_pedido">
		</div>
	</main>
</body>

</html>