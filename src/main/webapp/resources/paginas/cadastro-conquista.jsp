<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
   <style type="text/css"><%@include file="/resources/css/estilo.css"%></style>
   <link rel="stylesheet" href="../css/estilo.css">
</head>
<body>

    <%@ include file="menu.jsp"%>
    <div class="titulo">
        <h1>Cadastrar Conquista</h1>
    </div>
    
    <main>
        <form action="inserir-conquista" method="post" class="forms">
            <div>
                <input type="text" class="padrao-input" name="nome" placeholder="Nome da Conquista">
            </div>
            <div>
                <textarea name="descricao"  class="padrao-textarea" placeholder="Descrição da Conquista!"></textarea>
            </div>
            <div>
                <button type="submit" class="padrao-submit">Cadastrar</button>
            </div>
        </form>
    </main>  
</body>
</html>