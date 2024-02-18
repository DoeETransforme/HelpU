<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
</head>
<body>
	<section>
		<div>
			<img src="imagem.com" alt="foto HelpU">
		</div>
	</section>
	<section>
		<div>
			<img src="imagem.com" alt="foto voltar login">
		</div>
	</section>

	<a href="<%=request.getContextPath()%>/login"> Voltar para o Login</a>

	<h1>Esqueceu sua senha?</h1>
	<p>Insira seu e-mail de cadastro e mandaremos um código de
		confirmação com 6 digitos para você!</p>
	<input class="padrao_input" id="emailReconfirmar" placeholder="Insira o Email" required />
	<p>Se ocorrer de o código não chegar, reenvie a solicitação.</p>

	<button type="submit" class="padrao-input"  id="invalidar-proposta">Enviar Email</button>
	
</body>

</html>