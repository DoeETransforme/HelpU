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
    <%@ include file="menu.jsp"%>

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