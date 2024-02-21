<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
</head>
<body>
	<div class="menu-hamburguer" id="menu-hamburguer">

		<div class="hamburguer" onclick="toggleMenu()">☰</div>
	</div>

	<div class="menu-lateral" id="menu-lateral">

		<%@ include file="menu.jsp"%>

	</div>
	
	<h1>Resultados da Pesquisa</h1>

	<div>
		<h2>Perfis encontrados:</h2>

		<c:forEach var="pedido" items="${pedidos}">
			<div>
				<p>
					<c:out value="${pedido.ong.nome}" />
				</p>
			</div>
		</c:forEach>
		
	</div>
	<h2>Pedidos encontrados :</h2>
	<div>

		<c:forEach var="pedido" items="${pedidos}">
			<div>
				<p>
					<c:out value="${pedido.titulo}" />
				</p>

				<p>
					<strong>status</strong>
					<c:out value="${pedido.statusPedido}" />
				</p>

				<p>
					<strong>Iniciada em: </strong>
					<c:out value="${pedido.data}" />
				</p>

			</div>
		</c:forEach>
	</div>
</body>
</html>