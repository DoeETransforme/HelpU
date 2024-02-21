<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>

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
				
				<c:forEach var="proposta" items="${propostas}">
					<div class="posicao-cards">
						<div class="card-doacoes-doador">
							<div class="titulo">
								<h3><a href="<%=request.getContextPath()%>/perfil-ong?id=<c:out value='${proposta.pedidoDoacao.ong.id}'/>">Doação para: <c:out value="${proposta.pedidoDoacao.ong.nome}" /></a></h3>
							</div>
							<p>feito em: <c:out value="${proposta.dataCriacao}" /></p>
							<span><a href="<%=request.getContextPath()%>/historico-doacoes?id=<c:out value='${proposta.id}'/>">Ver mais</a></span>
						</div>
					</div>	
				</c:forEach>	
				
				</div>
			</div>

		</div>

	
	
	</div>
 
	
 

 
</body>
</html>
