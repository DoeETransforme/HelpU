<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
 <style type="text/css"><%@include file="/resources/css/estilo.css"%></style>
   <script><%@include file="/resources/js/Script.js"%></script> 
   <script><%@include file="/resources/js/menu-topo.js"%></script>
   <link rel="stylesheet" href="../css/estilo.css">
</head>
<body>

<div class="menu-hamburguer" id="menu-hamburguer">
	
		<div class="hamburguer" onclick="toggleMenu()">☰</div>
	</div>
	
	<div class="menu-lateral" id="menu-lateral">

						<%@ include file="../cabecalhos/menu.jsp" %>

	</div>
	    <div class="titulo">
        <h1>Cadastrar Conquista</h1>
    </div>
    
    <main>
        <form action="inserir-conquista" method="post" class="forms" enctype="multipart/form-data">
          
                <div>
                    <input type="text" class="padrao-input" name="nome" placeholder="Nome da Conquista">
                    <textarea name="descricao"  class="padrao-input" placeholder="Descricao da Conquista!"></textarea>
                    <label for="foto">Escolha uma foto:</label>
               		<input type="file" id="foto" name="foto">
                    
                </div>
                <button type="submit" class="padrao-submit">Cadastrar</button>
        </form>
    </main>  
</body>
</html>