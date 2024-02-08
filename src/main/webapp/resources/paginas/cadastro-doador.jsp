<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>

    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="header"> 
        <p>Login</p>
        <img src="../imagens/logo final.png" alt="imagem da ong">
    </div>

   <main>
    <div class="titulo">
        <h1>Cadastro Pessoa física</h1>
        <p>informações pessoais</p>
    </div>
        <form name="fm-cadastro-doador" action="inserir-doador"  method="post" class="forms">
            <div>
                <div><input type="text" name="nome" class="padrao-input" placeholder="Nome Completo" maxlength="30" required class="padrao-input"></div>
                <div><input id="data-nascimento" type="date" name="data-nascimento" class="padrao-input" placeholder="Data de Nascimento" required class="padrao-input"></div>
                <div><input type="text" name="cpf" class="padrao-input" placeholder="Digite seu cpf" maxlength="20" required class="padrao-input"></div>
                <div><input type="tel" name="celular" class="padrao-input" placeholder="Celular" pattern="[0-9] {2} [0-9] {5} [4] {0-9}" maxlength="14" required class="padrao-input"></div>
                <div><input type="email" name="email" class="padrao-input" placeholder="Seu melhor E-mail"  maxlength="65" required class="padrao-input"></div>
                <div><input type="email" class="padrao-input" placeholder="Confirmar E-mail" maxlength="65" required class="padrao-input"></div>
                <div><input type="password" name="senha" class="padrao-input" placeholder="Senha" maxlength="15" required class="padrao-input"></div>
                <div><input type="password" class="padrao-input" placeholder="Confirmar Senha" maxlength="15" required class="padrao-input"></div>
            </div>

            <button type="submit" class="padrao-submit">Cadastrar</button>

        </form>   
</main>

</body>
</html>