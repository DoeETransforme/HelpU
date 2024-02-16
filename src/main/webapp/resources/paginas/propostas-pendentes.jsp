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
    
</head>

<body>

    <%@ include file="menu.jsp"%>
    
    <main>
              <c:forEach var="propostas" items="${propostas}">  	
          <tr>			
          				<td><c:out value="${propostas.pedidoDoacao.ong.nome}" /></td>
                        <td><c:out value="${propostas.dataCriacao}" /></td>
                        <td><c:out value="${propostas.statusProposta}" /></td>
             <div>
                <button type="button" class="botão_padrão"><a href="<%=request.getContextPath()%>/descricao-proposta?id=<c:out value='${proposta.id}'/>">Descricao</a></button>
            </div>
          </tr>
			</c:forEach>
     
       
    </main>

</body>
</html>