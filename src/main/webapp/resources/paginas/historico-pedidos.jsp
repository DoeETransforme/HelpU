<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<%@ page isELIgnored="false" %>
			<!DOCTYPE html>
			<html lang="pt-br">

			<head>
				<meta charset="UTF-8">
				<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
				<title>Helpu</title>
				<link rel="stylesheet" href="../css/estilo.css">

			</head>

			<body>

				<%@ include file="menu.jsp" %>

					<main>
						<div>
							<div class="titulo">
								<h1>Histórico de Pedidos da ONG</h1>
							</div>




							<c:forEach var="pedidos" items="${pedidos}">

								<div class="propostas-doacao-analise">
									<div class="imagem-card" id="div-imagem-card"><img src="../imagens/Sem título.png"
											alt="imagem de perfil da ong" id="imagem-historico"></div>
									<div class="conteudo" id="conteudo-historico">
										<h2 id="titulo-historico">
											Doações para <span id="Nome_Ong">${pedidos.ong.nome}</span>
										</h2>
										<br>
										<p>
											Status: <span id="Status_Ong">${pedidos.statusPedido}</span> <br>
										</p>
										<br>
										<p>Meta de doações: <span id="Meta-Doacoes">${pedidos.metaDoacoes}</span></p>



										<a
											href="<%request.getServletContext();%>editar-pedido?id=<c:out value='${pedidos.id}'/>" >Editar</a>
										<a
											href="<%request.getServletContext();%>excluir-pedido?id=<c:out value='${pedidos.id}'/>">Excluir</a>


									</div>

								</div>

							</c:forEach>



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