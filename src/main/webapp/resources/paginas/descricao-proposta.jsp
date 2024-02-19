<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
<script><%@include file="/resources/js/Script.js"%></script>
<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style> 
<style type="text/css"> <%@include file="/resources/css/descricao-proposta.css"%></style>
</head>
<body>
	<div class="menu-hamburguer" id="menu-hamburguer">
	
		<div class="hamburguer" onclick="toggleMenu()">☰</div>
	</div>
	
	<div class="menu-lateral" id="menu-lateral">
		<c:choose>
					<c:when test="${tipoUsuario == 1}">
						<%@ include file="menu.jsp" %>
					</c:when>
				</c:choose>
	</div>
		
		   <main>
           
                <div class="descricao-proposta">
                    <div>
                        
					    <div class="avaliar-proposta">
					        <img src="../imagens/perfil-icon.png" alt="Imagem de perfil do usuário" id="imagem-PF-avaliarProposta">
					          <h2>Doação de: <c:out value="${proposta.doador.nome}" /></h2> 
						</div>
						
						<div class="linha" ></div>
						
					    <div >
					         <span class="descricao-span">Doação feita no pedido: ${proposta.pedidoDoacao.titulo}></span>  
					         <span class="descricao-span">Status da proposta: ${proposta.statusProposta}</span>
					         <span class="descricao-span">Tipo de item doado: Alimento</span>
					 
					         <c:forEach var="item" items="${proposta.itens}">
						     	<span class="descricao-span">Quantidade Doada:${item.quantidade}</span>
						        <span class="descricao-span">Validade:${item.alimento.dataValidade}</span>
					         </c:forEach>
					    </div>
					           <div class="linha" ></div>
						<div class="botoes-align">
					        <a class="botao-link" href="<%=request.getContextPath()%>/editar-proposta?id=<c:out value='${proposta.id}'/>">Editar</a>
					        <a class="botao-link" href="<%=request.getContextPath()%>/excluir-proposta?id=<c:out value='${proposta.id}'/>">Deletar</a>
						</div>
					</div>	
				</div>	
							
					    
		  
              	    
                
              
                
                
    </main>
</body>
</html>