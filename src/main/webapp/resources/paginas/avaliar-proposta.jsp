<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
<!--  <script src="../js/Script.js"></script> -->
<script><%@include file="/resources/js/Script.js"%></script>
<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
<style type="text/css"> <%@include file="/resources/css/perfil-doador.css"%></style>


   
</head>
<body>
    <%@ include file="../cabecalhos/menu.jsp" %>

    
<div class="titulo">
    <h1>Editar Conquista</h1>
</div>

    <main>
 
        <div class="avaliar-proposta">
            <img alt="foto do doador" id="foto-doador-proposta" src="<c:out value='${doador.fotoUsuario.urlFoto()}'/>">
 
 
            <h2> Doação de: <c:out value="${proposta.doador.nome}" /> </h2>
        </div>
        
       
           
                <div class="descricao">
                    <div>
                        <p>Doação feita no pedido: <c:out value="${proposta.pedidoDoacao.titulo }" /> </p>
                        <p>Contato(telefone): <c:out value="${propostaContato.doador.usuario.contato.celular}" /> </p>
                        <p>Contato(Email):  <c:out value="${propostaContato.doador.usuario.contato.email}" /></p>
                       
                        <p>Tipo de item doado: Alimento </p>
                        
	                        <c:forEach var="item" items="${proposta.itens}">
			          				<span>Validade: <c:out value="${item.alimento.dataValidade}" /></span>
		                        	<span>Quantidade Doada: <c:out value="${item.quantidade}"/> </span>
							</c:forEach>
							
                		 <p> Status da proposta: <c:out value="${proposta.statusProposta}" /> </p>
                    </div>
                
                </div>
                
                

                <div class="validar-invalidar">
                    <a id="validar-proposta"  href="<%=request.getContextPath()%>/validar-proposta?id=<c:out value='${proposta.id}'/>">Validar Proposta</a>
                    <a id="invalidar-proposta" href="<%=request.getContextPath()%>/invalidar-proposta?id=<c:out value='${proposta.id}'/>">Invalidar Proposta</a>
                </div>

    </main>
    
</body>
</html>