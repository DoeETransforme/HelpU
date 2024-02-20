<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Helpu</title>
        <link rel="stylesheet" href="../css/estilo.css">
   <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
   <script><%@include file="/resources/js/Script.js"%></script>
    </head>

    <body>
        <div>
   			<div class="menu-hamburguer" id="menu-hamburguer">
	
		<div class="hamburguer" onclick="toggleMenu()">☰</div>
	</div>
	
	<div class="menu-lateral" id="menu-lateral">
		<%@ include file="../cabecalhos/menu.jsp" %>
	</div>
            <main class="titulo">
                <h1>Prospota Realizada com sucesso</h1>
                <p>Você pode conferir o status de sua proposta em "minhas propostas"!</p>
                <br>
                <p>Para continuar navegando em nosso site e poder fazer mais doações<a
                        href="explorar-pedidos.jsp">clique aqui</a></p>
            </main>
        </div>