<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
</head>
<body>
	<head>
     <nav>
          <a href="Conquista.html">Conquistas</a>
          <a href="Minha conta.html">Minha conta</a>
      </nav>
</head>
<body>
     <h1>Cadastre o Alimento.</h1>
     <form action="inserir-alimento" method="post">
	     <input type="text" name="nome-alimento"  placeholder="Nome do alimento" required>
	     <input type="date" name="data-validade" required>
		 <input type="number" name=quantidade-alimento placeholder="Quantidade do Alimento" required>
	     <button type="submit" >Cadastro</button>
	 </form>
</body>
</html>