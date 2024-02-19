<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<c:when test="${tipoUsuario == 2}">

						<%@ include file="menu.jsp" %>

					</c:when>
				</c:choose>
	</div>
  

    <main>
        <div>
            <h1>Para redefinir sua senha, siga os passos a seguir:</h1>
            <input class="padrao_input" type="password" class="padrao_input" id="novasenha"
                placeholder="Cria uma nova senha" required>
            <p> Sua nova senha deve possuir as seguintes regras:</p>
        </div>
        <div>
            <ol>
                <ul>
                    <li>Letras maisuculas e minusculas</li>
                    <li>Minimo de 10 carcteres</li>
                    <li>Ter números</li>
                    <li>Ter simbolos</li>
                    <li>Sem sequencias numericas</li>
                </ul>
            </ol>
        </div>
        <div>
            <input class="padrao_input" type="password" class="padrao_input" placeholder="Confirmar nova senha"
                required>
        </div>
        <div>
            <button type="submit" class="botão_padrão">Confirmar</button>
        </div>
    </main>
</body>

</html>