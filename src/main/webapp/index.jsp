<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Helpu</title>
        <link rel="stylesheet" href="../webapp/resources/css/estilo.css">
          <!--<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>-->
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
                        <a href="<%request.getServletContext();%>login">Login</a>
                        <a href="Cadastro.html">Cadastro</a>
                    </nav>
                </div>
            </header>

            <main>
                <img src="imagem.com" alt="Foto de uma ong">
                <section>
                    <div>
                        <h1>Quem somos</h1>
                        <p>You say potato, I say starchy carbs. A vida é uma sucessão de sucessivos que sucedem
                            sucessivamente sem cessar.. Por que 'tudo junto' se escreve separado e 'separado' se escreve
                            tudo junto?. A única mulher que andou na linha o trem pegou.. O povo unido é gente pra
                            caramba..
                        </p>
                    </div>
                    <figure>
                        <img src="imagem.com" alt="Imagem ajudando uma pessoa">
                    </figure>
                </section>

                <section>
                    <h1>Pedidos de Doação em Alta</h1>
                    <div>
                        <div>
                            <img src="imagem.com" alt="ajudando uma criança">
                            <h2>Doações para crianças PCDs</h2>
                            <button>Leia sobre</button>
                        </div>
                        <div>
                            <img src="imagem.com" alt="doação de comida">
                            <h2>Doação de comida para crianças carentes</h2>
                            <button>Leia sobre!</button>
                        </div>
                    </div>
                </section>
            </main>

            <footer>
                <div>
                    <h1>Faça seu cadastro</h1>
                    <div>

                        <a href="<%request.getServletContext();%>cadastro-ong"><button>Sou ONG</button></a>
                        <a href="<%request.getServletContext();%>cadastro-doador"><button>Sou pessoa fisica</button></a>

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
                            <a href="./resources/paginas/TelaDeErro1">
                                <li>Quem somos</li>
                            </a>

                            <a href="./resources/paginas/TelaDeErro1">
                                <li>Equipe</li>
                            </a>


                            <a href="./resources/paginas/TelaDeErro1">
                                <li>Impacto</li>
                            </a>


                        </ol>
                    </div>
                </div>
            </footer>
        </div>
        
    </body>

    </html>