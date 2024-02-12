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

	<div>
		<c:choose>
			<c:when test="${tipoUsuario == 2}">

				<%@ include file="menu.jsp"%>

			</c:when>
		</c:choose>

		<main>
			<section>
				<div>

					<img src="imagem.com" alt="foto de perfil da ong">
				</div>
			</section>
			<section>
				<div>
					<h1>Contatos</h1>
					<p>
						<strong>Telefone:</strong>
						<c:out value="${contato.celular}" />
					</p>
					<p>
						<strong>Email:</strong>
						<c:out value="${contato.email}" />
					</p>

				</div>
				<button>Histórico de pedidos</button>
			</section>
			<section>
				<h1>Atualizações da ONG</h1>
				<c:forEach var="pedidos" items="${pedidos}">
				<div>
					<img src="imagem.com" alt="foto-ong">
					<h2>
						Titulo <span id="TituloPedido">${pedidos.titulo}</span>
					</h2>
					<p>
						${pedidos.descricao}
					</p>
				</div>
			</c:forEach>

			</section>
		</main>
	</div>
</body>
</html>