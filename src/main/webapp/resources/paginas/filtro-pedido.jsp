<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>HelpU</title>
</head>
<link rel="stylesheet" href="../css/estilo.css">
<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>

<script><%@include file="/resources/js/Script.js"%></script>
<link rel="stylesheet" href="../css/estilo.css">
<link rel="stylesheet" href="../css/menu-topo.css">


<body>
<main>
    
        <form action="pesquisar-pedido" method="post" >
      
                <div class="filtro-pesquisa">
                    
                    <h1>Filtros de pesquisa</h1>
                    <select name="status" id="Status_pedido" class="padrao-input">
                        <option value="" disabled selected>Status do Pedido</option>
                        <option value="ATIVO">Ativo</option>
                        <option value="CANCELADO">Cancelado</option>
                        <option value="CONCLUIDO">Concluído</option>
                    </select>
                    <input class="padrao-input"  type="text" id="nome_ong" name="nome" placeholder="Nome da Ong">
                    <input class="padrao-input"  type="date" id="data_inicio_pedido" name="datainicial" placeholder="Data de Início">
                    <input class="padrao-input" type="date" id="data_termino_pedido" name="datafinal" placeholder="Data de Término">
                    <select name="alimento" class="padrao-input">
                        <option value="" disabled selected>Selecione o alimento</option>
                        <c:forEach var="alimento" items="${alimentos}">
                            <option value="${alimento.id}">${alimento.nome}</option>
                        </c:forEach>
                    </select>
                    <button type="submit" class="padrao-submit" id="submit_pesquisar">Pesquisar</button>
                </div>
          
        
        </form>
  
</main>
</body>
</html>
