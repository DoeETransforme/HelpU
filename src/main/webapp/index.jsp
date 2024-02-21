<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Helpu</title>
        <link rel="stylesheet" href="../webapp/resources/css/index.css">
          <!--<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>-->
    </head>

    <body>
        <div>
            <header>
                <div class="menu-index">
                    <div class="menu-logo">
                        <img src="../webapp/resources/imagens/logo-final.png" alt="Logo">
                    </div>
                    <div class="opcoes">
                        <nav>
                            <ul>
                                <li><a href="#">Menu</a></li>
                                <li><a href="#">Doe Aqui</a></li>
                                <li><a href="#">Cadastrar-se</a></li>
                                <li><a href="#">Entrar</a></li>
                            </ul>
                        </nav>
                        <img src="../webapp/resources/imagens/perfil-icon.png" alt="Perfil do Doador" style="float: right;">
                    </div>
                    </div>      
                </header>

            <main>
                <div class="tela-inicial">
                    <img src="../webapp/resources/imagens/background-index.png" alt="Imagem ajudando uma pessoa">
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

            <div class="quem-somos">
                <div class="quem-somos-conteudo">
                    <h2>Quem somos</h2>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nemo necessitatibus perferendis ullam odit sit accusantium rerum numquam eum ut earum. Magnam autem quas unde sed blanditiis dicta dolorem eaque porro.</p>
                </div>
                <div class="quem-somos-index">
                    <img src="../webapp/resources/imagens/logo-final.png" alt="Logo">
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