<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Helpu</title>
</head>

<body>

	<%@ include file="menu.jsp"%>

	<main>
		<section>
			<div>
				<h1>Fazer uma doação</h1>
				<form action="inserir-proposta" method="post">
					<label>Para a ONG "Cantinho Inclusivo"</label> <label>O que
						você gostaria de doar?</label>


					<div>
						<div>
							<label>Pedido</label> 
							<select name="pedido">
								<c:forEach var="pedido" items="${pedidos}">
									<option value="${pedido.id}">${pedido.titulo}</option>
								</c:forEach>
							</select>
						</div>
						<div>
							<label>Item</label> 
							<select name="alimento">
								<c:forEach var="alimento" items="${alimentos}">
									<option value="${alimento.id}">${alimento.nome}</option>
								</c:forEach>
							</select>
						</div>

						<div>
							<label>Quantidade</label>
							<input type="text" name="quantidade"  placeholder="Quantidade" required>
		     
						</div>

						<div>
							<label>Validade</label>
							<input type="date"  name="data-validade" required>	
						</div>
					</div>


					<input type="submit" value="Confirmar">
				</form>
			</div>
		</section>
	</main>

</body>

</html>
