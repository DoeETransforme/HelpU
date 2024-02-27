<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
    <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
    <style type="text/css"> <%@include file="/resources/css/propostas-pendentes.css"%></style> 
    <script><%@include file="/resources/js/Script.js"%></script>
    <style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
    <link rel="stylesheet" href="../css/estilo.css">
</head>

<body>
		<%@ include file="../cabecalhos/menu.jsp" %>

    
    <main>
    <div class="titulo">
    <h1> Suas propostas Pendentes:</h1>
    </div>
    
    		<div class="container">
              <c:forEach var="propostas" items="${propostas}">  	
		          <div class="card-pedidos">							          	
							<div class="descricao-card">						
		          				<span class="titulo-card">Para: ${propostas.pedidoDoacao.ong.nome}</span>
		                        <span class="texto-card">Feito em: ${propostas.dataCriacao}</span>
		                        <span class="texto-card">No Pedido: ${propostas.pedidoDoacao.titulo}</span>
 
                				<a class="botao-pedido" href="<%=request.getContextPath()%>/descricao-proposta?id=<c:out value='${propostas.id}'/>">Descricao</a>

		        		   </div>
							
				 </div>
			</c:forEach>
     	</div>
       
    </main>

</body>
</html>