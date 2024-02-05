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
</head>

<body>
	<%@ include file="menu.jsp"%>

	<main>
		<div>
			<h1>Titulo:</h1>
			<p>
				<c:out value="${pedidoDoacao.titulo}" />
			</p>


			<img src="Imagem.png" alt="" id="capa_pedido"> <img src=""
				alt="" class="ImagemPerfil_PF">
			<p>
				Por <span id="NomeCompletoOng"> <c:out
						value="${pedidoDoacao.ong.nome}" />
				</span>
			</p>
		</div>
		<div>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut aliquip ex ea commodo consequat. Duis aute irure dolor in
				reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
				pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
				culpa qui officia deserunt mollit anim id est laborum. Ut enim ad
				minima veniam, quis nostrum exercitationem ullam corporis suscipit
				laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem
				vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil
				molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas
				nulla pariatur?</p>
		</div>
		<div>
			<h3>Progressão do Pedido</h3>
			<h4>Status do Pedido:</h4>
			<p>
				<span id="Status_pedido"><c:out
						value="${pedidoDoacao.StatusPedido }" /></span>
			</p>
		</div>
		<!--barra de progresso-->
		<div>
			<progress value="50" max="100"></progress>
		</div>
		<div>
		
		<a href="Cadastro_proposta.jsp" class="botão_padrão">
    <button type="button">Ajude e doe agora mesmo!</button>
</a>

		</div>
		
		<div>
			<h1>Doadores</h1>
		</div>
		<div>
			<img src="Imagem.jpg" alt="Foto de Perfil" class="ImagemPerfil_PF">
			<p>
				<span id=nome>Enya Lohana</span> doou <span class="Quantidade">5kg</span>
				de <span class="Item">arroz</span>
			</p>
		</div>
		<div>
			<h2>Conheça outros projetos de doações</h2>
		</div>
		<div>
			<img src="imagem.jpg" alt="capa de projeto" id="capa_pedido">
		</div>
		<div>
			<img src="imagem.jpg" alt="capa de projeto" id="capa_pedido">
		</div>
	</main>
</body>

</html>