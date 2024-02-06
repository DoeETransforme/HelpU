<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Helpu</title>
</head>
<body>
	<header>
		<div>
			<div>

				<a href="Pagina_Inicial.html"><img src="imagem.com" alt="Logo"></a>

				<input type="search" placeholder="Pesquisar">
			</div>
			<nav>
				<a href="./Perfil_pessoa.jsp">Minha conta</a>
			</nav>
		</div>
	</header>

	<main>
		<div>
			<h1>Propostas em Análise.</h1>
			<c:forEach var="propostaDoacao" items="${propostaDoacao}">
				<div>
					<a href="<%=request.getContextPath()%>/avaliar-proposta">


						<h2>
							Doação para: <span id="Nome_Ong">${propostaDoacao.pedidoDoacao.ong.nome}</span>
						</h2>
						<p>
							Por: <span id="nomeUsuario">${propostaDoacao.doador.nome}</span>
						</p>
						<p>
							Status: <span>${propostaDoacao.statusProposta}</span>
						</p>

					</a>
				</div>

			</c:forEach>

		</div>
	</main>
</body>
</html>