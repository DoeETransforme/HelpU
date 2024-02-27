<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>HelpU</title>
<link rel="stylesheet" href="../css/estilo.css">
<script><%@include file="/resources/js/Script.js"%></script>

<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
<style type="text/css"> <%@include file="../css/estilo.css"%></style>

<script><%@include file="/resources/js/menu-topo.js"%></script>
  

<style type="text/css"> <%@include file="../css/historico-doacoes.css"%></style>  

</head>
<body>
		<%@ include file="../cabecalhos/menu.jsp" %>
  
    <main>
        <div class="titulo">
			<h1>Seu histórico de doações</h1>
		</div>
 
 		<div class="container">
		<c:forEach var="propostaDoacao" items="${propostasDoacoes}">
			<div class="card-pedidos">
				<div class="descricao-card">					
					<span class="titulo-card">Doação para:${propostaDoacao.pedidoDoacao.ong.nome}</span>
					<span class="texto-card">Por: ${propostaDoacao.doador.nome}</span> 
					<span class="texto-card">Status: ${propostaDoacao.statusProposta}</span>
					<a class="botao-pedido" href="<%=request.getContextPath()%>/descricao-proposta?id=<c:out value='${propostaDoacao.id}'/>">Descrição</a>
				</div>
			</div>
		</c:forEach>
 		</div>
	</main>
</body>
</html>