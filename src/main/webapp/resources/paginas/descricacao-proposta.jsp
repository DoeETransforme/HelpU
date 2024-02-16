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
                        <p>Tipo de item doado: Alimento </p>
                        <p>Validade:<c:out value="${ itemRecuperado.alimento.dataValidade}" /></p>
                        <p>Quantidade Doada: <c:out value="${ itemRecuperado.quantidade}"/> </p>
                        <p> Status da proposta: <c:out value="${itemRecuperado.propostaDoacao.statusProposta}" /> </p>
                        
                        <button type="button" class="botão_padrão"><a href="<%=request.getContextPath()%>/editar-proposta?id=<c:out value='${proposta.id}'/>">Editar</a></button>
                		<button type="button" class="botão_padrão"> <a href="<%=request.getContextPath()%>/excluir-proposta?id=<c:out value='${proposta.id}'/>">Deletar</a></button>                
                    </div>
                
                </div>
                
                
    </main>
</body>
</html>