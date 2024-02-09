<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ page isELIgnored="false" %>
			<!DOCTYPE html>
			<html lang="pt-br">

			<head>
				<meta charset="UTF-8">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<link rel="stylesheet" href="../css/estilo.css">
				<title>Helpu</title>
				<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
			</head>

			<body>

				<%@ include file="menu.jsp" %>

					<main>
						<div class="header"> 
							<p>Login</p>
							<img src="../imagens/logo-final.png" alt="imagem da ong">
						</div>
						<section>
							<div>
								<div class="titulo">
									<h1>Fazer uma doação</h1>
									<p>
										Para a ONG: <c:out value="${proposta.pedido.ong.nome}"></c:out>
										<br>
										O que você gostaria de doar?
									</p>
								</div>


								<form action="inserir-proposta" method="post" class="forms">


									<div>
										<div>
										
									
											<select name="pedido" class="padrao-input">
												<c:forEach var="pedido" items="${pedidos}">
													<option value="${pedido.id}">${pedido.titulo}</option>
												</c:forEach>
											</select>
										</div>
										<div>
											
											<select name="alimento" class="padrao-input">
												<c:forEach var="alimento" items="${alimentos}">
													<option value="${alimento.id}">${alimento.nome}</option>
												</c:forEach>
											</select>
										</div>

										<div>
											
											<input type="text" name="quantidade" placeholder="Quantidade" required
												class="padrao-input">

										</div>

										<div>
											
											<input type="date" name="data-validade" required class="data-nascimento-padrao" >
										</div>
									</div>


									<input type="submit" value="Confirmar" class="padrao-submit">
								</form>
							</div>
						</section>
					</main>

			</body>

			</html>