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
    <div>
        <header>
            <div>
                <picture>
                    <a href="Pagina_Inicial.html"><img src="logo-imagem.com" alt="Logo"></a>
                </picture>
                <input type="text" placeholder="Pesquisar">
            </div>
            <nav>
                <a href="./login.jsp">Login</a>
            <a href="./Cadastro.jsp">Cadastro</a>
        </header>

        <main>
            <section>
                <div>
                    <picture>
                        <img src="imagem.com" alt="capa">
                    </picture>
                    <img src="imagem.com" alt="foto de perfil da ong">
                </div>
            </section>
            <section>
                <div>
                    <h1>Contatos</h1>
                    <p><strong>Telefone:</strong> ${ong.cnpj}</p>

                    <p><strong>Email:</strong> ${ong.enderecos </p>

                </div>
                <button>Histórico de pedidos</button>
            </section>

            <section>
                <h1>Atualizações da ONG</h1>
                <div>
                    <div>
                        <img src="imagem.com" alt="ajudando uma criança">
                        <h2><a href="#">Cantilho inclusao atualizou uma campanha</a></h2>
                        <p>You say potato, I say starchy carbs. A vida é uma sucessão de sucessivos que sucedem sucessivamente sem ce. <a href="#">Leia mais</a></p>
                    </div>
                    <div>
                        <img src="imagem.com" alt="doação de comida">
                        <h2><a href="#">Cantinho inclusao finalizou uma campanha</a></h2>
                        <p>You say potato, I say starchy carbs. A vida é uma sucessão de sucessivos que sucedem sucessivamente sem ce. <a href="#">Leia mais</a></p>
                    </div>
                </div>
            </section>
        </main>
    </div>
</body>
</html>