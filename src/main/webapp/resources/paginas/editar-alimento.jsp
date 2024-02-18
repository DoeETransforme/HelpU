<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HelpU</title>
<link rel="stylesheet" href="../css/estilo.css">
<script><%@include file="/resources/js/Script.js"%></script>
 <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
</head>
<body>
	
		<div class="titulo">
			<h1>Editar Alimento</h1>
		</div>
		
		<form action="alimento-editado" method="post" class="forms" >
		
			
			<c:if test="${alimento != null}">
				<input type="hidden" name="id"
				value="<c:out value='${alimento.id}' />" />
			</c:if>
			
			<div>
				<label for="">Editar nome do alimento: </label>
				<input type="text" name="nome"  placeholder="Nome do alimento" required class="padrao-input">
				<label for="">Editar data do alimento:</label>
				<input type="text" name="data" required class="padrao-input" placeholder="Data do alimento" onfocus="this.type='date'" onblur="if(!this.value)this.type='text'">
			</div>
			<input type="submit" class="padrao-submit">
	
		</form>
	
</body>
</html>