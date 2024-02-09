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
    <link rel="stylesheet" href="../css/estilo.css">
</head>
<body>

    <%@ include file="menu.jsp"%>

    <main>

        <div class="titulo">
            <h2> Doação de: <c:out value="${ itemRecuperado.propostaDoacao.doador.nome}" /> </h2>
            <img src="imagem.com" alt="Imagem de perfil do usuario" class="ImagemPerfil_PF">
        </div>
        
       
            <div class="descricao">
                <p>Doação feita no pedido: <c:out value="${itemRecuperado.pedidoDoacao.titulo }" /> </p>
                <p>Contato(telefone): <c:out value="${contatoRecuperado.celular}" /> </p>
                <p>Contato(Email):  <c:out value="${contatoRecuperado.email}" /></p>
                <p>Tipo de item doado: Alimento </h3>
                <p>Validade:<c:out value="${ itemRecuperado.alimento.dataValidade}" /></p>
                <p>Quantidade Doada: <c:out value="${ itemRecuperado.quantidade}"/> </p>
                <p> Status da proposta: <c:out value="${itemRecuperado.propostaDoacao.statusProposta}" /> </p>
            </div>
      
        
        
        
        <form action="validar-proposta" method="post" class="descricao">
        <button type="submit" class="padrao-input">Validar Doação</button>
        </form>
         <form action="invalidar-proposta" method="post" class="descricao">
        <button type="submit" class="padrao-input">Invalidar Doação</button>
             </form>
        
    </main>
    
</body>
</html>