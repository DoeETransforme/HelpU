<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
    <link rel="stylesheet" href="../css/estilo.css">
    <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
    <script><%@include file="/resources/js/Script.js"%></script>
    
</head>

<body>

   <div class="menu-hamburguer" id="menu-hamburguer">
	
		<div class="hamburguer" onclick="toggleMenu()">☰</div>
	</div>
	
	<div class="menu-lateral" id="menu-lateral">
		<c:choose>
					<c:when test="${tipoUsuario == 1}">

						<%@ include file="menu.jsp" %>

					</c:when>
				</c:choose>
	</div>
    
    <main>
    <div class="titulo">
    <h3> Suas propostas Pendentes:</h3>
    </div>
              <c:forEach var="propostas" items="${propostas}">  	
          <tr>			
          				<td><c:out value="${propostas.pedidoDoacao.ong.nome}" /></td>
                        <td><c:out value="${propostas.dataCriacao}" /></td>
                        <td><c:out value="${propostas.statusProposta}" /></td>
             <div>
                <button type="button" class="botão_padrão"><a href="<%=request.getContextPath()%>/descricao-proposta?id=<c:out value='${propostas.id}'/>">Descricao</a></button>
            </div>
          </tr>
			</c:forEach>
     
       
    </main>

</body>
</html>