<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Helpu</title>
</head>

<body>

    <%@ include file="menu.jsp"%>

    <div>
        <img src="caminho_da_imagem_de_perfil" alt="Imagem de Perfil">

        <h1>Editar Perfil</h1>

        <form action="ong-editada" method="post">
            <div>
                <label for="editarNome">Editar Nome:</label>
                <input type="text" id="editarNomeONG" name="nome" placeholder="Editar nome"required>
            </div>
            <div>
                <label for="editarEmail">Editar Email:</label>
                <input type="email" id="editarEmailONG" name="email" placeholder="Editar email"required>
            </div>
            <div>
                <label for="editarCelular">Editar Número de Celular:</label>
                <input type="tel" id="editarCelularONG" name="celular" placeholder="Editar celular"required>
            </div>
            <div>
                <label for="editarSenha">Editar Senha:</label>
                <input type="password" id="editarSenhaONG" name="senha" placeholder="Nova Senha"required>
            </div>
            <div>
                <label for="editarLogadouro">Editar logadouro:</label>
                <input type="text" id="editarLogradouroONG" name="logradouro" placeholder="Editar Logadouro"required>
            </div>
            <div>
                <label for="editarBairro">Editar Bairro:</label>
                <input type="text" id="editarBairroONG" name="bairro" placeholder="Editar Bairro"required>
            </div>
            <div>
                <label for="editarCidade">Editar cidade:</label>
                <input type="text" id="editarCidadeONG" name="cidade" placeholder="Editar cidade"required>
            </div>
            <div>
                <label for="editarNúmero">Editar Número</label>
                <input type="number" id="editarNúmeroONG" name="numero" placeholder="Número" required>
            </div>
            <div>
                <label for="editarCEP">Editar CEP</label>
                <input type="text" id="editarCEPONG" name="cep" placeholder=" CEP " required>
            </div>
            <div>
                <label for="editarCNPJ">Editar CNPJ</label>
                <input type="text" id="editarCNPJONG" name="cnpj" placeholder=" CNPJ " required>
            </div>
            <div>
                <label for="editarComplemento">Editar Complemento</label>
                <input type="text" id="editarCOMPLEMENTO" name="complemento" placeholder="COMPLEMENTO" required>
            </div>
            <div>
                <label for="editarUF">Editar CNPJ</label>
                <input type="text" id="editarUF" name="uf" placeholder="UF" required>
            </div>
            
    </div>
            
            <input type="submit" value="salvar edições"></input>
            
    </form>

</body>

</html>