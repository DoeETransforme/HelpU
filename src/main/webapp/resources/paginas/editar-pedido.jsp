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
    <%@ include file="menu.jsp"%>
    
        <div>
            <h1>Editar Pedido de Doação</h1>
        </div>
        <form action="pedido-editado" method="post"> 
        <div>
            <input type="text" id="Nome_pedido" placeholder="Qual o título do pedido?" class="padrao_input">
        </div>
        <div>
            <textarea placeholder="Escreva sobre o pedido!" maxlenght="10000" class="padrao_input"></textarea>
        </div>
        <div>
            <label for="Status_pedido">Status do Pedido:</label>
            <select name="Status_pedido" id="Status_pedido" class="padrao_input">
                <option value="Ativo">Ativo</option>
                <option value="Cancelado">Cancelado</option>
                <option value="Concluido">Concluído</option>
            </select>
            <label for="item_requerido">Tipo de Item Requerido</label>
            <select name="item_requerido" id="item_requerido" class="padrao_input">
                <option value="item_alimento">Alimento Não-Perecivel</option>
            </select>
            <input type="number" id="meta_doações" placeholder="Meta de Doações" class="padrao_input">
            <input type="date" id="data_final" placeholder="O pedido irá durar até dia..." class="padrao_input">
            <h2>Quais itens são necessários?</h2>
        </div>
        <div id="adicionar_mais_itens">
            <ul>
                <li>Arroz</li>
                <li>Macarrão</li>
            </ul>
            <button type="button" id="adicionar_mais_itens">Solicitar mais itens +</button>
        </div>
        <div>
            <button class="botão_padrão" type="submit" id="alteração_pedido">Pronto</button>
        </div>
        </form>
</body>

</html>