<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Helpu</title>
		<style type="text/css"> <%@include file="/resources/css/index.css"%></style>
       <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style> 
    </head>

    <body>
        <div>
            <header>
                <div class="menu-index">
                    <div class="menu-logo">
                    <!--Nao consegui fazer o fundo transparente funcionar  -->
<%--  						<svg class="logo">
                   		 <%@ include file="/resources/imagens/logo.jsp" %>
						</svg>  --%>
                    </div>
                    <div class="opcoes">
                        <nav>
                            <ul>
                                <li><a href="#">Menu</a></li>
                                <li><a href="#">Doe Aqui</a></li>
                                <li><a href="mostrar-cadastro">Cadastrar-se</a></li>
                                <li><a href="login">Entrar</a></li>
                            </ul>
                        </nav>
						
                    </div>
                    </div>      
                </header>

            <main>
                <div class="tela-inicial">
                <svg class="imagem-inicial">
                    <%@ include file="/resources/imagens/tela-inicial-index.jsp" %>
				</svg>		
					

                    <div class="texto-sobre-imagem">
                        <h1>
                            <span id="Fazer-index">Fazer</span> a Diferença
                            nunca foi tão
                            <span id="facil-index">fácil!</span>
                        </h1>
                        <div class="botoes-cadastro">
                            <a href="<%request.getServletContext();%>cadastro-ong">Sou ONG</a>
                            <a href="<%request.getServletContext();%>cadastro-doador">Sou Doador</a>
                        </div>
                    </div>
            
                 
                </div>
            </main>
            
            <div class="container">
            	<!--Coloque a imagem Aqui Pedro  -->
	            <div class="ajuste-titulo">
	            <h1 class="titulo-index">Pedidos em destaque!</h1>
	            
	            <span>Campanhas em alta em nosso site: cadastre-se e se conecte com ONGS que precisam de você!</span>
	            </div>
	            <c:forEach var="pedido" items="${pedidos}">
					<div class="card-pedidos">
						<span class="titulo-card"><c:out value="${pedido.titulo}" /></span>
						<span class="nome-card"><c:out value="${pedido.ong.nome}" /></span>
						<span class="texto-card"><c:out value="${pedido.descricao}" /></span>
						<a class="botao-pedido" href="<%request.getServletContext();%>/descricao-pedido">Leia Mais</a>
					</div>
				</c:forEach>
            
			</div>
            <div class="quem-somos">
                <div class="quem-somos-conteudo">
                    <h2>Quem somos</h2>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nemo necessitatibus perferendis ullam odit sit accusantium rerum numquam eum ut earum. Magnam autem quas unde sed blanditiis dicta dolorem eaque porro.</p>
                </div>
                <div class="quem-somos-index">
					<svg class="imagem-logo">
                   		 <%@ include file="/resources/imagens/imagem-logo.jsp" %>
					</svg>
						
                </div>
            </div>
            

            <footer>
                <div class="footer">
                    <div class="column">
                        <h2>HelpU</h2>
                        <ul>
                            <li><a href="#">Teste</a></li>
                            <li><a href="#">Teste</a></li>
                        </ul>
                    </div>
                    <div class="column">
                        <h2>Atendimento</h2>
                        <ul>
                            <li><a href="#">Teste</a></li>
                            <li><a href="#">Teste</a></li>
                        </ul>
                    </div>
                    <div class="column">
                        <h2>Dúvidas</h2>
                        <ul>
                            <li><a href="#">Teste</a></li>
                            <li><a href="#">Teste</a></li>
                        </ul>
                    </div>
                </div>




            </footer>
        </div>
        
    </body>

    </html>