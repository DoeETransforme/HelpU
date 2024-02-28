<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
<!-- <script><%@include file="/resources/js/Script.js"%></script> -->
<link rel="stylesheet" href="../css/excluir-alimento.css">
</head>
<body>
	<div class="titulo">
		<h1>Tem certeza que deseja excluir esse alimento?</h1>
	</div>
	<div>
		<c:if test="${alimento != null}">
			<input type="hidden" name="id"
				value="<c:out value='${alimento.id}' />" />
		</c:if>
	</div>
	<div class="excluir-alimento">
		<a href="editar-alimento" class="Voltar"> Voltar</a> 
		<a href="" class="Confirmar">Confirmar</a>
	</div>

</body>
</html>