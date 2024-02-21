<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
					
					  <div class="input-search">
                                              <input type="search" placeholder="   Pesquisar...">
                                               </div>		
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
	<c:when test="${tipoUsuario == 3}">
		<nav>
			<header>
									
			</header>
		</nav>
	</c:when>
		
		
	</c:choose>
