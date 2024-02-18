<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
    <link rel="stylesheet" href="../css/estilo.css">
<!-- <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style> -->
<script><%@include file="/resources/js/Script.js"%></script>

</head>

<body>
<div class="menu-hamburguer" id="menu-hamburguer">
	
		<div class="hamburguer" onclick="toggleMenu()">☰</div>
	</div>
	
	<div class="menu-lateral" id="menu-lateral">
		<c:choose>
					<c:when test="${tipoUsuario == 1}">

						<%@ include file="menu.jsp" %>

					</c:when>
				</c:choose>
	</div>


       <main>
		<section>
			<div>
				<div class="titulo">
					<h1>Editar Proposta</h1>
				</div>
				<p class="titulo">Para a ONG "Cantinho Inclusivo"</p> <p class="titulo">O que
					você gostaria de doar?</p>
				<form action="proposta-editada" method="post" class="forms">


				
							<c:if test="${proposta != null}">
								<input type="hidden" name="id"
									value="<c:out value='${proposta.id}' />" />
							</c:if>

					
					<div>
						
								<label>Alimento</label>
								 <select name="alimento" class="padrao-input">
									<c:forEach var="alimento" items="${alimentos}">
										<option value="" disabled selected> Selecione o alimento</option>
										<option value="${alimento.id}">${alimento.nome}</option>
									</c:forEach>
								</select>
						
						
								<label>Quantidade</label> 
								<input type="text" name="quantidade"
									placeholder="Quantidade" required class="padrao-input">
					</div>

						

				


					<input type="submit" value="Confirmar" class="padrao-submit">
				</form>
			</div>
		</section>
	</main>


</body>

</html>
