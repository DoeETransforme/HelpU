<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width= , initial-scale=1.0">
    <title>HelpU</title>
    <link rel="stylesheet" href="../css/estilo.css">
  <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style> 
  <script><%@include file="/resources/js/Script.js"%></script>
  <style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
  <script><%@include file="/resources/js/menu-topo.js"%></script>
</head>

<body>

						<%@ include file="../cabecalhos/menu.jsp" %>

    <main>

        <div>
           
            <div class="titulo">
                <h1>Para desativar sua conta</h1>
            </div>
          
                
                <form action="conta-desativada" method="post" class="forms">
                      
                       <div>
                           <input type="email" id="LoginEmail" name="email" placeholder="E-mail de login" required class="padrao-input">
                            <input type="password" id="LoginSenha" name="senha" placeholder="Senha de login" required class="padrao-input">
                        </div>
                        <input type="submit" name="DesativarConta" id="DesativarContaPF" value="confirmar" class="padrao-submit">
                    </form>
             
          
        </div>
    </main>
</body>

</html>