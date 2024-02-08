<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HelpU</title>
<link rel="stylesheet" href="../css/estilo.css">
</head>
<body>
	
		<div class="titulo">
			<h1>Editar Alimento</h1>
		</div>
		
		<form action="alimento-editado" method="post" class="forms">
		<div>
			<div><input type="text" name="nome"  placeholder="Nome do alimento" required class="padrao-input"></div>
					<div><input type="date" name="data" required class="padrao-input"></div>
					<div><button type="submit" class="padrao-submit">Editar</button></div>
		</div>
		</form>
	
</body>
</html>