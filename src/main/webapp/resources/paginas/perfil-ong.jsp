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
						<c:out value="${ong.cnpj}" />
					</p>

				</div>


					<a href="<%=request.getContextPath()%>/historico-pedidos"> <button>Historico de pedidos  </button></a>

			</section>
			<section>

				<h1>Atualizações da ONG</h1>

				<c:forEach var="pedidos" items="${pedidos}">

					<div>
						<h2>
							Doações para: <span id="Nome_Ong"><c:out
									value="${pedidos.ong.nome}" /> </span>
						</h2>
							<h3>Titulo: <span id="titulo-pedido-perfil">${pedidos.titulo}</span></h3>
						<h3>
							Status: <span id="Status_Ong"><c:out
									value="${pedidos.statusPedido}" /> </span>
						</h3>
						<p>
							Descrição do pedido:
							<c:out value="${pedidos.descricao}" />
						</p>
						<img src="" alt="imagem de perfil da ong">
					</div>

				</c:forEach>



			</section>
		</main>
	</div>
</body>
</html>