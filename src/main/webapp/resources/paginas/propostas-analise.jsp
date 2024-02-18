<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Helpu</title>
<link rel="stylesheet" href="../css/estilo.css">
 <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
 <script><%@include file="/resources/js/Script.js"%></script>
</head>
<body>
	<div class="menu-hamburguer" id="menu-hamburguer">
	
		<div class="hamburguer" onclick="toggleMenu()">☰</div>
	</div>
	
	<div class="menu-lateral" id="menu-lateral">
		<c:choose>
					<c:when test="${tipoUsuario == 2}">

						<%@ include file="menu.jsp" %>

					</c:when>
				</c:choose>
	</div>

	<main>
		<div>
			<div class="titulo">
				<h1>Propostas em Análise.</h1>
			</div>
			<c:forEach var="propostaDoacao" items="${propostasDoacoes}">
				<div class="propostas-doacao-analise">
					<div class="imagem-card"><img src="../imagens/perfil-icon.png" alt=""></div>
					<div class="conteudo">				
						<p>
							Doação Por: <span id="nomeUsuario">${propostaDoacao.doador.nome}</span>
						</p>
						<p>
							No Pedido: <span id="titulo-pedido">${propostaDoacao.pedidoDoacao.titulo}</span>
						</p>
						<p>
							Status: <span>${propostaDoacao.statusProposta}</span>
						</p>
					</div>
				</div>
				
			</c:forEach>
			

		</div>
	</main>
</body>
</html>