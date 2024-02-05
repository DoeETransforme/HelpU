<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
<title>Helpu</title>

</head>

<body>

	<header>
		<div>
			<a href="Pagina_Inicial.html"><img src="imagem.com" alt="Logo"></a>
			<input type="search" placeholder="Pesquisar">
			<nav>
				<a href="./login.jsp">Login</a> <a href="./Cadastro.jsp">Cadastro</a>
			</nav>
		</div>
	</header>

	<main>
		<div>
			<h1>Histórico de Pedidos da ONG</h1>


			
			<table>
				<c:forEach var="pedidos" items="${pedidos}">
				
					<div>
							<h2>
								Doações para <span id="Nome_Ong">${pedidos.ong.nome}</span>
							</h2>
							<h3>Titulo: <span id="titulo-pedido">${pedidos.titulo}</span></h3>
							<h3>
								Status: <span id="Status_Ong">${pedidos.statusPedido}</span>
							</h3>
							<p>${pedidos.descricao}</p> 
							<img src="" alt="imagem de perfil da ong">
						</div>
					
				</c:forEach>
			</table>


			<!--                 <tr> -->
			<!--                     <td> -->
			<!--                         <h2>Doações para <span id="Nome_Ong">crianças PCD</span></h2> -->
			<!--                         <h3>Status: <span id="Status_Ong">Ativo</span></h3> -->
			<!--                         <img src="imagem.com" alt="imagem de perfil da ong"> -->
			<!--                     </td> -->
			<!--                 </tr> -->
			</table>
		</div>
	</main>

</body>

</html>