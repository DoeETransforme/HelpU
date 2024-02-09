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
            <div class="titulo">
                <h2>Editar Proposta</h2>
            </div>
            <div class="header"> 
                <p>Login</p>
                <img src="../imagens/logo-final.png" alt="imagem da ong">
            </div>
            <form action="" method="post" class="forms">
                <div>
                    <label for="tipo-item">Tipo de Item:</label>
                    <select name="tipo-item" id="tipo-item" class="padrao-input">
                        <option value="alimento">Alimento Não-Perecível</option>
                    </select>
            
                    <label for="item">Item:</label>
                    <input type="text" id="item" name="item" class="padrao-input" placeholder="Item">
            
                    <label for="quantidade">Quantidade:</label>
                    <input type="number" id="quantidade" name="quantidade" class="padrao-input" placeholder="Quantidade">
            
                    <label for="data-validade">Data de Validade:</label>
                    <input type="date" id="data-validade" name="data-validade" class="data-nascimento-padrao">
                </div>
            
                <button type="button" class="padrao-submit">Adicionar mais itens</button>
                <button type="submit" class="padrao-submit">Salvar Proposta</button>
            </form>
            
            
        </main>
</body>

</html>