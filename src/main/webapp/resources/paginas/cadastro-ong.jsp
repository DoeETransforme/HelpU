<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
</head>
<body>
    <div>
        <form action="inserir-ong" method="post" >
            <div>
                <div>
                    <label for="NomeCompletoOng">Nome completo</label>
                    <input type="text" id="NomeCompletoOng" name="nome-ong" placeholder="Nome da ONG" required>
                    <span id="erroNomeCompleto"></span>
                </div>
                <div>
                    <label for="CPFOuCNPJ">CPF/CNPJ</label>
                    <input type="text" id="CPFOuCNPJ_Ong" name="cpf-cnpj-ong" placeholder="CPF ou CNPJ da ONG" required>
                    <span id="erroCPFOuCNPJ"></span>
                </div>
                <div>
                    <label for="TelefoneOng">Telefone</label>
                    <input type="text" id="TelefoneOng" name="tefelone-ong" placeholder="Telefone da ONG" required>
                    <span id="erroTelefone"></span>
                </div>
                <div>
                    <label for="EmailDaOng">Email</label>
                    <input type="email" id="EmailDaOng" name="email-ong" placeholder="Email da ONG" required>
                    <span id="erroEmail"></span>
                </div>
                <div>
                    <label for="ConfirmarEmail">Confirmar Email</label>
                    <input type="email" id="ConfirmarEmailOng" name="ConfirmarEmailOng" placeholder="Confirmar Email da ONG" required>
                    <span id="erroConfirmarEmail"></span>
                </div>
                <div>
                    <label for="SenhaOng">Senha</label>
                    <input type="password" id="SenhaOng" name="senha-ong" placeholder="Senha da ONG" required>
                    <span id="erroSenha"></span>
                </div>
                <div>
                    <label for="ConfirmarSenha">Confirmar Senha</label>
                    <input type="password" id="ConfirmarSenhaOng" name="ConfirmarSenhaOng" placeholder="Confirmar Senha" required>
                    <span id="erroConfirmarSenha"></span>
                </div>
            </div>

            <input type="submit" value="Continuar >">
        </form>

        
    </div>
</body>
</html>