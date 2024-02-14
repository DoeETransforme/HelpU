<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HelpU</title>
<link rel="stylesheet" href="../css/estilo.css">
 <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
</head>
<body>
	
		
	<main>
		<div>
			<h1>Alimentos no Servidor:</h1>
			
			<c:forEach var="alimentos" items="${alimentos}">
				<div>
					<p>
						Alimento: <span id="nome_alimento">${alimentos.nome}</span><br>
										
						Data: <span id="data_alimento">${alimentos.dataValidade}</span>
					</p>
					<form action="editar-alimento" method="post">
                        <input type="submit" name="editar" id="EditarAlimento" value="Editar">
                    </form>
                    <form action="excluir-alimento" method="post">
                        <input type="submit" name="excluir" id="ExcluirAlimento" value="Excluir">
                    </form>
				</div>
			</c:forEach>

		</div>
	</main>
	
</body>
</html>