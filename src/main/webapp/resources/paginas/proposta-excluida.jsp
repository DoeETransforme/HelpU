<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpU</title>
<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>

<link rel="stylesheet" href="../css/estilo.css">
</head>
<body>

	<%@ include file="../cabecalhos/menu.jsp"%>
 
	<svg id="imagem-correto-proposta"  viewBox="0 0 300 300" fill="none" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
		<rect width="300" height="300" fill="url(#pattern0)"/>
		<defs>
		<pattern id="pattern0" patternContentUnits="objectBoundingBox" width="1" height="1">
		<use xlink:href="#image0_1520_959" transform="scale(0.01)"/>
		</pattern>
		<image id="image0_1520_959" width="100" height="100" xlink:href="data:image/png;base64,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"/>
		</defs>
		</svg>
	<div class="titulo">
		<p id="proposta-excluida-paragrafo">Proposta excluida com sucesso!</p>
	</div>
	<div class="voltar-proposta-aceita"><a href="propostas-pendentes" class="Voltar"> Voltar</a></div>
 
 
 
</body>
</html>