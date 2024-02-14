<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width= , initial-scale=1.0">
    <title>HelpU</title>
    <link rel="stylesheet" href="../css/estilo.css">
    <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
</head>

<body>
    <%@ include file="menu.jsp"%>

    <main>

        <div>
            <div class="titulo">
                <h1>Para desativar sua conta</h1>
            </div>
            <div class="header"> 
                <p>Login</p>
                <img src="../imagens/logo-final.png" alt="imagem da ong">
            </div>
            <div>
                
                <form action="conta-desativada" method="post" class="forms">
                      
                       <input type="email" id="LoginEmail" name="email" placeholder="E-mail de login" required class="padrao-input">
                        <input type="password" id="LoginSenha" name="senha" placeholder="Senha de login" required class="padrao-input">
                        <input type="submit" name="DesativarConta" id="DesativarContaPF" value="confirmar" class="padrao-submit">
                    </form>
                </div>
            </div>
        </div>
    </main>
</body>

</html>