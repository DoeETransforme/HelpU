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
                    <a href="Pagina_Inicial.html"><img src="imagem.jpg" alt="logo"></a>
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
            <h1>Para redefinir sua senha, siga os passos a seguir:</h1>
            <input class="padrao_input" type="password" class="padrao_input" id="novasenha"
                placeholder="Cria uma nova senha" required>
            <p> Sua nova senha deve possuir as seguintes regras:</p>
        </div>
        <div>
            <ol>
                <ul>
                    <li>Letras maisuculas e minusculas</li>
                    <li>Minimo de 10 carcteres</li>
                    <li>Ter números</li>
                    <li>Ter simbolos</li>
                    <li>Sem sequencias numericas</li>
                </ul>
            </ol>
        </div>
        <div>
            <input class="padrao_input" type="password" class="padrao_input" placeholder="Confirmar nova senha"
                required>
        </div>
        <div>
            <button type="submit" class="botão_padrão">Confirmar</button>
        </div>
    </main>
</body>

</html>