<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
</head>
<body>

    <header>
        <div>
            
                <a href="Pagina_I nicial.html"><img src="logo-imagem.com" alt="Logo"></a>
        
            <input type="search" placeholder="Pesquisar">
        </div>
        <nav>
            <a href="./login.jsp">Login</a>
            <a href="./Cadastro.jsp">Cadastro</a>
        </nav>
    </header>


    <main>

        <img src="imagem.com" alt="Imagem de perfil do usuario" class="ImagemPerfil_PF">
        
        <h2> Doação de: <c:out value="${ itemRecuperado.propostaDoacao.doador.nome}" /> </h2>
        <h3>Doação feita no pedido: <c:out value="${itemRecuperado.pedidoDoacao.titulo }" /> </h3>
        <h3>Contato(telefone): <c:out value="${contatoRecuperado.celular}" /> </h3>
        <h3>Contato(Email):  <c:out value="${contatoRecuperado.email}" /></h3>
        <h3>Tipo de item doado: Alimento </h3>
        <h3>Validade:<c:out value="${ itemRecuperado.alimento.dataValidade}" /></h3>
        <h3>Quantidade Doada: <c:out value="${ itemRecuperado.quantidade}"/> </h3>
        
        <h2> Status da proposta: <c:out value="${itemRecuperado.propostaDoacao.statusProposta}" /> </h2>
        
        
        <form action="validar-proposta" method="post">
        <button>Validar Doação</button>
        </form>
         <form action="invalidar-proposta" method="post">
        <button>Invalidar Doação</button>
             </form>
        
    </main>
    
</body>
</html>