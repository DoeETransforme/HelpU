<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	
<body>
     <h1>Cadastre o Alimento.</h1>
     <form action="inserir-alimento" method="post">
	     <input type="text" name="nome"  placeholder="Nome do alimento" required>
	     <input type="date" name="data" required>
	     <button type="submit" >Cadastro</button>
	 </form>
</body>
</html>