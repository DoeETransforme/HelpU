<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Helpu</title>
 <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
<!--  <script src="../js/Script.js"></script> -->
<script><%@include file="/resources/js/Script.js"%></script>
<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
<style type="text/css"> <%@include file="/resources/css/perfil-doador.css"%></style>
t

</head>
<body>
 
						<%@ include file="../cabecalhos/menu.jsp" %>

 
	<div class="perfil-doador">	
		<div class="informacoes-doador">
			<div class="imagem-doador"><img src="../imagens/perfil-icon.png " alt="Imagem de Perfil"></div>
				
				
				<div class="nome-doador">
					<h1><c:out value="${doador.nome}" /></h1>
					<p>Quantidade de conquistas: <c:out value="${qntdConquistas}" /></p>
				</div>
				
		</div>
		
		<div class="linha"></div>
		
		<div class="main-doador">
			<div class="botoes-doador">
				<button onclick="exibirHistorico()" class="padrao-input">Histórico de Doações</button>
				<button onclick="exibirConquistas()" class="padrao-input">Exibir Conquistas</button>
				<a class="botao-editar-perfil" href="<%=request.getContextPath()%>/editar-perfil-doador?id=<c:out value='${doador.id}'/>">
					<svg class="icone-editar-perfil" viewBox="0 0 50 50" fill="none" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
						<rect width="50" height="50" fill="url(#pattern0)"/>
						<defs>
						<pattern id="pattern0" patternContentUnits="objectBoundingBox" width="1" height="1">
						<use xlink:href="#image0_1412_273" transform="scale(0.01)"/>
						</pattern>
						<image id="image0_1412_273" width="100" height="100" xlink:href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAYAAABw4pVUAAAACXBIWXMAAAsTAAALEwEAmpwYAAAB50lEQVR4nO3dQUrDQBiG4fEE/SeViF5DlLpx5U2EmtELuHDh0htJM927cC14CqHgvjJUpBvRdibJB3lfmF0hIQ8/ZJjSOkdERERERESS+Xm8SGvo+yC3wbAmrqyJn3a7uOShCGD4ENdpgSKEAYogBiiCGKAIYoAiiAGKIAYoghigFG194EN8zcXYQlmxo8+svl4eWWjfCqKwo88NFMFqJkWvGhS9alC673D+fLzL56d37YmF9p23rw6ahMWpD/HDmvgw1KSk1+GqaWdu7E2+MbYeTO8oYPyCMQQKGH9g9IkCxj8x+kABY0eMLlHA2BOjCxQwMjFKooBR/jxjbxQwCmPkocQXNn3OufQQSmL8rCbe73rI5caeLzwZuZMy6nzHGKAIYngmRQ8DFEEMUAQx0krXT4dWbux5EQz2GQ4MqTyToZMHQycPhk4eDJ3AEAoMocAQCgyhwBAKDKHAEAoMocAQCgyhwBAKDKHAEAoMocAQCgyhwBAKDKHAEAoMocAQCgyhpiGeKXzX1vNPBZt8iI9DY1T8qo4GiIGhA2Jg6IAYGDogBoYOiIGhA2Jg6IAYGDogBoYOiIGhAwKGEAgYQiBgCIGAIQQChhAIGAWrQryyEJ9yVnWzPC95T0REREREREREROR67wsbDgorGklEEAAAAABJRU5ErkJggg=="/>
						</defs>
					</svg>
					Editar Perfil
			   </a>
			</div>
			
			
			
			<div class="ultimas-doacoes">
				<div class="titulo" id="titulo-doador">
					<h2>Últimas Doações:</h2>
				</div>
				<div class="posicao-cards">
				<c:forEach var="proposta" items="${propostas}">
					
						<div class="card-doacoes-doador">
							<div class="titulo">
								<h3><a href="<%=request.getContextPath()%>/perfil-ong?id=<c:out value='${proposta.pedidoDoacao.ong.id}'/>">Doação para: <c:out value="${proposta.pedidoDoacao.ong.nome}" /></a></h3>
							</div>
							 <c:out value="${proposta.pedidoDoacao.descricao}" />
						</div>
						
				</c:forEach>	
				</div>
				</div>
			</div>

		</div>

	
	
	</div>
 
	
 

 
</body>
</html>
