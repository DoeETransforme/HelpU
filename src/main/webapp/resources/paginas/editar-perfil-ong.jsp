<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Helpu</title>
    <link rel="stylesheet" href="../css/estilo.css">
    <!--<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>-->
</head>

<body>

    <%@ include file="menu.jsp"%>

    <div class="header-editar-proposta">
        <div class="header-imagem-editar"><img src="../imagens/logo-final.png" alt="imagem da ong"></div>
        <div class="header-p-editar">
            <p>Login</p>
        </div>
    </div>
    <div class="titulo">
        <h2>Editar ong</h2>
    </div>

        <form action="ong-editada" method="post" class="forms-editar-proposta">
          
          
                    <div class="conteudo-editar" id="conteudo-editar-ong">
                        
                       <input type="text" id="editarNomeONG" name="nome" placeholder="Editar nome"required class="padrao-input">
                        <input type="email" id="editarEmailONG" name="email" placeholder="Editar email"required class="padrao-input">
                        
                       <input type="tel" id="editarCelularONG" name="celular" placeholder="Editar celular"required class="padrao-input">
                        <input type="password" id="editarSenhaONG" name="senha" placeholder="Nova Senha"required class="padrao-input">
                     <input type="text" id="editarLogradouroONG" name="logradouro" placeholder="Editar Logadouro"required class="padrao-input">
                      <input type="text" id="editarBairroONG" name="bairro" placeholder="Editar Bairro"required class="padrao-input">
                      <input type="text" id="editarCidadeONG" name="cidade" placeholder="Editar cidade"required class="padrao-input">
                      <input type="number" id="editarNúmeroONG" name="numero" placeholder="Número" required class="padrao-input">
                       <input type="text" id="editarCEPONG" name="cep" placeholder=" CEP " required class="padrao-input">
                       <input type="text" id="editarCNPJONG" name="cnpj" placeholder=" CNPJ " required class="padrao-input">
                   <input type="text" id="editarCOMPLEMENTO" name="complemento" placeholder="Complemento" required class="padrao-input">
                        <input type="text" id="editarUF" name="uf" placeholder="UF" required class="padrao-input">
                    </div>
                              
                                
                       
                                
                                <div class="botoes-editar">
                                    <div><input type="submit" value="Salvar tudo" class="padrao-submit"></input></div>
                                </div>
                
    </form>

</body>

</html>