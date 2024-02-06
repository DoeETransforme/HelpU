<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HelpU</title>
</head>
<body>
	
		<h1>Editar Alimento</h1>
		
		<form action="alimento-editado" method="post">
		<input type="text" name="nome"  placeholder="Nome do alimento" required>
	    <input type="date" name="data" required>
	    <button type="submit" >Editar</button>
		</form>
	
</body>
</html>