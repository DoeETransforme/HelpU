<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excluir Conquista</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<h1>Tem certeza que deseja excluir essa conquista?</h1>

	<div>

		<c:if test="${conquista != null}">
			<input type="hidden" name="id"
				value="<c:out value='${conquista.id}' />" />
		</c:if>
	</div>
	<a href="" class="Voltar" class=""> Voltar</a>
	<a href="" class="Voltar" class="">Confirmar</a>

</body>
</html>