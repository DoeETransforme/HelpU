<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ page isELIgnored="false" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>Insert title here</title>
			<style type="text/css"><%@include file="/resources/css/estilo.css"%></style> 
				<link rel="stylesheet" href="../css/estilo.css">
				<script><%@include file="/resources/js/Script.js"%></script>
			</head>

			<body>

				<div class="menu-hamburguer" id="menu-hamburguer">
	
		<div class="hamburguer" onclick="toggleMenu()">☰</div>
	</div>
	
	<div class="menu-lateral" id="menu-lateral">
		<c:choose>
					<c:when test="${tipoUsuario == 2}">

						<%@ include file="menu.jsp" %>

					</c:when>
				</c:choose>
	</div>
				<%@ include file="menu.jsp" %>
					<div class="header">
						<p>Login</p>
						<img src="../imagens/logo final.png" alt="imagem da ong">
					</div>

					<div class="titulo">
						<h1>CADASTRAR SEU PEDIDO.</h1>
					</div>
					<form action="inserir-pedido" method="post" class="forms">
						<div >
							<input type="text" name="titulo" placeholder="Qual é o título do pedido?" required class="padrao-input">
							<textarea name="descricao" rows="1" placeholder="Escreva sobre o pedido!" class="padrao-input"></textarea>
							<div  id= "div-titulo">
								<h4  class="titulo">O que você deseja pedir?</h4>
							</div>
							<select name="alimento" class="padrao-input">
								<option value="" disabled selected hidden>Selecione um alimento</option>
								<c:forEach var="alimento" items="${alimentos}">
									<option value="${alimento.id}">${alimento.nome}</option>
								</c:forEach>
							</select>
							<input type="text" name="quantidade" placeholder="Quantidade" required class="padrao-input">

							<input type="text" name="data-validade" required class="padrao-input" placeholder="Data de validade" onfocus="this.type='date'" onblur="if(!this.value)this.type='text'">

							
							<input type="text" name="meta-doacoes" placeholder="Meta de Doações" required class="padrao-input">
						</div>
						<button type="submit" class="padrao-submit">Cadastro</button>
					</form>
					
			</body>

			</html>