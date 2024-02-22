<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
<link rel="stylesheet" href="../css/estilo.css">
 <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
 <script><%@include file="/resources/js/Script.js"%></script>
 <style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
</head>
<body>
	<main>
		<div>
			<h1>Conquistas no Servidor:</h1>
			
			<c:forEach var="conquista" items="${conquistas}">
				<div>
					<p>
						<img alt="foto da conquista" id="foto" src="<c:out value='${conquista.foto.urlFoto()}'/>">
						
						Nome: <span id="nome_conquista">${conquista.nome}</span><br>
										
						Descrição: <span id="descricao_conquista">${conquista.descricao}</span>
					</p>
					<a href="<%=request.getContextPath()%>/editar-conquista?id=<c:out value='${conquista.id}'/>">Editar</a>
					<a href="<%=request.getContextPath()%>/excluir-conquista?id=<c:out value='${conquista.id}'/>">Excluir</a>
				</div>
			</c:forEach>

		</div>
	</main>
</body>
</html>