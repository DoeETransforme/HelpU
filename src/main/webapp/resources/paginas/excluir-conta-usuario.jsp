<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

        <%@ include file="menu.jsp" %>

            </header>

            <main>

                <div class="titulo">
                    <h1>Você realmente deseja desativar esse perfil?</h1>
                </div>


                <div class="excluir-conta-posicao">

                <div class="imagem-doador-excluir">
                    <img src="../imagens/perfil-icon.png" alt="imagem do usuario">
                </div>

                    <form action="confirmar-exclusao" method="post">

                        <a href="Perfil_Pessoa.html" class="voltar" class="">Voltar</a>

                        <input type="submit" name="DesativarConta" id="DesativarContaPF" value="SIM" class="">


                    </form>
                </div>
            </main>
    </body>

    </html>