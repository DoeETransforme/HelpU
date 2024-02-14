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
<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
</head>
<body>
	
		<div class="titulo">
			<h1>Editar Alimento</h1>
		</div>
		
		<form action="alimento-editado" method="post" >
		
			<div class="editar-dados">
			<div>
              <c:if test="${alimento != null}">
								<input type="hidden" name="id"
									value="<c:out value='${alimento.id}' />" />
							</c:if>
               </div>
				<label for="">Editar nome do alimento: </label>
				<input type="text" name="nome"  placeholder="Nome do alimento" required >
				<label for="">Editar data do alimento:</label>
				<input type="date" name="data" required  >
			</div>
			<div class="submit-editar-dados"><input type="submit" class=""></div>
	
		</form>
	
</body>
</html>