<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
</head>
<body>
	<h1>CADASTRAR SEU PEDIDO.</h1>
	<form action="inserir-item" method="post">
	<input type="text" id="titulo" name="titulo" placeholder="Escreva um titulo" required>
	<input type="text" id="descricao" name="descricao" placeholder="Escreva uma descricao" required>
	<input type="date" id="data-validade" name="data-validade" required>
	<button type="submit">Cadastrar</button>
	
	<a href= "<%request.getServletContext();%>cadastro-alimento"><button>Adicionar itens</button></a>
		
	</form>
</body>
</html>