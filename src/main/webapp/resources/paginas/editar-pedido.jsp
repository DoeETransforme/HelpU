<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
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
        	<c:if test="${pedido != null}">
						<input type="hidden" name="id" value="<c:out value='${pedido.id}' />" />
					</c:if>
            <input type="text" id="Titulo_pedido" name="titulo" placeholder="Qual o título do pedido?" class="padrao_input">
        </div>
        <div>
            <textarea placeholder="Escreva sobre o pedido!" name="descricao" maxlenght="10000" class="padrao_input"></textarea>
        </div>
        <div>
            <label for="Status_pedido">Status do Pedido:</label>
            <select name="status" id="Status_pedido" class="padrao_input">
                <option value="ATIVO">Ativo</option>
                <option value="CANCELADO">Cancelado</option>
                <option value="CONCLUIDO">Concluído</option>
            </select>
            <select name="alimento">
    			<c:forEach var="alimento" items="${alimentos}">
        			<option value="${alimento.id}">${alimento.nome}</option>
    			</c:forEach>
			 </select>
			 
    	  	 <input type="number" id="QuantidadeDoacao" name="quantidade"  placeholder="Quantidade" required>
            <input type="number" id="meta_doações" name="meta" placeholder="Meta de Doações" class="padrao_input">
            <input type="date" id="data_final" name="data" placeholder="O pedido irá durar até dia..." class="padrao_input">
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