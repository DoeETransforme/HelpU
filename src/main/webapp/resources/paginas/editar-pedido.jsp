<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>HelpU</title>
        <link rel="stylesheet" href="../css/estilo.css">7
        <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
    </head>

    <body>
        <%@ include file="menu.jsp" %>

            <div class="titulo">
                <h1>Editar Pedido de Doação</h1>
            </div>
            <div class="header">
                <p>Login</p>
                <img src="../imagens/logo-final.png" alt="imagem da ong">
            </div>
            <form action="pedido-editado" method="post" class="forms">


                <input type="text" id="Nome_pedido" placeholder="Qual o título do pedido?" class="padrao-input">


                <div><textarea placeholder="Escreva sobre o pedido!" maxlenght="10000"
                        class="padrao-textarea"></textarea></div>

                <div>
                    <label for="Status_pedido" class="titulo" id="label-status-editar-pedido">Status do Pedido:</label>
                    <select name="Status_pedido" id="Status_pedido" class="padrao-input">
                        <option value="Ativo">Ativo</option>
                        <option value="Cancelado">Cancelado</option>
                        <option value="Concluido">Concluído</option>
                    </select>


                    <label for="item_requerido" class="titulo">Tipo de Item Requerido</label>
                    <select name="item_requerido" id="item_requerido" class="padrao-input">
                        <option value="item_alimento">Alimento Não-Perecivel</option>
                    </select>
                    <div>

                        <input type="number" id="meta_doações" placeholder="Meta de Doações" class="padrao-input">
                    </div>
                    <div><input type="date" id="data_final" placeholder="O pedido irá durar até dia..."
                            class="data-nascimento-padrao"></div>
                    <div class="titulo">
                        <h3>Quais itens são necessários?</h3>
                    </div>
                </div>
                <div id="adicionar_mais_itens" class="titulo">
                    <ul>
                        <li>Arroz</li>
                        <li>Macarrão</li>
                    </ul>
                    <button type="button" id="adicionar_mais_itens" class="padrao-submit">Solicitar mais itens +</button>
                </div>
                <div>
                    <button class="padrao-submit" type="submit" id="alteração_pedido">Pronto</button>

                </div>
            </form>
    </body>

    </html>