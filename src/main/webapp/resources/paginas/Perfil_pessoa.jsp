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
            <a href="Cadastro.html">Conquistas</a>
            <a href="Perfil_Pessoa.html">Minha conta</a>
        </nav>
    </header>

    <img src="link_da_imagem" alt="Imagem de Perfil">

    <h2><span id="doacoesRealizadas">0</span> doações realizadas</h2>
    <h2><span id="doacoesFeitas">0</span> doações feitas</h2>

    <h1>Nome do Usuário</h1>

    <button onclick="exibirHistorico()">Histórico de Doações</button>
    <button onclick="exibirConquistas()">Exibir Conquistas</button>

    <div class="achievements">
        <img src="conquista1.jpg" alt="Conquista 1">
        <p>Conquista Realizada 1</p>

        <img src="conquista2.jpg" alt="Conquista 2">
        <p>Conquista Realizada 2</p>

        <img src="conquista3.jpg" alt="Conquista 3">
        <p>Conquista Realizada 3</p>
    </div>

    
</body>
</html>