<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>Insert title here</title>
			<style type="text/css"><%@include file="/resources/css/estilo.css"%></style> 
				<link rel="stylesheet" href="../css/estilo.css">
				<script><%@include file="/resources/js/Script.js"%></script>
				<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
			</head>

			<body>
		<%@ include file="../cabecalhos/menu.jsp" %>

					<div class="titulo">
						<h1>CADASTRAR SEU PEDIDO.</h1>
					</div>
					<form action="inserir-pedido" method="post" class="forms-cadastrar-pedido" enctype="multipart/form-data">
					
							<div>
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


								<section class="section-pedido"><input id="input-foto-pedido2" type="file" name="foto" >
								<button type="submit" class="padrao-submit" id="botao-cadastro-pedido">Cadastro</button></div>
							</section>
					
					</form>
					
			</body>

			</html>