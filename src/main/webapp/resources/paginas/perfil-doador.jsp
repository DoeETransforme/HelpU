
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
 <!--<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>-->
 

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
 
	<div class="editar-perfil-doador">
		
		
		<div class="informacoes-doador">
			<div class="imagem-doador"><img src="../imagens/perfil-icon.png " alt="Imagem de Perfil"></div>
				
				
				<div class="nome-doador">
					<h1>Fernanda dos santos</h1>
					<p>Quantidade de conquistas: 0</p>
				</div>
		</div>

		<div class="botoes-doador">
			<div>
				<button onclick="exibirHistorico()">Histórico de Doações</button>
				<button onclick="exibirConquistas()">Exibir Conquistas</button>
				<a href="">Editar Perfil</a>
			</div>
			<div>
				<h2>Últimas Doações</h2>

				<div>
					<p>Doação para: humanidade Acionada</p>
					<p>feito em: </p>


					<button>ver mais</button>
				</div>
			</div>

		</div>

	
	
	</div>
 
	
 

 
</body>
</html>
