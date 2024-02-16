<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
	<link rel="stylesheet" href="../css/estilo.css">
	 <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
</head>
<body>

    <%@ include file="menu.jsp"%>
3
    <main>
        <div class="titulo">
			<h1>Seu histórico de doações</h1>
		</div>
        
        
        
        <c:forEach var="propostaDoacao" items="${propostaDoacao}">
				<div class="propostas-doacao-analise">
					<div class="conteudo">
						<h2 >
							Doação para: <span id="Nome_Ong">${propostaDoacao.pedidoDoacao.ong.nome}</span>
						</h2>
						<p>
							Por: <span id="nomeUsuario">${propostaDoacao.doador.nome}</span>
						</p>
						<p>
							Status: <span>${propostaDoacao.statusProposta}</span>
						</p>
					</div>
				</div>
				
			</c:forEach>
<!--         <ol> -->
<!--             <li>Doação de <span class="Quantidade">5kg</span> de <span class="Item">arroz</span> para ONG <span class="Nome_Ong">humanidade em ação</span></li> -->
<!--             <li>Doação de <span class="Quantidade">5kg</span> de <span class="Item">arroz</span> para ONG <span class="Nome_Ong">humanidade em ação</span></li> -->
<!--             <li>Doação de <span class="Quantidade">5kg</span> de <span class="Item">arroz</span> para ONG <span class="Nome_Ong">humanidade em ação</span></li> -->
<!--         </ol> -->
    </main>
</body>
</html>
