<div>
	<c:choose>
	<c:when test="${tipoUsuario == 1}">
			<header>
				<nav>
					<ul>
						<li class="dropdown">
							<p href="#" class="dropbtn">Doador</p>
							<div class="dropdown-content">
								<a href="<%=request.getContextPath()%>/perfil-doador">Meu
									Perfil</a> <a
									href="<%=request.getContextPath()%>/editar-perfil-doador">Editar
									Conta</a> <a href="<%=request.getContextPath()%>/desativar-conta">Desativar
									Conta</a> 
									<a href="<%=request.getContextPath()%>/cadastro-proposta">Cadastro Proposta</a> 
									<a href="<%=request.getContextPath()%>/editar-proposta">Editar Proposta</a> 
									<a href="<%=request.getContextPath()%>/historico-doacoes">Hist�rico de Doa��es</a>
									<a href="<%=request.getContextPath()%>/propostas-pendentes">Propostas Pendentes</a>
									<a href="<%=request.getContextPath()%>/logout">Sair</a>

							</div>
						</li>
					</ul>
				</nav>
			</header>

		</c:when>
		<c:when test="${tipoUsuario == 2}">
			<header>
				<nav>
					<ul>
						<li class="dropdown"><p href="#" class="dropbtn">Ong</p>
							<div class="dropdown-content">
								<a href="<%=request.getContextPath()%>/perfil-ong">Meu
									Perfil</a> <a
									href="<%=request.getContextPath()%>/editar-perfil-ong">Editar
									Conta</a> <a href="<%=request.getContextPath()%>/desativar-conta">Desativar Conta</a>
									<a href="<%=request.getContextPath()%>/avaliar-proposta">Avaliar Proposta</a> 
									<a href="<%=request.getContextPath()%>/cadastro-pedido">Cadastro Pedido</a> 
									<a href="<%=request.getContextPath()%>/editar-pedido">Editar Pedido</a> 
									<a href="<%=request.getContextPath()%>/explorar-pedidos">Explorar Pedidos</a> 
									<a href="<%=request.getContextPath()%>/historico-pedidos">Hist�rico Pedidos</a>
									<a href="<%=request.getContextPath()%>/propostas-analise">Propostas em Analise</a>
									<a href="<%=request.getContextPath()%>/logout">Sair</a>

							</div>
						</li>
					</ul>
				</nav>
			</header>
		</c:when>

		
	</c:choose>
</div>