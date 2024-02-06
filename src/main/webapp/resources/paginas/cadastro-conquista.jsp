<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
</head>
<body>

    <%@ include file="menu.jsp"%>
    
    <main>
        <form action="inserir-conquista" method="post">
            <div>
                <h1>Cadastrar Conquista</h1>
            </div>
            <div>
                <input type="text" class="padrao-input" name="nome" placeholder="Nome da Conquista">
            </div>
            <div>
                <textarea name="descricao"  class="padrao-input" placeholder="Descrição da Conquista!"></textarea>
            </div>
            <div>
                <button type="submit" class="botao-padrao">Cadastrar</button>
            </div>
        </form>
    </main>  
</body>
</html>