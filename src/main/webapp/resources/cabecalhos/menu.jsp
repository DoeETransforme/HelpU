<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<style type="text/css"> <%@include file="/resources/css/estilo.css"%></style>

	<c:choose>
	<c:when test="${tipoUsuario == 1}">
		<nav>
			<header class="template-grid" id="cabecalho">
						<div class="menu-hamburguer" id="menu-hamburguer">
						
							<div class="hamburguer" onclick="toggleMenu()">☰</div>
						
							<div class="menu-lateral" id="menu-lateral">
										<%@ include file="../cabecalhos/barra-lateral.jsp" %>
										
							</div>		
						</div>
					
						<input type="search">
					
						
					
			</header>
		</nav>
	</c:when>
	<c:when test="${tipoUsuario == 2}">
		<nav>
			<header class="template-grid" id="cabecalho">
				<div class="menu-hamburguer" id="menu-hamburguer">
				
					<div class="hamburguer" onclick="toggleMenu()">☰</div>
				
	
					<div class="menu-lateral" id="menu-lateral">
								<%@ include file="../cabecalhos/barra-lateral.jsp" %>
								
					</div>		
				</div>
			</header>
		</nav>
	</c:when>
		
		
	</c:choose>
