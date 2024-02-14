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
    <!--<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>-->

</head>

<body>

    <%@ include file="menu.jsp" %>


       <main>
		<section>
			<div>
				<h1>Editar Proposta</h1>
				<form action="proposta-editada" method="post">
					<label>Para a ONG "Cantinho Inclusivo"</label> <label>O que
						você gostaria de doar?</label>


					<div>
						<div>
							<c:if test="${proposta != null}">
								<input type="hidden" name="id"
									value="<c:out value='${proposta.id}' />" />
							</c:if>
						</div>
						<div>
							<label>Alimento</label> <select name="alimento">
								<c:forEach var="alimento" items="${alimentos}">
									<option value="${alimento.id}">${alimento.nome}</option>
								</c:forEach>
							</select>
						</div>

						<div>
							<label>Quantidade</label> <input type="text" name="quantidade"
								placeholder="Quantidade" required>

						</div>

					</div>


					<input type="submit" value="Confirmar">
				</form>
			</div>
		</section>
	</main>

</body>

</html>
