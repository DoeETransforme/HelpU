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

    <div class="padrao_formuladrio">
        <h3>Informações Pessoais</h3>
        <form action="#" method="post" >
            <input type="text" name="nome" class="padrao_input" placeholder="Nome Completo" maxlength="30" required>
            <input type="date" name="data_nascimento" class="padrao_input" placeholder="Data de Nascimento" required>
            <input type="tel" name="celular" class="padrao_input" placeholder="Celular" pattern="[0-9] {2} [0-9] {5} [4] {0-9}" maxlength="14" required>
            <input type="text" name="cpf" class="padrao_input" placeholder="Digite seu cpf" maxlength="20" required>
            <input type="email" name="email" class="padrao_input" placeholder="Seu melhor E-mail"  maxlength="65" required>
            <input type="email" class="padrao_input" placeholder="Confirmar E-mail" maxlength="65" required>
            <input type="password" name="senha" class="padrao_input" placeholder="Senha" maxlength="15" required>
            <input type="password" class="padrao_input" placeholder="Confirmar Senha" maxlength="15" required>

            <!-- Nescessario ver como será feito o submit com imagem-->
            <button type="submit">
                <a href="login.html">
                    <img src="Imagens/Right.png">
                </a>
            </button>
        </form>
    </div>    
</main>

</body>
</html>