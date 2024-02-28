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
 <script><%@include file="/resources/js/Script.js"%></script> 
</head>
<body>
	
		
	<main>
		<div>
			<div class="titulo">
				<h1>Alimentos no Servidor Cadastrados:</h1>
				<div class="input-search"><input type="search" placeholder="Pesquisar Alimento"></div>
			</div>
			
			<c:forEach var="alimentos" items="${alimentos}">
				<div class="alimentos-cadastrados">
					<div class="card-alimento-cadastrado">
						<div class="conteudo-card-alimento">
							<p>
								Alimento: <span id="nome_alimento">${alimentos.nome}</span><br>
							
								Data: <span id="data_alimento">${alimentos.dataValidade}</span>
							</p>
						</div>
						<div class="editar-excluir-alimento">
							<a href="<%=request.getContextPath()%>/editar-alimento?id=<c:out value='${alimentos.id}'/>">Editar</a>
							<a href="<%=request.getContextPath()%>/excluir-alimento?id=<c:out value='${alimentos.id}'/>">Excluir</a>
						</div>
					</div>
					
				</div>
			</c:forEach>

		</div>
	</main>
	
</body>
</html>