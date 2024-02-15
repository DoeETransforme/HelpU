<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excluir pedido</title>
</head>
<body>
	<%@ include file="menu.jsp"%>

	<h1>Tem certeza que deseja excluir esse pedido?</h1>


	<div>
		<c:if test="${pedido != null}">
			<input type="hidden" name="id" value="<c:out value='${pedido.id}' />" />
		</c:if>
	</div>
	<a href="<%=request.getContextPath()%>/perfil-ong?id=<c:out value='${pedido.id}'/>" class="Voltar" class=""> Voltar</a>
	<a href="<%=request.getContextPath()%>/pedido-excluido?id=<c:out value='${pedido.id}'/>" class="Voltar" class="">Confirmar</a>


</body>
</html>