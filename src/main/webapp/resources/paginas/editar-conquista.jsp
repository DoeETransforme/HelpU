<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>HelpU</title>
<!--<style type="text/css"><%@include file="/resources/css/estilo.css"%></style>">-->
<link rel="stylesheet" href="../css/estilo.css">
</head>
<body>

	<%@ include file="menu.jsp"%>
	<div class="titulo">
		<h1>Editar Conquista</h1>
	</div>

	<main>
		<form action="conquista-editada" method="post" class="forms">
			
              <c:if test="${conquista != null}">
								<input type="hidden" name="id"
									value="<c:out value='${conquista.id}' />" />
							</c:if>
             
		
				<div>
					<input type="text" class="padrao-input" name="nome"
						placeholder="Nome da Conquista">
					<textarea name="descricao" class="padrao-input" rows="1"
						placeholder="Descricao da Conquista!"></textarea>
				</div>
			
			
				<button type="submit" class="padrao-submit">Confirmar</button>
			
		</form>
	</main>
</body>
</html>
