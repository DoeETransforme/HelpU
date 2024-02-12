<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
    <link rel="stylesheet" href="../css/estilo.css">
</head>

<body>

    <%@ include file="menu.jsp"%>
    
    <main>
        <div>
            <div class="titulo">
                <h1>Suas Propostas Pendentes</h1>
            </div>
            
            <div>
                <h4><span id="Quantidade">5kg</span> de <span id="item">Feijão</span> para <span
                        id="Nome_Ong">Cantinho Inclusão</span></h4>
                <h5>Prazo para confirmar pedido: 01/02/2024</h5>
            </div>
            <div>
                <button type="button" class="botão_padrão"><a href="editar-propsota.jsp">Editar</a></button>
                <button type="button" class="botão_padrão"><a href="excluir-proposta.jsp">Excluir</a></button>
            </div>
            <br>
            <div>
                <h4><span id="Quantidade">2kg</span> de <span id="item">Café</span> para <span
                        id="Nome_Ong">Humanidade em Ação</span></h4>
                <h5>Prazo para confirmar pedido: 02/02/2024</h5>
            </div>
            <div>
                <button type="button" class="botão_padrão"><a href="editar-propsota.jsp">Editar</a></button>
                <button type="button" class="botão_padrão">Excluir</button>
            </div>
        </div>
    </main>
</body>
</html>