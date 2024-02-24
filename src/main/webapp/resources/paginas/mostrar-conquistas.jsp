<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
<link rel="stylesheet" href="../css/estilo.css">
 <!-- <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
 <script><%@include file="/resources/js/Script.js"%></script>
 <style type="text/css"> <%@include file="../css/menu-topo.css"%></style> -->
</head>
<body>
	<main>
		<div>
			<div class="titulo">
				<h1>Conquistas no Servidor:</h1>
				<div class="input-search">
					<input type="search" placeholder="Pesquisar Conquista"></div>
			</div>
			
			<c:forEach var="conquista" items="${conquistas}">
				<div class="todas-conquistas-cadastradas">
					<div class="card-conquista">
						<div class="conteudo-card-conquista">
							<p>
								<img alt="foto da conquista" id="foto" src="<c:out value='${conquista.foto.urlFoto()}'/>">
							
								Nome: <span id="nome_conquista">${conquista.nome}</span><br>
							
								Descrição: <span id="descricao_conquista">${conquista.descricao}</span>
							</p>
						</div>
						<div class="botoes-card-conquista">
							<a href="<%=request.getContextPath()%>/editar-conquista?id=<c:out value='${conquista.id}'/>">Editar</a>
							<a href="<%=request.getContextPath()%>/excluir-conquista?id=<c:out value='${conquista.id}'/>">Excluir</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</main>
</body>
</html>