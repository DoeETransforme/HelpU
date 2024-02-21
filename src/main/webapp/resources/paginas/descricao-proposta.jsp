<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
<script><%@include file="/resources/js/Script.js"%></script>
<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style> 
<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
</head>
<body>
		<%@ include file="../cabecalhos/menu.jsp" %>
		
		   <main>
           
                <div class="descricao">
                    <div>
                        
    <div class="avaliar-proposta">
        <img src="../imagens/perfil-icon.png" alt="Imagem de perfil do usuário" id="imagem-PF-avaliarProposta">
          <h2>Doação de: <c:out value="${proposta.pedidoDoacao.ong.nome}" /></h2> 
    </div>
    <div class="descricao">
         <p>Doação feita no pedido: <c:out value="${proposta.pedidoDoacao.titulo}" /></p>  
        <p>Status da proposta: <c:out value="${proposta.statusProposta}" /></p>
        <p>Tipo de item doado: Alimento</p>
 
        	<c:forEach var="item" items="${proposta.itens}">
	            <span>Quantidade Doada: <c:out value="${item.quantidade}" /></span>
	            <span>Validade: <c:out value="${item.alimento.dataValidade}" /></span>
            </c:forEach>  

        <button type="button" class="botão_padrão"><a href="<%=request.getContextPath()%>/editar-proposta?id=<c:out value='${proposta.id}'/>">Editar</a></button>
        <button type="button" class="botão_padrão"><a href="<%=request.getContextPath()%>/excluir-proposta?id=<c:out value='${proposta.id}'/>">Deletar</a></button>
    </div>
		  
                    </div>
                
                </div>
                
                
    </main>
</body>
</html>