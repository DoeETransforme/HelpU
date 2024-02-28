<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
    <link rel="stylesheet" href="../css/estilo.css">
	<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style> 
	<script><%@include file="/resources/js/Script.js"%></script>
	<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
	<script><%@include file="/resources/js/menu-topo.js"%></script>


</head>

<body>
		<%@ include file="../cabecalhos/menu.jsp" %>



       <main>
		<section>
			<div>
				<div class="titulo">
					<h1>Editar Proposta</h1>
				</div>
				<p class="titulo">Para a ONG <c:out value='${proposta.pedidoDoacao.ong.nome}' /> <br>O que
					você gostaria de doar?</p>
				<form action="proposta-editada" method="post" >


				
							<c:if test="${proposta != null}">
								<input type="hidden" name="id" value="<c:out value='${proposta.id}' />" />
							</c:if>

					
					<div class="editar-dados">
						
							
									<label>Alimento:</label>
									 <select id="select-editar-proposta" name="alimento" class="padrao-input">
										<c:forEach var="alimento" items="${alimentos}">
											<option value="" disabled selected> Selecione o alimento</option>
											<option value="${alimento.id}">${alimento.nome}</option>
										</c:forEach>
									</select>
								
									<label >Quantidade:</label>
									<input type="text" name="quantidade"
									placeholder="Quantidade" required class="padrao-input">
									</div>
									<div class="submit-editar-dados"><input type="submit" value="Confirmar" ></div>
										
				</form>
			</div>
		</section>
	</main>


</body>

</html>
