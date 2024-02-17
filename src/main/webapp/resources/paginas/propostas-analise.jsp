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
</head>
<body>
	<%@ include file="menu.jsp"%>

	<main>
		<div>
			<div class="titulo">
				<h1>Propostas em Análise.</h1>
			</div>
			
			<c:forEach var="proposta" items="${propostas}">	
				
				<div class="propostas-doacao-analise">
					<div class="imagem-card"><img src="../imagens/perfil-icon.png" alt=""></div>
					
					<div class="conteudo">				
						<p>
							Doação Por: <span id="nomeUsuario">${proposta.doador.nome}</span>
						</p>
						<p>
							No Pedido: <span id="titulo-pedido">${proposta.pedidoDoacao.titulo}</span>
						</p>
						<p>
							Status: <span>${proposta.statusProposta}</span>
						</p>
						<a href="<%=request.getContextPath()%>/avaliar-proposta?id=<c:out value='${proposta.id}'/>">Ver Mais</a>
						
					</div>
					
				</div>
				
			</c:forEach>
			

		</div>
	</main>
</body>
</html>