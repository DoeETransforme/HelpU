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

   <main>
        <h1>Cadastro de Pessoa Fisica</h1>

        <h3>Informações Pessoais</h3>
        <form name="fm-cadastro-doador" action="inserir-doador"  method="post">
            <input type="text" name="nome" class="padrao-input" placeholder="Nome Completo" maxlength="30" required>
            <input type="date" name="data-nascimento" class="padrao-input" placeholder="Data de Nascimento" required>
            <input type="text" name="cpf" class="padrao-input" placeholder="Digite seu cpf" maxlength="20" required>
            <input type="tel" name="celular" class="padrao-input" placeholder="Celular" pattern="[0-9] {2} [0-9] {5} [4] {0-9}" maxlength="14" required>
            <input type="email" name="email" class="padrao-input" placeholder="Seu melhor E-mail"  maxlength="65" required>
            <input type="email" class="padrao-input" placeholder="Confirmar E-mail" maxlength="65" required>
            <input type="password" name="senha" class="padrao-input" placeholder="Senha" maxlength="15" required>
            <input type="password" class="padrao-input" placeholder="Confirmar Senha" maxlength="15" required>

            <button type="submit">Cadastrar</button>

        </form>   
</main>

</body>
</html>