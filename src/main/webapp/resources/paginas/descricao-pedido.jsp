<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
</head>
<body>
    <%@ include file="menu.jsp"%>
    <main>
        <div>
            <h1>Título:</h1>
            <p><c:out value="${pedidoDoacao.titulo}" /></p>
            <img src="Imagem.png" alt="Capa do Pedido" id="capa_pedido">
            <img src="" alt="Imagem Perfil" class="ImagemPerfil_PF">
            <p>
                Por <span id="NomeCompletoOng"><c:out value="${pedidoDoacao.ong.nome}" /></span>
            </p>
        </div>
        <div>
            <p><c:out value="${pedidoDoacao.descricao}" /></p>
        </div>
        <div>
            <h3>Progresso do Pedido</h3>
            <h4>
                Status do Pedido: <c:out value="${pedidoDoacao.StatusPedido}" />
            </h4>
        </div>
        <!-- Barra de progresso -->
        <div>
            <progress value="50" max="100"></progress>
        </div>
        <div>
            <a href="<%=request.getContextPath()%>/cadastro-proposta">
                <button class="botao-padrao" type="button">Ajude e doe agora mesmo!</button>
            </a>
        </div>
        <div>
            <h1>Doadores</h1>
        </div>
        <div>
            <img src="Imagem.jpg" alt="Foto de Perfil" class="ImagemPerfil_PF">
            <p>
                <span id="nome">Enya Lohana</span> doou <span class="Quantidade">5kg</span>
                de <span class="Item">arroz</span>
            </p>
        </div>
        <div>
            <h2>Conheça outros projetos de doações</h2>
        </div>
        <div>
            <img src="imagem.jpg" alt="Capa de Projeto" id="capa_pedido">
        </div>
        <div>
            <img src="imagem.jpg" alt="Capa de Projeto" id="capa_pedido2">
        </div>
    </main>
</body>
</html>
