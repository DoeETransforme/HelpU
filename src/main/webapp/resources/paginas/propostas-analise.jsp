<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Helpu</title>
 <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
 <style type="text/css"> <%@include file="/resources/css/propostas-analise.css"%></style>
 <script><%@include file="/resources/js/Script.js"%></script>
 <style type="text/css"> <%@include file="../css/menu-topo.css"%></style>

 <link rel="stylesheet" href="../css/propostas-analise.css">

 
 <style type="text/css"> <%@include file="/resources/css/propostas-analise.css"%></style> 

</head>
<body>
		<%@ include file="../cabecalhos/menu.jsp" %>


	<main>

			<div>
			<div class="titulo">
				<h1>Propostas em Análise.</h1>
			</div>
			
			<div class="container">
			<c:forEach var="proposta" items="${propostas}">					
				<div class="card-pedidos">
					<div class="ajuste-titulo">
							<img alt="foto pedido" id="foto-descricao-pedido" src="<c:out value='${proposta.doador.fotoUsuario.urlFoto()}'/>">						
							<span class="titulo-card" id="nomeUsuario">Doação Por: </span>
							<span class="titulo-card" id="nomeUsuario">${proposta.doador.nome}</span>
						</div>
						<div class="descricao-card">
							 <span class="texto-card">No Pedido: ${proposta.pedidoDoacao.titulo}</span>
							 <span class="texto-card">Status: ${proposta.statusProposta}</span>

						<a class="botao-pedido" href="<%=request.getContextPath()%>/avaliar-proposta?id=<c:out value='${proposta.id}'/>">Ver Mais</a>						
					</div>			
				</div>	

			</c:forEach>
			</div>

		</div>
	</main>
</body>
</html>