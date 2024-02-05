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

        <img src="caminho_da_imagem_de_perfil" alt="Imagem de Perfil">

        <h1>Editar Perfil</h1>

        <form action="doador-editado" method="post">
            <div>
                <label for="editarNome">Editar Nome:</label>
                <input type="text" id="editarNomePF" name="nome" placeholder="Nome Atual do Usuário">
            </div>
            <div>
                <label for="editarEmail">Editar Email:</label>
                <input type="email" id="editarEmailPF" name="email" placeholder="EmailAtual@exemplo.com">
            </div>
            <div>
                <label for="editarCelular">Editar Número de Celular:</label>
                <input type="tel" id="editarCelularPF" name="celular" placeholder="Número Atual do Usuário">
            </div>
             <div>
                <label for="editarCpf">Editar Cpf:</label>
                <input type="text"  name="cpf" >
            </div>
             <div>
                <label for="editarDataNascimento">Editar Data Nascimento:</label>
                <input type="date"  name="data-nascimento" placeholder="Digite o Cpf">
            </div>
            <div>
                <label for="editarSenha">Editar Senha:</label>
                <input type="password" id="editarSenhaPF" name="senha" placeholder="Nova Senha">
            </div>
 

                <input type="submit" value="Salvar edições "></input>
        </form>

</body>
</html>
