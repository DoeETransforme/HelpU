<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
<script><%@include file="/resources/js/Script.js"%></script>
<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>

<script><%@include file="/resources/js/menu-topo.js"%></script>

<style type="text/css"> <%@include file="../css/resultado-pesquisa.css"%></style>

</head>
<body>
    <%@ include file="../cabecalhos/menu.jsp" %>

	<div class="container">
		<div class="titulo-pesquisa">
			<h1>Resultados da Pesquisa</h1>
		</div>
		<div class="linha-resultado"></div>
		<div>
			<div class="titulo-ong-pesquisa">
				<h2>Perfis encontrados:</h2>
			</div>
			<div class="perfil-encontrado">
				<c:forEach var="pedido" items="${pedidos}">
					<div class="card-ong-pesquisa">
						<img alt="foto do doador" id="foto-pesquisa" src="<c:out value='${pedido.ong.fotoUsuario.urlFoto()}'/>">
						<span><c:out value="${pedido.ong.nome}" /></span>

					</div>
				</c:forEach>
			</div>
		</div>
		
		<div class="linha-resultado"></div>
		<h2>Pedidos encontrados :</h2>
		
		<div class="container-card">

			<c:forEach var="pedido" items="${pedidos}">
				<div class="card-pedidos">
					<img alt="foto pedidos" id="foto-descricao-pedido" src="<c:out value='${pedido.foto.urlFoto()}'/>">
					<div class="descricao-card">
						<span class="titulo-card"><c:out value="${pedido.titulo}" /></span>
						<span class="nome-card">Por <c:out value="${pedido.ong.nome}" /></span> 
						<span>Status<c:out value="${pedido.statusPedido}" /></span> 
						<span>Iniciada em: <c:out value="${pedido.data}" /></span> 
						<a class="botao" id="botao-descricao" href="<%=request.getContextPath()%>/descricao-pedido?id=<c:out value='${pedido.id}'/>">Leia Mais</a>
					</div>

				</div>
			</c:forEach>
		</div>

	</div>
</body>
</html>