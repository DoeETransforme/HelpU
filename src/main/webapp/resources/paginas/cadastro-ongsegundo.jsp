<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelpU</title>
   <!--<style type="text/css"><%@include file="/resources/css/estilo.css"%></style>-->
   <link rel="stylesheet" href="../css/estilo.css">
</head>

<body>
    <header>

    </header>
    <main>
        <div class="titulo">
            <h1>Cadastro ONG</h1>
            <p>Endereço</p>
        </div>
        <div class="header"> 
            <p>Login</p>
            <img src="../imagens/logo final.png" alt="imagem da ong">
        </div>
        <div>
            <form action="inserir-endereco-ong" method="post" class="forms">
                <div>
                    <div>
                        
                        <input type="text" id="Cidade_Ong" name="cidade-ong" placeholder="Cidade" required class="padrao-input">
                    </div>
                    <div>
                     
                        <input type="text" id="CEP_ONG" name="cep-ong" placeholder="CEP" required class="padrao-input">
                    </div>
                    <div>
                    
                        <input type="text" id="logadouro_Ong" name="logradouro-ong" placeholder="Logradouro" required class="padrao-input">
                    </div>
                    <div>
                     
                        <input type="text" id="Complemento_Ong" name="complemento-ong" placeholder="Complemento" required class="padrao-input">
                    </div>
                    <div>
                      
                        <input type="text" id="UF_ong" name="uf-ong" placeholder="unidade Federativa" required class="padrao-input">
                    </div>
                    <div>
                      
                        <input type="text" id="Bairro_Ong" name="bairro-ong" placeholder="Bairro" required class="padrao-input">
                    </div>
                    <div>
                    
                        <input type="number" id="Número_Ong" name="numero-ong" placeholder="Número" required class="padrao-input">
                    </div>
                </div>
                <input type="submit" value="Pronto ! " class="padrao-submit"></input>
            </form>

        </div>
    </main>
</body>

</html>