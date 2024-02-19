<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>HelpU</title>
</head>
<body>
<main>
    <form action="pesquisar-pedido" method="post" class="forms">
        <div>
            <select name="status" id="Status_pedido" class="padrao-input">
                <option value="" disabled selected>Status do Pedido</option>
                <option value="ATIVO">Ativo</option>
                <option value="CANCELADO">Cancelado</option>
                <option value="CONCLUIDO">Concluído</option>
            </select>
        </div>
        <div>
            <input type="text" id="nome_ong" name="nome" placeholder="Nome da Ong">
        </div>
        <div>
            <input type="date" id="data_inicio_pedido" name="datainicial" placeholder="Data de Início">
        </div>
        <div>
            <input type="date" id="data_termino_pedido" name="datafinal" placeholder="Data de Término">
        </div>
        <div>
            <select name="alimento" class="padrao-input">
                <option value="" disabled selected>Selecione o alimento</option>
                <c:forEach var="alimento" items="${alimentos}">
                    <option value="${alimento.id}">${alimento.nome}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="padrao-submit" id="submit_pesquisar">Pesquisar</button>
    </form>
</main>
</body>
</html>
