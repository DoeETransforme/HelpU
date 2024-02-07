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
	<div>
		<header>
			<div>
				<div>
					<a href="Pagina_Inicial.html"><img src="imagem.com" alt="Logo"></a>
					<input type="search" placeholder="Pesquisar">
				</div>
				<nav>
					<a href="<%request.getServletContext();%>login">Login</a> <a
						href="Cadastro.html">Cadastro</a>
				</nav>
			</div>
		</header>

		<main>
			<img src="imagem.com" alt="Foto de uma ong">
			<section>
				<div>
					<h1>Quem somos</h1>
					<p>You say potato, I say starchy carbs. A vida é uma sucessão
						de sucessivos que sucedem sucessivamente sem cessar.. Por que
						'tudo junto' se escreve separado e 'separado' se escreve tudo
						junto?. A única mulher que andou na linha o trem pegou.. O povo
						unido é gente pra caramba..</p>
				</div>
				<figure>
					<img src="imagem.com" alt="Imagem ajudando uma pessoa">
				</figure>
			</section>

			<h1>Pedidos de Doação em Alta:</h1>
			<c:forEach var="pedidos" items="${pedidos}">
				<section>
					<div>
						<img src="imagem.com" alt="ajudando uma criança">
						<h2>
							Doações para:
							<c:out value="${pedidos.titulo}" />
						</h2>
						<a href="<%=request.getContextPath()%>/descricao-pedido?id=${pedidos.id}"><button>Leia
								sobre</button></a>
					</div>
				</section>
			</c:forEach>

		</main>

		<footer>
			<div>
				<h1>Faça seu cadastro</h1>
				<div>

					<a href="<%request.getServletContext();%>cadastro-ong"><button>Sou
							ONG</button></a> <a href="<%request.getServletContext();%>cadastro-doador"><button>Sou
							pessoa fisica</button></a>

				</div>
			</div>

			<div>
				<h2>Redes sociais</h2>
				<div>
					<ol>
						<li><a href="link_twitter">Twitter</a></li>
						<li><a href="link_instagram">Instagram</a></li>
						<li><a href="link_facebook">Facebook</a></li>
					</ol>
				</div>
				<div>
					<h2>Outras informações</h2>
					<ol>
						<a href="./resources/paginas/TelaDeErro1"><li>Quem somos</li></a>

						<a href="./resources/paginas/TelaDeErro1"><li>Equipe</li> </a>


						<a href="./resources/paginas/TelaDeErro1"><li>Impacto</li></a>


					</ol>
				</div>
			</div>
		</footer>
	</div>
</body>

</html>