
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
<!--  <script src="../js/Script.js"></script> -->
<script><%@include file="/resources/js/Script.js"%></script>
 

</head>
<body>
 
	<div class="menu-hamburguer" id="menu-hamburguer">
	
		<div class="hamburguer" onclick="toggleMenu()">☰</div>
	</div>
	
	<div class="menu-lateral" id="menu-lateral">
		<c:choose>
					<c:when test="${tipoUsuario == 1}">

						<%@ include file="menu.jsp" %>

					</c:when>
				</c:choose>
	</div>
 
	<div class="perfil-doador">
		
		
		<div class="informacoes-doador">
			<div class="imagem-doador"><img src="../imagens/perfil-icon.png " alt="Imagem de Perfil"></div>
				
				
				<div class="nome-doador">
					<h1><c:out value="${doador.nome}" /></h1>
					<p>Quantidade de conquistas: <c:out value="${qntdConquistas}" /></p>
				</div>
		</div>

		<div class="main-doador">
			<div class="botoes-doador">
				<button onclick="exibirHistorico()" class="padrao-input">Histórico de Doações</button>
				<button onclick="exibirConquistas()" class="padrao-input">Exibir Conquistas</button>
				<a href="">Editar Perfil</a>
			</div>
			<div class="ultimas-doacoes">
				<div class="titulo" id="titulo-doador">
					<h2>Últimas Doações:</h2>
				</div>

				<div class="posicao-cards">
					<div class="card-doacoes-doador">
						<div class="titulo">
							<h3>Doação para: humanidade Acionada</h3>
						</div>
						<p>feito em: </p>
						<button>Ver mais</button>
					</div>
					<div class="card-doacoes-doador">
						<div class="titulo">
							<h3>Doação para: humanidade Acionada</h3>
						</div>
						<p>feito em: </p>
						<button>Ver mais</button>
					</div>
					<div class="card-doacoes-doador">
						<div class="titulo">
							<h3>Doação para: humanidade Acionada</h3>
						</div>
						<p>feito em: </p>
						<button>Ver mais</button>
					</div>
				</div>
			</div>

		</div>

	
	
	</div>
 
	
 

 
</body>
</html>
