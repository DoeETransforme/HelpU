<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
    <!--<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
    <link rel="stylesheet" href="../css/estilo.css">-->
    <link rel="stylesheet" href="../css/estilo.css">
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
                        <p>Doação feita no pedido: <c:out value="${itemRecuperado.pedidoDoacao.titulo }" /> </p>
                        <p>Contato(telefone): <c:out value="${contatoRecuperado.celular}" /> </p>
                        <p>Contato(Email):  <c:out value="${contatoRecuperado.email}" /></p>
                        <p>Tipo de item doado: Alimento </h3>
                        <p>Validade:<c:out value="${ itemRecuperado.alimento.dataValidade}" /></p>
                        <p>Quantidade Doada: <c:out value="${ itemRecuperado.quantidade}"/> </p>
                        <p> Status da proposta: <c:out value="${itemRecuperado.propostaDoacao.statusProposta}" /> </p>
                
                    </div>
                
                </div>
                
                
                <div class="validar-invalidar">
                    <form action="validar-proposta" method="post">
                        <button type="submit" class="padrao-input" id="validar-proposta">Validar Doação</button>
                    </form>
                    <form action="invalidar-proposta" method="post">
                        <button type="submit" class="padrao-input"  id="invalidar-proposta">Invalidar Doação</button>
                    </form>
                </div>
    </main>
    
</body>
</html>