<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
    <!-- <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style> -->
    <link rel="stylesheet" href="../css/estilo.css">
    <script><%@include file="/resources/js/Script.js"%></script>
</head>
<body>
    <div>
        <div class="titulo">
            <h3>Cadastro ONG</h3>
            <p>informações pessoais</p>
        </div>
        <div class="header"> 
            <p>Login</p>
            <img src="../imagens/logo-final.png" alt="imagem da ong">
        </div>
        <form action="inserir-ong" method="post" class="forms">
           
               
                   
                    <div >
                        <input type="text" id="NomeCompletoOng" name="nome-ong" placeholder="Nome da ONG" required class="padrao-input">
                      
                        <input type="text" id="CPFOuCNPJ_Ong" name="cpf-cnpj-ong" placeholder="CPF ou CNPJ da ONG" required class="padrao-input">
                    
                        
                        <input type="text" id="TelefoneOng" name="tefelone-ong" placeholder="Telefone da ONG" required class="padrao-input">
                    
                        <input type="email" id="EmailDaOng" name="email-ong" placeholder="Email da ONG" required class="padrao-input">
                      
                        <input type="email" id="ConfirmarEmailOng" name="ConfirmarEmailOng" placeholder="Confirmar Email da ONG" required class="padrao-input">
                       
                        <input type="password" id="SenhaOng" name="senha-ong" placeholder="Senha da ONG" required class="padrao-input">
                     
                        <input type="password" id="ConfirmarSenhaOng" name="ConfirmarSenhaOng" placeholder="Confirmar Senha" required class="padrao-input">
                        
                    </div>
                    
                
                <input type="submit" value="Continuar >" class="padrao-submit">
        </form>

        
    </div>
</body>
</html>