<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>HelpU</title>
        <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style> 
        <script><%@include file="/resources/js/Script.js"%></script>
        <style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
    </head>

<body>
   <%@ include file="../cabecalhos/menu.jsp" %>
        <div class="titulo">
            <h1>Editar Pedido de Doação</h1>
        </div>
        <form action="pedido-editado" method="post" class="forms"> 
       
        	<c:if test="${pedido != null}">
						<input type="hidden" name="id" value="<c:out value='${pedido.id}' />" />
					</c:if>

          <div>
              <input type="text" id="Titulo_pedido" name="titulo" placeholder="Qual o título do pedido?" class="padrao-input">
                <textarea placeholder="Escreva sobre o pedido!" name="descricao" rows="1" class="padrao-input"></textarea>
    
                    <select name="status" id="Status_pedido" class="padrao-input">
                        <option value="" disabled selected>Qual o  status atual?</option>
                        <option value="ATIVO">Ativo</option>
                        <option value="CANCELADO">Cancelado</option>
                        <option value="CONCLUIDO">Concluído</option>
                    </select>
              
              
                    <select name="alimento" class="padrao-input">
                                    <c:forEach var="alimento" items="${alimentos}">
                            <option value="" disabled selected> Selecione o alimento</option>
                                        <option value="${alimento.id}">${alimento.nome}</option>
                                    </c:forEach>
                                 </select>
                       
                         
                      <input type="number" id="QuantidadeDoacao" name="quantidade"  placeholder="Quantidade" required class="padrao-input">
              <input type="number" id="meta_doações" name="meta" placeholder="Meta de Doações" class="padrao-input">
               <input type="date" id="data_final" name="data" placeholder="O pedido irá durar até dia..." class="padrao-input">
          </div>
            
            <h2 class="titulo">Quais itens são necessários?</h2>
            <div id="adicionar_mais_itens" class="titulo">
            <ul>
                <li>Arroz</li>
                <li>Macarrão</li>
            </ul>
            <button type="button" id="adicionar_mais_itens" class="padrao-input">Solicitar mais itens +</button>
            </div>
     
            <button type="submit" id="alteração_pedido" class="padrao-submit">Pronto</button>
       
        </form>
</body>

           </html>