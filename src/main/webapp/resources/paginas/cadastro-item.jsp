<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
</head>
<body>
		  <h1>Cadastre o item.</h1>
     <form action="inserir-item" method="post">
     <select name="alimento">
    			<c:forEach var="alimento" items="${alimentos}">
        			<option value="${alimento.id}">${alimento.nome}</option>
    			</c:forEach>
			</select>
	     <input type="text" name="quantidade"  placeholder="Quantidade" required>
	     <button type="submit" >Cadastro</button>
	 </form>
</body>
</html>