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

    <%@ include file="menu.jsp"%>

    </header>

    <main>

        <div>
            <h1>Você realmente deseja desativar esse perfil?</h1>
            <div>
                <picture><img src="imagem.com" alt="imagem do usuario"></picture>
                <div>
                    <a href="Perfil_Pessoa.html"><button>Voltar</button></a>
                    <form action="confirmar-exclusao" method="post">
                        <input type="submit" name="DesativarConta" id="DesativarContaPF" value="sim">
                    </form>
                </div>
            </div>
        </div>
    </main>
</body>

</html>