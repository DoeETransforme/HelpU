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
    <div>
        <header>
            <div>
                <picture>
                    <a href="Pagina_Inicial.html"><img src="imagem.com" alt="Logo"></a>
                </picture>
                <input type="search" placeholder="Pesquisar">
            </div>
            <nav>
                <a href="Login.html">Login</a>
                <a href="Cadastro.html">Cadastro</a>
            </nav>
        </header>

        <main>
            <div>
                <div>
                    <h1>Login</h1>
                    <form action="login" method="post">
                        <input type="email" id="LoginEmail" name="LoginEmail" placeholder="E-mail de login" required>
                        <input type="password" id="LoginSenha" name="LoginSenha" placeholder="Senha de login" required>
                        <input type="submit" value="Logar!">
                    </form>
                </div>
            </div>
        </main>
    </div>
</body>
</html>
