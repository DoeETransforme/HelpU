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

        <form action="Perfil_Pessoa.html" method="post">
            <div>
                <label for="editarNome">Editar Nome:</label>
                <input type="text" id="editarNomePF" name="editarNomePF" placeholder="Nome Atual do Usuário">
            </div>
            <div>
                <label for="editarEmail">Editar Email:</label>
                <input type="email" id="editarEmailPF" name="editarEmailPF" placeholder="EmailAtual@exemplo.com">
            </div>
            <div>
                <label for="editarCelular">Editar Número de Celular:</label>
                <input type="tel" id="editarCelularPF" name="editarCelularPF" placeholder="Número Atual do Usuário">
            </div>
            <div>
                <label for="editarSenha">Editar Senha:</label>
                <input type="password" id="editarSenhaPF" name="editarSenhaPF" placeholder="Nova Senha">
            </div>
                </div>

                <input type="submit" value="Salvar edições "></input>
        </form>

</body>
</html>
