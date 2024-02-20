<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Helpu</title>
    <link rel="stylesheet" href="../css/estilo.css">
    <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style> 
    <script><%@include file="/resources/js/Script.js"%></script>
</head>
<body>

    <div class="menu-hamburguer" id="menu-hamburguer">
	
		<div class="hamburguer" onclick="toggleMenu()">☰</div>
	</div>
	
	<div class="menu-lateral" id="menu-lateral">
		<%@ include file="../cabecalhos/menu.jsp" %>
	</div>

        <div class="titulo">
            <h1>Editar Perfil</h1>
        </div>

        <form action="doador-editado" method="post">
          
                <div class="editar-dados">
                    <label for="editarNome">Editar Nome:</label>
                    <input type="text" id="editarNomePF" name="nome" placeholder="Nome Atual do Usuário">
                    <label for="editarEmail">Editar Email:</label>
                    <input type="email" id="editarEmailPF" name="email" placeholder="EmailAtual@exemplo.com">
                    <label for="editarCelular">Editar Número de Celular:</label>
                    <input type="tel" id="editarCelularPF" name="celular" placeholder="Número Atual do Usuário">
                    <label for="editarCpf" >Editar Cpf:</label>
                    <input type="text"  name="cpf" placeholder="Digite o Cpf" >
                    <label for="editarDataNascimento">Editar Data Nascimento:</label>
                    <input type="date"  name="data-nascimento" >
                    <label for="editarSenha">Editar Senha:</label>
                    <input type="password" id="editarSenhaPF" name="senha" placeholder="Nova Senha">
                </div>
                <div class="submit-editar-dados"><input type="submit" value="Salvar edições "></input></div>
        </form>

</body>
</html>
