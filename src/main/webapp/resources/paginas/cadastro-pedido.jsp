<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="menu.jsp"%>
	
	<h1>CADASTRAR SEU PEDIDO.</h1>
		<form action="inserir-pedido" method="post">
		
		   	 <input type="text"  name="titulo" placeholder="Qual e o titulo do pedido?" required>
		     <textarea name="descricao" rows="4" cols="50" placeholder="Escreva sobre o pedido!"></textarea>
		     
		     <h4>O que voce deseja pedir?</h4>
		     
		     <select name="alimento">
    			<c:forEach var="alimento" items="${alimentos}">
        			<option value="${alimento.id}">${alimento.nome}</option>
    			</c:forEach>
			 </select>
			 
    	  	 <input type="text" name="quantidade"  placeholder="Quantidade" required>
		     <input type="date"  name="data-validade" required>	
		     <input type="text"  name="meta-doacoes" placeholder="Meta de Doações" required>		     
		     <button type="submit" >Cadastro</button>
	    </form>
</body>
</html>