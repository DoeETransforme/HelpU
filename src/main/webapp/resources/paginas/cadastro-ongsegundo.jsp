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
    <header>

    </header>
    <main>
        <h1>Endereço</h1>
        <div>
            <form action="inserir-endereco-ong" method="post">
                <div>
                    <div>
                        <label for="Cidade">Cidade</label>
                        <input type="text" id="Cidade_Ong" name="cidade-ong" placeholder="Cidade" required>
                    </div>
                    <div>
                        <label for="CEP">CEP</label>
                        <input type="text" id="CEP_ONG" name="cep-ong" placeholder="CEP" required>
                    </div>
                    <div>
                        <label for="logadouro">Logradouro</label>
                        <input type="text" id="logadouro_Ong" name="logradouro-ong" placeholder="Logradouro" required>
                    </div>
                    <div>
                        <label for="Complemento">Complemento</label>
                        <input type="text" id="Complemnto_Ong" name="complemento-ong" placeholder="Complemento" required>
                    </div>
                    <div>
                        <label for="UF">UF</label>
                        <input type="text" id="UF_ong" name="uf-ong" placeholder="unidade Federativa" required>
                    </div>
                    <div>
                        <label for="bairro">Bairro</label>
                        <input type="text" id="Bairro_Ong" name="bairro-ong" placeholder="Bairro" required>
                    </div>
                    <div>
                        <label for="Número">Número</label>
                        <input type="number" id="Número_Ong" name="numero-ong" placeholder="Número" required>
                    </div>
                    <input type="submit" value="Pronto ! "></input>
                </div>
            </form>

        </div>
    </main>
</body>

</html>