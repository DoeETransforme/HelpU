<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
    <link rel="stylesheet" href="../css/estilo.css">
        <!--<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>-->
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
                   
                    <select name="tipo-item" id="tipo-item" class="padrao-input">
                        <option value="" disabled selected>Selecione o tipo de item</option>
                        <option value="alimento">Alimento Não-Perecível</option>
                    </select>
            
                  
                    <input type="text" id="item" name="item" class="padrao-input" placeholder="Item">
            
                   
                    <input type="number" id="quantidade" name="quantidade" class="padrao-input" placeholder="Quantidade">
            
                    
                    <div><input type="date" id="data-validade" name="data-validade" class="data-nascimento-padrao"></div>
                </div>
            
                <button type="button" class="padrao-submit">Adicionar item</button>
                <button type="submit" class="padrao-submit">Salvar edições</button>
            </form>
            
            
        </main>
</body>

</html>