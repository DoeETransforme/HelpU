<div>
	<c:choose>
	<c:when test="${tipoUsuario == 1}">
			<header>
				<nav>
					<ul>
						<li class="dropdown"><a href="#" class="dropbtn">Doador</a>
							<div class="dropdown-content">
								<a href="<%=request.getContextPath()%>/perfil-doador">Meu
									Perfil</a> <a
									href="<%=request.getContextPath()%>/editar-perfil-doador">Editar
									Conta</a> <a href="<%=request.getContextPath()%>/desativar-conta">Desativar
									Conta</a> <a href="<%=request.getContextPath()%>/logout">Sair</a>

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
						<li class="dropdown"><a href="#" class="dropbtn">Ong</a>
							<div class="dropdown-content">
								<a href="<%=request.getContextPath()%>/perfil-ong">Meu
									Perfil</a> <a
									href="<%=request.getContextPath()%>/editar-perfil-ong">Editar
									Conta</a> <a href="<%=request.getContextPath()%>/desativar-conta">Sair</a>
								<a href="<%=request.getContextPath()%>/logout">Sair</a>

							</div>
						</li>
					</ul>
				</nav>
			</header>
		</c:when>

		
	</c:choose>
</div>