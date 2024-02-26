<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Helpu</title>
		<link rel="icon" type="image/x-icon" href="../imagens/Logo-projeto-ico.ico">
        <style type="text/css"> <%@include file="/resources/css/estilo.css"%></style> 
		<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
		<style type="text/css"> <%@include file="../css/login.css"%></style> 
		<script><%@include file="/resources/js/Script.js"%></script>
		
    </head>
    <body>

     
        <div class="ajuste-alinhamento">
	        <div class="corpo-login">            
	                <svg class="imagem-login">
	                    <%@ include file="/resources/imagens/imagem-login.jsp" %>
					</svg>	
				
				
	            <div class="tamanho">
	                <form action="confirmar-login" method="post" class="">
	                    <div class="position">
	                        <div class="forms-login">
	                            <h1 class="titulo-login">Login</h1>
	                            <label for="login-email">E-mail</label>
	                            <input type="email" id="login-email" name="email" required class="padrao-login">
	                            <label for="login-senha">Senha</label>
	                            <input type="password" id="login-senha" name="senha" required class="padrao-login item3-login">
	                            <a class="esqueceu-senha" href="<%=request.getContextPath()%>/esqueci-minha-senha"><span >Esqueceu a senha?</span></a>
	                            
	                            <input type="submit" value="Confirmar" class="padrao-submit-login">
	                        </div>
	                    </div>
	                </form>
	                <div class="esqueceu-senha-login">
	                    <span>Não tem uma conta?</span> <a id="link-cadastrar" href="<%=request.getContextPath()%>/mostrar-cadastro">Cadastra-se Agora!</a>
	                       
	                </div>
	                
	               
	            </div>
			</div>
		</div>
    </body>

    </html>