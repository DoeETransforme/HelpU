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

    <%@ include file="menu.jsp" %>


        <main>
            <div class="header-editar-proposta">
                <div class="header-imagem-editar"><img src="../imagens/logo-final.png" alt="imagem da ong"></div>
                <div class="header-p-editar">
                    <p>Login</p>
                </div>
            </div>
            <div class="titulo">
                <h2>Editar Proposta</h2>
            </div>
            <form action="" method="post" class="forms-editar-proposta">
              
              <div>
              <c:if test="${proposta != null}">
								<input type="hidden" name="id"
									value="<c:out value='${proposta.id}' />" />
							</c:if>
               </div>

                <div class="conteudo-editar">                  
                  <c:forEach name="tipo-item" id="tipo-item" var="alimento" items="${alimentos}">
                                       

									      <option value="${alimento.id}">${alimento.nome}</option>
								  </c:forEach>
                  
                    <input type="text" id="item" name="item"  placeholder="Item">
                    <input type="number" id="quantidade" name="quantidade" 
                        placeholder="Quantidade">

                    <input type="date" id="data-validade" name="data-validade">
                </div>


                <div class="botoes-editar">
                    <button type="button" class="padrao-submit">Adicionar item</button>
                    <button type="submit" class="padrao-submit">Salvar edições</button>
                </div>
            </form>
        </main>

</body>

</html>
