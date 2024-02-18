<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
   <style type="text/css"><%@include file="/resources/css/estilo.css"%></style>
   <link rel="stylesheet" href="../css/estilo.css">
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
        <h1>Cadastrar Conquista</h1>
    </div>
    
    <main>
        <form action="inserir-conquista" method="post" class="forms">
            <div>
                <input type="text" class="padrao-input" name="nome" placeholder="Nome da Conquista">
            </div>
            <div>
                <textarea name="descricao"  class="padrao-textarea" placeholder="Descriï¿½ï¿½o da Conquista!"></textarea>
            </div>
            <div>
                <button type="submit" class="padrao-submit">Cadastrar</button>
            </div>
        </form>
    </main>  
</body>
</html>