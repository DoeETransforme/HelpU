<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Helpu</title>
	<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>
	<script><%@include file="/resources/js/Script.js"%></script>
	<style type="text/css"> <%@include file="../css/menu-topo.css"%></style>
	<style type="text/css"> <%@include file="/resources/css/perfil-doador.css"%></style> 

</head>
<body>
 
	<%@ include file="../cabecalhos/menu.jsp" %>

 
	<div class="perfil-doador">	
		<div class="informacoes-doador">
			<div class="imagem-doador">
				<img alt="foto do doador" id="foto" src="<c:out value='${doador.fotoUsuario.urlFoto()}'/>">

			</div>
				
				
				<div class="nome-doador">
					<h1><c:out value="${doador.nome}" /></h1>
					<p>Quantidade de conquistas: <c:out value="${qntdConquistas}" /></p>
				</div>
				
		</div>
		
		<div class="linha"></div>
		
		<div class="main-doador">
			<div class="botoes-doador">
				<a class="botao" href="<%=request.getContextPath()%>/historico-doacoes">Histórico de Doações</a>
				<a class="botao" href="<%=request.getContextPath()%>/historico-conquistas">Histórico de conquistas</a>
				<a class="botao-editar-perfil" href="<%=request.getContextPath()%>/editar-perfil-doador?id=<c:out value='${doador.id}'/>">
					<%@include file="../imagens/icone-editar-perfil.jsp" %>
					Editar Perfil
			   </a>
			</div>
			
			
			
			<div class="ultimas-doacoes">
				<div class="titulo">
					<h1>Últimas Doações</h1>
				</div>
				<div class="posicao-cards">
				<c:forEach var="proposta" items="${propostas}">		
						<div class="card-doacoes-doador">
						
								<a class="titulo-card" href="<%=request.getContextPath()%>/perfil-ong?id=<c:out value='${proposta.pedidoDoacao.ong.id}'/>">Doação para <c:out value="${proposta.pedidoDoacao.ong.nome}" /> teste</a>	
														 
							 <p>
								<c:out value="${proposta.pedidoDoacao.descricao}" />							
							 </p>
							 
							 <span>Feito em: <c:out value="${proposta.dataCriacao}" /></span>
							 
							<a class="botao" id="botao-descricao" href="<%=request.getContextPath()%>/descricao-proposta?id=<c:out value='${proposta.id}'/>">Descrição</a>	
						</div>			
						
				</c:forEach>	
				</div>
				</div>
			</div>

		</div>


 
</body>
</html>
