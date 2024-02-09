<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css"><%@include file="/resources/css/estilo.css"%></style>
</head>
<body>

	<c:choose>
<c:when test="${tipoUsuario == 2}">
 
		<%@ include file="menu.jsp"%>
		
</c:when>
</c:choose>
	<%@ include file="menu.jsp"%>
	<div class="header"> 
		<p>Login</p>
		<img src="../imagens/logo final.png" alt="imagem da ong">
	</div>
	
	<div class="titulo">
		<h1>CADASTRAR SEU PEDIDO.</h1>
	</div>
		<form action="inserir-pedido" method="post" class="forms">
		
		   	 <input type="text"  name="titulo" placeholder="Qual e o titulo do pedido?" required class="padrao-input">
		     <textarea name="descricao" rows="4" cols="50" placeholder="Escreva sobre o pedido!" class="padrao-input"></textarea >
		     
		     <div class="titulo">
				<h4>O que voce deseja pedir?</h4>
			 </div>
		     
		     <select name="alimento" class="padrao-input">
    			<c:forEach var="alimento" items="${alimentos}">
        			<option value="${alimento.id}">${alimento.nome}</option>
    			</c:forEach>
			 </select>
			 
    	  	 <div><input type="text" name="quantidade"  placeholder="Quantidade" required class="padrao-input"></div>
		     <div><input type="date"  name="data-validade" required class="padrao-input"></div>		
			 <div><input type="text"  name="meta-doacoes" placeholder="Meta de Doações" required>  </div>   
			 <button type="submit" class="padrao-submit">Cadastro</button>
			</form>
</body>
</html>