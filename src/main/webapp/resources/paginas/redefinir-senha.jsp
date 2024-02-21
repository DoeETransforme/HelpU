<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
    <link rel="stylesheet" href="../css/redefinir-senha.css">
    <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
    <script><%@include file="/resources/js/Script.js"%></script>
</head>

<body>
   
      <div class="menu-hamburguer" id="menu-hamburguer">
	
		<div class="hamburguer" onclick="toggleMenu()">☰</div>
	</div>
	
	<div class="menu-lateral" id="menu-lateral">
		<c:choose>
					<c:when test="${tipoUsuario == 2}">

						<%@ include file="menu.jsp" %>

					</c:when>
				</c:choose>
	</div>
  
    <div class="titulo">
        <h1>Para redefinir sua senha, siga os passos a seguir:</h1>
    </div>

    <main>
        <div class="redefinir-senha">
    <div>
        <input class="padrao_input" type="password" id="novasenha" placeholder="Cria uma nova senha" required>
       
    </div>
    <ol>
        <ul>
            <li>Letras maiúsculas e minúsculas</li>
            <li>Mínimo de 10 caracteres</li>
            <li>Ter números</li>
            <li>Ter símbolos</li>
            <li>Sem sequências numéricas</li>
        </ul>
    </ol>
    <div><input class="padrao_input" type="password" placeholder="Confirmar nova senha" required></div>
    <button type="submit" class="botão_padrão">Confirmar</button>
</div>


    </main>
</body>

</html>