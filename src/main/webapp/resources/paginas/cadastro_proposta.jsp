<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <picture>
                <a href="Pagina_Inicial.html"><img src="logo-imagem.com" alt="Logo"></a>
            </picture>
            <input type="search" placeholder="Pesquisar">
        </div>
        <nav>
            <a href="./login.jsp">Login</a>
            <a href="./cadastro.jsp">Cadastro</a>
        </nav>
    </header>

    <main>
        <section>
            <div>
                <h1>Fazer uma doação</h1>
                <p>Para a ONG "Cantinho Inclusivo"</p>

               
                <form action="Prospota_realizada.html" method="post">
                    <div>
                        <label for="nomeUsuario">Nome</label>
                        <input type="text" id="nomeUsuario" name="Nome" placeholder="Nome">
                    </div>
                    <div>
                        <label for="SobrenomeUsuario">Sobrenome:</label>
                        <input type="text" id="SobrenomeUsuario" name="Sobrenome" placeholder="Sobrenome">
                    </div>
                    <div>
                        <label for="Celular">Número de Celular:</label>
                        <input type="tel" id="Celular" name="Celular" placeholder="Celular">
                    </div>
                    <div>
                        <label for="Email">Email</label>
                        <input type="email" id="Email" name="Email" placeholder="Email">
                    </div>
               

                    <div>
                        <div>
                            <h2>O que você gostaria de doar?</h2>
                            <h3>Tipo de item</h3>
                            <ul>
                                <span id="Item">
                                    <li>Alimento não perecível</li>
                                </span>
                            </ul>
                          
                        </div>
                        <button>Adicionar mais itens</button>
                    </div>
                </form>

                <input type="submit" value="Confirmar"></input>
            </div>
        </section>
    </main>

</body>

</html>
