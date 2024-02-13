<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
<title>Helpu</title>

</head>

<body>

	<%@ include file="menu.jsp"%>

	<main>
		<div>
			<h1>Histórico de Pedidos da ONG</h1>



			<table>
				<c:forEach var="pedidos" items="${pedidos}">

					<div>

							<h2>
								Doações para <span id="Nome_Ong">${pedidos.ong.nome}</span>
							</h2>
							<h3>Titulo: <span id="titulo-pedido">${pedidos.titulo}</span></h3>
							<h3>
								Status: <span id="Status_Ong">${pedidos.statusPedido}</span>
							</h3>
          <h3>
							Meta de doações: <span id="Meta-Doacoes">${pedidos.metaDoacoes}</span>
						</h3>
							<p>${pedidos.descricao}</p> 
							<img src="" alt="imagem de perfil da ong">
						</div>
        <a href="<%request.getServletContext();%>editar-pedido?id=<c:out value='${pedidos.id}'/>">Editar</a>
				<a href="<%request.getServletContext();%>excluir-pedido?id=<c:out value='${pedidos.id}'/>">Excluir</a>
		</div>
	</main>

</body>

</html>