<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div>
        <div class="titulo">
            <h1>Cadastro ONG</h1>
            <p>informações pessoais</p>
        </div>
        <div class="header"> 
            <p>Login</p>
            <img src="../imagens/logo final.png" alt="imagem da ong">
        </div>
        <form action="inserir-ong" method="post" class="forms">
            <div>
                <div>
                   
                    <input type="text" id="NomeCompletoOng" name="nome-ong" placeholder="Nome da ONG" required class="padrao-input">
                    <span id="erroNomeCompleto"></span>
                </div>
                <div>
                 
                    <input type="text" id="CPFOuCNPJ_Ong" name="cpf-cnpj-ong" placeholder="CPF ou CNPJ da ONG" required class="padrao-input">
                    <span id="erroCPFOuCNPJ"></span>
                </div>
                <div>
                    
                    <input type="text" id="TelefoneOng" name="tefelone-ong" placeholder="Telefone da ONG" required class="padrao-input">
                    <span id="erroTelefone"></span>
                </div>
                <div>
                 
                    <input type="email" id="EmailDaOng" name="email-ong" placeholder="Email da ONG" required class="padrao-input">
                    <span id="erroEmail"></span>
                </div>
                <div>
                
                    <input type="email" id="ConfirmarEmailOng" name="ConfirmarEmailOng" placeholder="Confirmar Email da ONG" required class="padrao-input">
                    <span id="erroConfirmarEmail"></span>
                </div>
                <div>
                 
                    <input type="password" id="SenhaOng" name="senha-ong" placeholder="Senha da ONG" required class="padrao-input">
                    <span id="erroSenha"></span>
                </div>
                <div>
                 
                    <input type="password" id="ConfirmarSenhaOng" name="ConfirmarSenhaOng" placeholder="Confirmar Senha" required class="padrao-input">
                    <span id="erroConfirmarSenha"></span>
                </div>
            </div>

            <input type="submit" value="Continuar >" class="padrao-submit">
        </form>

        
    </div>
</body>
</html>