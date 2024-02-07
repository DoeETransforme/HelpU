<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Helpu</title>
    
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>

   <%@ include file="menu.jsp"%>

    <img src="link_da_imagem" alt="Imagem de Perfil">

    <h2><span id="doacoesRealizadas"></span> Conquistas realizadas = <c:out value="${conquistas}" /></h2>
    <h2><span id="doacoesFeitas"></span> doações feitas = </h2>

    <h1>Nome do Usuário:<c:out value="${doador.nome}"/></h1>
     

    <button onclick="exibirHistorico()">Histórico de Doações</button>
    <button onclick="exibirConquistas()">Exibir Conquistas</button>

    <div class="achievements">
        <img src="conquista1.jpg" alt="Conquista 1">
        <p>Conquista Realizada 1</p>

        <img src="conquista2.jpg" alt="Conquista 2">
        <p>Conquista Realizada 2</p>

        <img src="conquista3.jpg" alt="Conquista 3">
        <p>Conquista Realizada 3</p>
    </div>

    
</body>
</html>