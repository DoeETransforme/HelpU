<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
    <link rel="stylesheet" href="../css/estilo.css">
    <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
    <style type="text/css"> <%@include file="/resources/css/propostas-pendentes.css"%></style> 
    <script><%@include file="/resources/js/Script.js"%></script>
    
</head>

<body>

   <div class="menu-hamburguer" id="menu-hamburguer">
	
		<div class="hamburguer" onclick="toggleMenu()">☰</div>
	</div>
	
	<div class="menu-lateral" id="menu-lateral">
		<%@ include file="../cabecalhos/menu.jsp" %>
	</div>
    
    <main>
    <div class="titulo">
    <h3> Suas propostas Pendentes:</h3>
    </div>
              <c:forEach var="propostas" items="${propostas}">  	
		          <div class="propostas-doacao-analise">
							<div class="imagem-card"><img src="../imagens/perfil-icon.png" alt=""></div>
							
							<div class="conteudo">						
		          				<h4>${propostas.pedidoDoacao.ong.nome}</h4>
		                        <span class="descricao-proposta">Feito em: ${propostas.dataCriacao}</span>
		                        <span class="descricao-proposta">No Pedido: ${propostas.pedidoDoacao.titulo}</span>
 
                				<a href="<%=request.getContextPath()%>/descricao-proposta?id=<c:out value='${propostas.id}'/>">Descricao</a>

		        		   </div>
							
				 </div>
			</c:forEach>
     
       
    </main>

</body>
</html>