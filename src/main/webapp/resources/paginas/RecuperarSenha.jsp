<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
</head>

<body>
    <div>
        <header>
            <div>
                <picture>
                    <a href="Pagina_Inicial.html"><img src="imgaem.jpg" alt="logo"></a>
                </picture>
                <input type="search" placeholder="Pesquisar">
            </div>
            <nav>
                <a href="login.html">Login</a>
                <a href="Cadastro.html">Cadstro</a>
            </nav>
        </header>
    </div>

    <main>
        <div>
            <h1>Esqueceu sua senha?</h1>
            <div>
                <p>Enviaremos um código de confirmação com 6 digitos para seu e-mail.</p>
                <p>Se ocorrer do código não funcionar ou perder a validade, reenvie a solicitação.</p>
            </div>
            <label for="email"></label>
            <input class="padrao_input" type="email" placeholder="e-mail" required>
        </div>
        <div>
            <label>Reenviar o código de confirmação</label>
        </div>
        <div>
            <button class="botão_padrão" id="enviarcodigo">Enviar</button>
        </div>
        </div>
    </main>
    </div>
</body>

</html>