<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width= , initial-scale=1.0">
    <title>HelpU</title>
</head>

<body>
    <header>
        <div>
            <picture>
                <a href="Pagina_Inicial.html"><img src="caminho/para/sua/imagem.jpg" alt="Logo"></a>
            </picture>
            <input type="search" placeholder="Pesquisar">
        </div>
        <nav>
            <a href="Perfil_Pessoa.html" .html">Minha conta</a>
            <a href="Cadastro.html">Cadastro</a>
        </nav>

    </header>

    <main>

        <div>
            <h1>Você realmente deseja desativar esse perfil?</h1>
            <div>
                <picture><img src="imagem.com" alt="imagem do usuario"></picture>
                <div>
                    <a href="Perfil_Pessoa.html"><button>Voltar</button></a>
                    <form action="ConfirmaçãoExclusão_Pf.html" method="post">
                        <input type="submit" name="DesativarConta" id="DesativarContaPF" value="sim">
                    </form>
                </div>
            </div>
        </div>
    </main>
</body>

</html>