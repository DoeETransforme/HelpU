<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Helpu</title>
    <link rel="stylesheet" href="../css/estilo.css">
     <!--<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
    <link rel="stylesheet" href="../css/estilo.css">-->
</head>
<body>
    <div class="">
        
            <header>
                <div>
        
                    <input type="search" placeholder="Pesquisar" class="barra-de-pesquisa">
                </div>
                <div class="header item1-login">
                    <p>Login</p>
                    <img src="../imagens/logo-final.png".png" alt="imagem da ong">
                </div>
            </header>
            <div class="item2-login">
                <main>
                    <img src="../imagens/imagem-front-login3.png" alt="" class="imagem-login  .item2-login">
                </main>
            </div>
            
            <div class="tamanho">
                <form action="confirmar-login" method="post">
                    <div class="position">
                        <div class="forms-login">
                            <h1 class="titulo-login">Login</h1>
                            <input type="email" id="LoginEmail" name="email" placeholder="E-mail de login" required class="padrao-login">
                            <input type="password" id="LoginSenha" name="senha" placeholder="Senha de login" required class="padrao-login item3-login">
                            <input type="submit" value="Logar!" class="padrao-submit-login">
                        </div>
                    </div>
                </form>
                <div class="esqueceu-senha-login">
                    <p>Não tem uma conta? Cadastra-se Agora!</p>
                    <p>Esqueceu a senha?</p>
                </div>
            </div>
            
</body>
</html>
