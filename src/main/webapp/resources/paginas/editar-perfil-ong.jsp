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

    <header>
        <div>
            <picture>
                <a href="Pagina_Inicial.html"><img src="logo-imagem.com" alt="Logo"></a>
            </picture>
            <input type="search" placeholder="Pesquisar">
        </div>
        <nav>
            <a href="./login.jsp">Login</a>
            <a href="./Cadastro.jsp">Cadastro</a>
        </nav>
    </header>

    <div>
        <img src="caminho_da_imagem_de_perfil" alt="Imagem de Perfil">

        <h1>Editar Perfil</h1>

        <form action="Ong_perfil.html" method="post">
            <div>
                <label for="editarNome">Editar Nome:</label>
                <input type="text" id="editarNomeONG" name="editarNome" placeholder="Editar nome"required>
            </div>
            <div>
                <label for="editarEmail">Editar Email:</label>
                <input type="email" id="editarEmailONG" name="editarEmail" placeholder="Editar email"required>
            </div>
            <div>
                <label for="editarCelular">Editar Número de Celular:</label>
                <input type="tel" id="editarCelularONG" name="editarCelular" placeholder="Editar celular"required>
            </div>
            <div>
                <label for="editarSenha">Editar Senha:</label>
                <input type="password" id="editarSenhaONG" name="editarSenha" placeholder="Nova Senha"required>
            </div>
            <div>
                <label for="editarLogadouro">Editar logadouro:</label>
                <input type="text" id="editarLogadouroONG" name="editarLogadouroONG" placeholder="Editar Logadouro"required>
            </div>
            <div>
                <label for="editarBairro">Editar Bairro:</label>
                <input type="text" id="editarBairroONG" name="editarBairroONG" placeholder="Editar Bairro"required>
            </div>
            <div>
                <label for="editarCidade">Editar cidade:</label>
                <input type="text" id="editarCidadeONG" name="editarCidadeONG" placeholder="Editar cidade"required>
            </div>
            <div>
                <label for="editarNúmero">Editar Número</label>
                <input type="number" id="editarNúmeroONG" name="editarNúmeroONG" placeholder="Número" required>
            </div>
            <div>
                <label for="editarCEP">Editar CEP</label>
                <input type="text" id="editarCEPONG" name="editarCEPONG" placeholder=" CEP " required>
            </div>
            <div>
                <label for="editarCNPJ">Editar CNPJ</label>
                <input type="text" id="editarCNPJONG" name="editarCNPJONG" placeholder=" CNPJ " required>
            </div>
            <input type="submit" value="salvar edições"></input>
            
    </div>
    </form>

</body>

</html>