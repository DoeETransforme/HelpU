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
            <div class="header-editar-proposta">
                <div class="header-imagem-editar"><img src="../imagens/logo-final.png" alt="imagem da ong"></div>
                <div class="header-p-editar">
                    <p>Login</p>
                </div>
            </div>
            <div class="titulo">
                <h2>Editar Proposta</h2>
            </div>
            <form action="" method="post" class="forms-editar-proposta">


                <div class="conteudo-editar">
                    <select name="tipo-item" id="tipo-item" >
                        <option value="" disabled selected>Selecione o tipo de item</option>
                        <option value="alimento">Alimento Não-Perecível</option>
                    </select>
                    <input type="text" id="item" name="item"  placeholder="Item">
                    <input type="number" id="quantidade" name="quantidade" 
                        placeholder="Quantidade">

                    <input type="date" id="data-validade" name="data-validade">
                </div>


                <div class="botoes-editar">
                    <button type="button" class="padrao-submit">Adicionar item</button>
                    <button type="submit" class="padrao-submit">Salvar edições</button>
                </div>
            </form>


        </main>
</body>

</html>