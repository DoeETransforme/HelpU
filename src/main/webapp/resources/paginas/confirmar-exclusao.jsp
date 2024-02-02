<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width= , initial-scale=1.0">
    <title>HelpU</title>
</head>

<body>
    <header>
        <div>
            <picture>
                <a href="Pagina_Inicial.html"><img src="caminho/para/sua/imagem.jpg" alt="Logo"></a>
            </picture>
            <input type="search" placeholder="Pesquisar">
        </div>
        <nav>
           <a href="./login.jsp">Login</a>
            <a href="./cadastro.jsp">Cadastro</a>
        </nav>

    </header>

    <main>

        <div>
            <h1>Para desativar sua conta</h1>
            <div>
                
                <div>
                    <form action="conta-desativada" method="post">
                        <input type="email" id="LoginEmail" name="email" placeholder="E-mail de login" required>
                        <input type="password" id="LoginSenha" name="senha" placeholder="Senha de login" required>
                        <input type="submit" name="DesativarConta" id="DesativarContaPF" value="confirmar">
                    </form>
                </div>
            </div>
        </div>
    </main>
</body>

</html>