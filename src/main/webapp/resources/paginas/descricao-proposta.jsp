<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
</head>
<body>

		<%@ include file="menu.jsp"%>
		
		   <main>

        <div class="avaliar-proposta">
            <img src="../imagens/perfil-icon.png" alt="Imagem de perfil do usuario" id="imagem-PF-avaliarProposta">
            <h2> Doação de: <c:out value="${ itemRecuperado.propostaDoacao.doador.nome}" /> </h2>
        </div>
        
       
           
                <div class="descricao">
                    <div>
                        <p>Doação feita no pedido: <c:out value="${proposta.pedidoDoacao.titulo }" /> </p>
                         <p> Status da proposta: <c:out value="${proposta.statusProposta}" /> </p>
                        <p>Tipo de item doado: Alimento </p>
                        <c:forEach var="proposta" items="${propostas}">
					   		 <c:forEach var="item" items="${proposta.itens}">
						        <p>Quantidade Doada: <c:out value="${item.quantidade}"/> </p>
						        <p>Validade: <c:out value="${item.alimento.dataValidade}" /></p>
					   		 </c:forEach>
						</c:forEach>
						                      
                        
                        <button type="button" class="botão_padrão"><a href="<%=request.getContextPath()%>/editar-proposta?id=<c:out value='${proposta.id}'/>">Editar</a></button>
                		<button type="button" class="botão_padrão"> <a href="<%=request.getContextPath()%>/excluir-proposta?id=<c:out value='${proposta.id}'/>">Deletar</a></button>                
                    </div>
                
                </div>
                
                
    </main>
</body>
</html>