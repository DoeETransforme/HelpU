package br.senac.helpu.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.helpu.modelo.dao.alimento.AlimentoDAO;
import br.senac.helpu.modelo.dao.alimento.AlimentoDAOImpl;
import br.senac.helpu.modelo.dao.conquista.ConquistaDAO;
import br.senac.helpu.modelo.dao.conquista.ConquistaDAOImpl;
import br.senac.helpu.modelo.dao.contato.ContatoDAO;
import br.senac.helpu.modelo.dao.contato.ContatoDAOImpl;
import br.senac.helpu.modelo.dao.doador.DoadorDAO;
import br.senac.helpu.modelo.dao.doador.DoadorDAOImpl;
import br.senac.helpu.modelo.dao.endereco.EnderecoDAO;
import br.senac.helpu.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.helpu.modelo.dao.item.ItemDAO;
import br.senac.helpu.modelo.dao.item.ItemDAOImpl;
import br.senac.helpu.modelo.dao.ong.OngDAO;
import br.senac.helpu.modelo.dao.ong.OngDAOImpl;
import br.senac.helpu.modelo.dao.pedidodoacao.PedidoDoacaoDAO;
import br.senac.helpu.modelo.dao.pedidodoacao.PedidoDoacaoDAOImpl;
import br.senac.helpu.modelo.dao.propostadoacao.PropostaDoacaoDAO;
import br.senac.helpu.modelo.dao.propostadoacao.PropostaDoacaoDAOImpl;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAO;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.helpu.modelo.entidade.alimento.Alimento;
import br.senac.helpu.modelo.entidade.conquista.Conquista;
import br.senac.helpu.modelo.entidade.contato.Contato;
import br.senac.helpu.modelo.entidade.doador.Doador;
import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.entidade.item.Item;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;
import br.senac.helpu.modelo.entidade.usuario.Usuario;
import br.senac.helpu.modelo.enumeracao.pedido.StatusPedido;
import br.senac.helpu.modelo.enumeracao.proposta.StatusProposta;

@WebServlet("/")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	private ContatoDAO contatoDAO;
	private DoadorDAO doadorDAO;
	private EnderecoDAO enderecoDAO;
	private PedidoDoacaoDAO pedidoDoacaoDAO;
	private PropostaDoacaoDAO propostaDoacaoDAO;
	private ItemDAO itemDAO;
	private AlimentoDAO alimentoDAO;
	private OngDAO ongDAO;
	private ConquistaDAO conquistaDAO;

	public void init() {
		usuarioDAO = new UsuarioDAOImpl();
		contatoDAO = new ContatoDAOImpl();
		doadorDAO = new DoadorDAOImpl();
		enderecoDAO = new EnderecoDAOImpl();
		pedidoDoacaoDAO = new PedidoDoacaoDAOImpl();
		propostaDoacaoDAO = new PropostaDoacaoDAOImpl();
		itemDAO = new ItemDAOImpl();
		alimentoDAO = new AlimentoDAOImpl();
		ongDAO = new OngDAOImpl();
		conquistaDAO = new ConquistaDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		
		if (sessao.getAttribute("usuario") instanceof Doador) {
			String tipoUsuario = "1";
			request.setAttribute("tipoUsuario", tipoUsuario);
		}

		else if (sessao.getAttribute("usuario") instanceof Ong) {
			String tipoUsuario = "2";
			request.setAttribute("tipoUsuario", tipoUsuario);
		}

		String action = request.getServletPath();

		try {
			switch (action) {
			case "/home":
				mostrarIndex(request, response);
				break;

			case "/login":
				mostrarLogin(request, response);
				break;

			case "/confirmar-login":
				confirmarLogin(request, response);
				break;
			case "/validar-proposta":
				validarProposta(request, response);
				
			case "/invalidar-proposta":
				invalidarProposta(request, response);

			case "/perfil-doador":
				mostrarPerfilDoador(request, response);
				break;

			case "/perfil-ong":
				mostrarPerfilOng(request, response);
				break;

			case "/avaliar-proposta":
				mostrarAvaliarProposta(request, response);
				break;

			case "/confirmar-exclusao":
				mostrarConfirmarExclusao(request, response);
				break;

			case "/descricao-pedido":
				mostrarDescricaoPedido(request, response);
				break;

			case "/editar-pedido":
				mostrarEditarPedido(request, response);
				break;

			case "/editar-perfil-ong":
				mostrarEditarPerfilOng(request, response);
				break;

			case "/editar-perfil-doador":
				mostrarEditarPerfilDoador(request, response);
				break;

			case "/desativar-conta":
				mostrarExcluirContaUsuario(request, response);
				break;

			case "/historico-pedidos":
				mostrarHistoricoPedidos(request, response);
				break;

			case "/historico-doacoes":
				mostrarHistoricoDoacoes(request, response);
				break;

			case "/propostas-analise":
				mostrarPropostasAnalise(request, response);
				break;

			case "/propostas-realizadas":
				mostrarPropostasRealizadas(request, response);
				break;

			case "/recuperar-senha":
				mostrarRecuperarSenha(request, response);
				break;

			case "/redefinir-senha":
				mostrarRedefinirSenha(request, response);
				break;

			case "/termos":
				mostrarTermos(request, response);
				break;

			case "/cadastro-doador":
				mostrarCadastroDoador(request, response);
				break;
			case "/cadastro-ong":
				mostrarCadastroOng(request, response);
				break;

			case "/cadastro-proposta":
				mostrarCadastroProposta(request, response);
				break;

			case "/cadastro-pedido":
				mostrarCadastroPedido(request, response);
				break;

			case "/cadastro-alimento":
				mostrarCadastroAlimento(request, response);
				break;
			case "/cadastro-ongsegundo":
				mostrarCadastroOngP2(request, response);
				break;

			case "/cadastro-conquista":
				mostrarCadastroConquista(request, response);
				break;
				
			case "/mostrar-alimentos":
				mostrarAlimentos(request, response);
				break;

			case "/inserir-doador":
				inserirDoador(request, response);
				break;

			case "/inserir-ong":
				inserirOng(request, response);
				break;

			case "/inserir-endereco-ong":
				inserirEnderecoOng(request, response);
				break;

			case "/inserir-pedido":
				inserirPedidoDoacao(request, response);
				break;

			case "/inserir-proposta":
				inserirPropostaDoacao(request, response);
				break;

			case "/inserir-item":
				inserirItem(request, response);
				break;

			case "/inserir-alimento":
				inserirAlimento(request, response);
				break;

			case "/inserir-conquista":
				inserirConquista(request, response);
				break;

			case "/doador-editado":
				editarDoador(request, response);
				break;

			case "/ong-editada":
				editarOng(request, response);
				break;

			case "/logout":
				logout(request, response);
				break;

			case "/conta-desativada":
				desativarConta(request, response);
				break;

			default:
				mostrarIndex(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void validarProposta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("./Propostas-analise.jsp");
		dispatcher.forward(request, response);

	}

	private void invalidarProposta(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./Propostas-analise.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarIndex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./index.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/login.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarPerfilDoador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao.getAttribute("usuario") instanceof Doador) {
			
			Conquista conquista = new Conquista("50 doações", "faça 50 doações");
			conquistaDAO.inserirConquista(conquista);
			Doador doador = new Doador("edeuardo", "1234", "37614237", LocalDate.of(2022, 10, 10));
			Contato contato = new Contato("3123123", "email@bolado", doador);
			doador.addConquista(conquista);
			usuarioDAO.inserirUsuario(doador);
			contatoDAO.inserirContato(contato);
			Long id = doador.getId();
			Doador doadorRecuperado = doadorDAO.recuperarDoadorId(id);
			Long quantidade = conquistaDAO.recuperarQuantidadeConquistaDoador(doadorRecuperado);
	
			request.setAttribute("doador", doadorRecuperado);
			request.setAttribute("conquistas", quantidade);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/perfil-doador.jsp");
			dispatcher.forward(request, response);
			
		}else if (sessao.getAttribute("usuario") instanceof Ong) {
			
			Conquista conquista = new Conquista("50 doações", "faça 50 doações");
			conquistaDAO.inserirConquista(conquista);
			Doador doador = new Doador("edeuardo", "1234", "37614237", LocalDate.of(2022, 10, 10));
			Contato contato = new Contato("3123123", "email@bolado", doador);
			doador.addConquista(conquista);
			usuarioDAO.inserirUsuario(doador);
			contatoDAO.inserirContato(contato);
			Long id = doador.getId();
			Doador doadorRecuperado = doadorDAO.recuperarDoadorId(id);
			Long quantidade = conquistaDAO.recuperarQuantidadeConquistaDoador(doadorRecuperado);

			request.setAttribute("doador", doadorRecuperado);
			request.setAttribute("conquistas", quantidade);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/perfil-doador.jsp");
			dispatcher.forward(request, response);
			
		}else {
			response.sendRedirect("login");
		}
	}

	private void mostrarPerfilOng(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao.getAttribute("usuario") instanceof Ong) {
		
			Ong ong = new Ong("amiguinho", "1234", "varioscnpj");
			usuarioDAO.inserirUsuario(ong);
			Endereco endereco = new Endereco("ama", "bairro da paz", 10, "blumenau", "AM", "cepbolado", ong);
			enderecoDAO.inserirEndereco(endereco);
			Contato contato = new Contato("213123", "email@bolado", ong);
			contatoDAO.inserirContato(contato);
	
			Contato contatoRecuperado = contatoDAO.recuperarContatoUsuario(ong);
	
			Ong ongRecuperada = ongDAO.recuperarOngPorIdFetch(ong.getId());
	
			request.setAttribute("ong", ongRecuperada);
			request.setAttribute("contato", contatoRecuperado);
	
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/perfil-ong.jsp");
			dispatcher.forward(request, response);
		
		}else if (sessao.getAttribute("usuario") instanceof Doador) {
			
			Ong ong = new Ong("amiguinho", "1234", "varioscnpj");
			usuarioDAO.inserirUsuario(ong);
			Endereco endereco = new Endereco("ama", "bairro da paz", 10, "blumenau", "AM", "cepbolado", ong);
			enderecoDAO.inserirEndereco(endereco);
			Contato contato = new Contato("213123", "email@bolado", ong);
			contatoDAO.inserirContato(contato);

			Contato contatoRecuperado = contatoDAO.recuperarContatoUsuario(ong);

			Ong ongRecuperada = ongDAO.recuperarOngPorIdFetch(ong.getId());

			request.setAttribute("ong", ongRecuperada);
			request.setAttribute("contato", contatoRecuperado);

			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/perfil-ong.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("login");
		}
		
	}

	private void mostrarAvaliarProposta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		
		if (sessao.getAttribute("usuario") instanceof Ong) {
		
			Alimento alimento = new Alimento("arroz", LocalDate.now());
			alimentoDAO.inserirAlimento(alimento);
			Ong ong = new Ong("nomebolado", "senhabolada", "23123");
			usuarioDAO.inserirUsuario(ong);
			Doador doador = new Doador("edeuardo", "1234", "37614237", LocalDate.of(2022, 10, 10));
			usuarioDAO.inserirUsuario(doador);
			Contato contato = new Contato("3123123", "email@bolado", doador);
			contatoDAO.inserirContato(contato);
			PedidoDoacao pedido = new PedidoDoacao("titulobolado", "descricaobolada", LocalDate.now(), StatusPedido.ATIVO,
					ong);
			pedidoDoacaoDAO.inserirPedidoDoacao(pedido);
			PropostaDoacao proposta = new PropostaDoacao(StatusProposta.ANALISE, doador, LocalDate.now(), pedido);
			propostaDoacaoDAO.inserirPropostaDoacao(proposta);
			Item item = new Item("10KG", alimento, proposta, pedido);
			itemDAO.inserirItem(item);
	
			usuarioDAO.inserirUsuario(doador);
			contatoDAO.inserirContato(contato);
	
			Contato contatoRecuperado = contatoDAO.recuperarContatoUsuario(doador);
			Item itemRecuperado = itemDAO.recuperarItemPorProposta(proposta);
			request.setAttribute("itemRecuperado", itemRecuperado);
			request.setAttribute("contatoRecuperado", contatoRecuperado);
	
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/avaliar-proposta.jsp");
			dispatcher.forward(request, response);
		
		}else {
			response.sendRedirect("login");
		}
	}

	private void mostrarConfirmarExclusao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/confirmar-exclusao.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarDescricaoPedido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao.getAttribute("usuario") instanceof Ong) {
			Ong ongRecuperada = ongDAO.recuperarOngId(usuario.getId());
	
			//usuarioDAO.inserirUsuario(ong);
			Doador doador = new Doador("eduardo", "238756", "986437", LocalDate.of(2022, 10, 10));
			PedidoDoacao pedido = new PedidoDoacao("pedidopedido", "descricao", LocalDate.now(), StatusPedido.ATIVO, ongRecuperada);
			pedidoDoacaoDAO.inserirPedidoDoacao(pedido);
			PropostaDoacao proposta = new PropostaDoacao(StatusProposta.ANALISE, doador, LocalDate.of(2022, 10, 10),
					pedido);
			//doador.addProposta(proposta);
			usuarioDAO.inserirUsuario(doador);
			propostaDoacaoDAO.inserirPropostaDoacao(proposta);
	
	
			PedidoDoacao pedidoRecuperado = pedidoDoacaoDAO.recuperarPedidoDoacaoId(pedido.getId());
	
			request.setAttribute("pedidoDoacao", pedidoRecuperado);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/descricao-pedido.jsp");
			dispatcher.forward(request, response);
		}else if(sessao.getAttribute("usuario") instanceof Ong) {
			Ong ongRecuperada = ongDAO.recuperarOngId(usuario.getId());

			//usuarioDAO.inserirUsuario(ong);
			Doador doador = new Doador("eduardo", "238756", "986437", LocalDate.of(2022, 10, 10));
			PedidoDoacao pedido = new PedidoDoacao("pedidopedido", "descricao", LocalDate.now(), StatusPedido.ATIVO, ongRecuperada);
			pedidoDoacaoDAO.inserirPedidoDoacao(pedido);
			PropostaDoacao proposta = new PropostaDoacao(StatusProposta.ANALISE, doador, LocalDate.of(2022, 10, 10),
					pedido);
			//doador.addProposta(proposta);
			usuarioDAO.inserirUsuario(doador);
			propostaDoacaoDAO.inserirPropostaDoacao(proposta);


			PedidoDoacao pedidoRecuperado = pedidoDoacaoDAO.recuperarPedidoDoacaoId(pedido.getId());

			request.setAttribute("pedidoDoacao", pedidoRecuperado);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/descricao-pedido.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	private void mostrarEditarPedido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();

		if (sessao.getAttribute("usuario") instanceof Ong) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/editar-pedido.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	private void mostrarEditarPerfilOng(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao.getAttribute("usuario") instanceof Ong) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/editar-perfil-ong.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	private void mostrarEditarPerfilDoador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao.getAttribute("usuario") instanceof Doador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/editar-perfil-doador.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	private void mostrarExcluirContaUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao.getAttribute("usuario") instanceof Doador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/excluir-conta-usuario.jsp");
			dispatcher.forward(request, response);
		}else if(sessao.getAttribute("usuario") instanceof Ong) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/excluir-conta-usuario.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	private void mostrarHistoricoDoacoes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao.getAttribute("usuario") instanceof Doador) {
			Ong ong = new Ong("amiguinho", "38947612", "49378794");
	
			usuarioDAO.inserirUsuario(ong);
			Doador doador = new Doador("eduardo", "238756", "986437", LocalDate.of(2022, 10, 10));
			PedidoDoacao pedido = new PedidoDoacao("pedidopedido", "descricao", LocalDate.now(), StatusPedido.ATIVO, ong);
			pedidoDoacaoDAO.inserirPedidoDoacao(pedido);
			PropostaDoacao proposta = new PropostaDoacao(StatusProposta.ACEITO, doador, LocalDate.of(2022, 10, 10), pedido);
			usuarioDAO.inserirUsuario(doador);
	
			propostaDoacaoDAO.inserirPropostaDoacao(proposta);
			doador.addProposta(proposta);
			List<PropostaDoacao> propostasDoacoes = propostaDoacaoDAO.recuperarTodasPropostaDoacaoOngStatusFetch(ong,
					StatusProposta.ACEITO);
	
			request.setAttribute("propostaDoacao", propostasDoacoes);
			request.setAttribute("ong", ong);
			request.setAttribute("doador", doador);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/historico-doacoes.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	private void mostrarHistoricoPedidos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		
		List<PedidoDoacao> pedidos = pedidoDoacaoDAO.recuperarPedidoDoacaoOng(ongDAO.recuperarOngId(usuario.getId()));
		request.setAttribute("pedidos", pedidos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/paginas/historico-pedidos.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarPropostasAnalise(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao.getAttribute("usuario") instanceof Ong) {
			
			Ong ong = new Ong("amiguinho" , "38947612", "49378794");
	
			usuarioDAO.inserirUsuario(ong);
			Doador doador = new Doador( "eduardo", "238756", "986437", LocalDate.of(2022, 10, 10));
			PedidoDoacao pedido = new PedidoDoacao("pedidopedido","descricao", LocalDate.now(), StatusPedido.ATIVO, ong);
			pedidoDoacaoDAO.inserirPedidoDoacao(pedido);
			PropostaDoacao proposta = new PropostaDoacao(StatusProposta.ANALISE, doador, LocalDate.of(2022, 10, 10),pedido);
			doador.addProposta(proposta);
			usuarioDAO.inserirUsuario(doador);
			propostaDoacaoDAO.inserirPropostaDoacao(proposta);
	
			List<PropostaDoacao> propostasDoacoes = propostaDoacaoDAO.recuperarTodasPropostaDoacaoOngStatusFetch(ong, StatusProposta.ANALISE);
	
			request.setAttribute("propostaDoacao", propostasDoacoes);
			request.setAttribute("ong", ong);
			request.setAttribute("doador", doador);
	
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/propostas-analise.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	private void mostrarPropostasRealizadas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao.getAttribute("usuario") instanceof Doador) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/propostas-realizadas.jsp");
			dispatcher.forward(request, response);
		}	else {
			response.sendRedirect("login");
		}
	}

	private void mostrarRecuperarSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao.getAttribute("usuario") instanceof Ong) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/recuperar-senha.jsp");
			dispatcher.forward(request, response);
		}else if (sessao.getAttribute("usuario") instanceof Doador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/recuperar-senha.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	private void mostrarRedefinirSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao.getAttribute("usuario") instanceof Ong) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/redefinir-senha.jsp");
		dispatcher.forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	private void mostrarTermos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/termos.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarCadastroDoador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/cadastro-doador.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarCadastroOng(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/cadastro-ong.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarCadastroOngP2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/cadastro-ongsegundo.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarCadastroPedido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao.getAttribute("usuario") instanceof Ong) {
			List<Alimento> alimentos = alimentoDAO.recuperarAlimentos();
	
			request.setAttribute("alimentos", alimentos);
	
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/cadastro-pedido.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	private void mostrarCadastroProposta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao.getAttribute("usuario") instanceof Doador) {
			List<Alimento> alimentos = alimentoDAO.recuperarAlimentos();
			List<PedidoDoacao> pedidos = pedidoDoacaoDAO.recuperarPedidosDoacao();
			List<Doador> doadores = doadorDAO.recuperarListaDoadores();
	
			request.setAttribute("alimentos", alimentos);
			request.setAttribute("pedidos", pedidos);
			request.setAttribute("doadores", doadores);
	
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/cadastro-proposta.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	private void mostrarCadastroAlimento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/cadastro-alimento.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarCadastroConquista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/cadastro-conquista.jsp");
		dispatcher.forward(request, response);
	}

	private void confirmarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usuarioInvalido = null;

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		boolean existe = usuarioDAO.verificarUsuario(email, senha);

		if (existe) {

			HttpSession session = request.getSession();
			Usuario usuario = usuarioDAO.recuperarUsuarioEmail(email);
			session.setAttribute("usuario", usuario);
			if (session.getAttribute("usuario") instanceof Ong) {
				response.sendRedirect("perfil-ong");
			} else {
				response.sendRedirect("perfil-doador");
			}
		} else {

			usuarioInvalido = "usuarioInvalido";

			request.setAttribute("usuarioInvalido", usuarioInvalido);
			response.sendRedirect("login");
		}

	}

	private void inserirDoador(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Doador doador = null;

		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		LocalDate data = LocalDate.parse(request.getParameter("data-nascimento"));
		String cpf = request.getParameter("cpf");

		Contato contato = null;

		String email = request.getParameter("email");
		String telefone = request.getParameter("celular");

		doador = new Doador(nome, senha, cpf, data);
		contato = new Contato(telefone, email, doador);

		usuarioDAO.inserirUsuario(doador);
		contatoDAO.inserirContato(contato);

		response.sendRedirect("login");
	}

	private void inserirOng(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Ong ong = null;

		String nome = request.getParameter("nome-ong");
		String senha = request.getParameter("senha-ong");
		String cnpj = request.getParameter("cpf-cnpj-ong");

		Contato contato = null;

		String email = request.getParameter("email-ong");
		String telefone = request.getParameter("tefelone-ong");

		ong = new Ong(nome, senha, cnpj);
		contato = new Contato(telefone, email, ong);

		usuarioDAO.inserirUsuario(ong);
		contatoDAO.inserirContato(contato);

		response.sendRedirect("cadastro-ongsegundo");

		HttpSession session = request.getSession();
		session.setAttribute("ong", ong);

	}

	private void inserirEnderecoOng(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession session = request.getSession();
		Ong ong = (Ong) session.getAttribute("ong");

		Endereco endereco = null;

		String cidade = request.getParameter("cidade-ong");
		String cep = request.getParameter("cep-ong");
		String logradouro = request.getParameter("logradouro-ong");
		String complemento = request.getParameter("complemento-ong");
		String unidadeFederativa1 = request.getParameter("uf-ong");
		String bairro = request.getParameter("bairro-ong");
		int numero = Integer.parseInt(request.getParameter("numero-ong"));

		endereco = new Endereco(logradouro, bairro, numero, cidade, unidadeFederativa1, cep, complemento, ong);
		enderecoDAO.inserirEndereco(endereco);

		response.sendRedirect("login");

	}

	private void inserirPedidoDoacao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		Ong ong = ongDAO.recuperarOngId(usuario.getId());
		PedidoDoacao pedidoDoacao = null;
		Item item = null;
		

		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		LocalDate data = LocalDate.parse(request.getParameter("data-validade"));
		String quantidade = request.getParameter("quantidade");
		Alimento alimentos = alimentoDAO.recuperarAlimentoId(Long.parseLong(request.getParameter("alimento")));
		int meta = Integer.parseInt(request.getParameter("meta-doacoes"));

		pedidoDoacao = new PedidoDoacao(titulo, descricao, data, StatusPedido.ATIVO, meta, ong);
		item = new Item(quantidade, alimentos, pedidoDoacao);

		pedidoDoacaoDAO.inserirPedidoDoacao(pedidoDoacao);
		itemDAO.inserirItem(item);

		response.sendRedirect("perfil-ong");
	}

	private void inserirPropostaDoacao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession session = request.getSession();
		Usuario usuario = (Doador) session.getAttribute("usuario");
		
		Doador doador = doadorDAO.recuperarDoadorId(usuario.getId());
		
		Item item = null;
		PropostaDoacao propostaDoacao = null;

		Alimento alimentos = alimentoDAO.recuperarAlimentoId(Long.parseLong(request.getParameter("alimento")));
		PedidoDoacao pedidosDoacao = pedidoDoacaoDAO
				.recuperarPedidoDoacaoId(Long.parseLong(request.getParameter("pedido")));
		String quantidade = request.getParameter("quantidade");
		LocalDate data = LocalDate.parse(request.getParameter("data-validade"));

		propostaDoacao = new PropostaDoacao(StatusProposta.ANALISE, doador, data, pedidosDoacao);
		item = new Item(quantidade, alimentos, propostaDoacao);
		
		propostaDoacao.addItem(item);
		propostaDoacaoDAO.inserirPropostaDoacao(propostaDoacao);
		itemDAO.inserirItem(item);

		response.sendRedirect("perfil-doador");

	}

	private void inserirItem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Alimento alimentos = alimentoDAO.recuperarAlimentoId(Long.parseLong(request.getParameter("alimento")));

		Item item = null;

		String quantidade = request.getParameter("quantidade");

		item = new Item(quantidade, alimentos);

		itemDAO.inserirItem(item);

		response.sendRedirect("cadastro-proposta");
	}

	private void inserirAlimento(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Alimento alimento = null;

		String nome = request.getParameter("nome");
		LocalDate data = LocalDate.parse(request.getParameter("data"));

		alimento = new Alimento(nome, data);

		alimentoDAO.inserirAlimento(alimento);

		response.sendRedirect("cadastro-proposta");
	}

	private void inserirConquista(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Conquista conquista = null;

		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		conquista = new Conquista(nome, descricao);

		conquistaDAO.inserirConquista(conquista);

		response.sendRedirect("perfil-doador");
	}

	private void editarDoador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		Doador doador = doadorDAO.recuperarDoadorId(usuario.getId());
		Contato contato = contatoDAO.recuperarContatoId(usuario.getId());

		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		LocalDate data = LocalDate.parse(request.getParameter("data-nascimento"));
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String celular = request.getParameter("celular");
		
		System.out.println(nome);
		doador.setNome(nome);
		doador.setSenha(senha);
		doador.setData(data);
		doador.setCpf(cpf);
		contato.setCelular(celular);
		contato.setEmail(email);

		contatoDAO.atualizarContato(contato);
		usuarioDAO.atualizarUsuario(doador);

		response.sendRedirect("perfil-doador");
	}

	private void editarOng(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		Ong ong = ongDAO.recuperarOngId(usuario.getId());
		Contato contato = contatoDAO.recuperarContatoId(usuario.getId());
		Endereco endereco = enderecoDAO.recuperarEnderecoId(usuario.getId());

		// endereco
		String cidade = request.getParameter("cidade");
		String cep = request.getParameter("cep");
		String logradouro = request.getParameter("logradouro");
		String complemento = request.getParameter("complemento");
		String unidadeFederativa = request.getParameter("uf");
		String bairro = request.getParameter("bairro");
		int numero = Integer.parseInt(request.getParameter("numero"));

		// ong
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String cnpj = request.getParameter("cnpj");

		// contato
		String email = request.getParameter("email");
		String celular = request.getParameter("celular");

		// endereco setters
		endereco.setCidade(cidade);
		endereco.setCep(cep);
		endereco.setLogradouro(logradouro);
		endereco.setComplemento(complemento);
		endereco.setUnidadeFederativa(unidadeFederativa);
		endereco.setBairro(bairro);
		endereco.setNumero(numero);

		// ong setters
		ong.setNome(nome);
		ong.setSenha(senha);
		ong.setCnpj(cnpj);

		// contato setters
		contato.setEmail(email);
		contato.setCelular(celular);

		enderecoDAO.atualizarEndereco(endereco);
		contatoDAO.atualizarContato(contato);
		usuarioDAO.atualizarUsuario(ong);

		RequestDispatcher dispatcher = request.getRequestDispatcher("resources/paginas/perfil-ong.jsp");
		dispatcher.forward(request, response);

	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().invalidate();

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}

	private void desativarConta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		boolean existe = usuarioDAO.verificarUsuario(email, senha);

		if (existe) {
			Usuario usuario = usuarioDAO.recuperarUsuarioEmail(email);
			usuarioDAO.deletarUsuario(usuario);
			RequestDispatcher dispatcher = request.getRequestDispatcher("resources/paginas/conta-desativada.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("confirmar-exclusao");
		}

	}
	
	private void mostrarAlimentos(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		
		List<Alimento> alimentos = alimentoDAO.recuperarAlimentos();
		request.setAttribute("alimentos", alimentos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("resources/paginas/mostrar-alimentos.jsp");
		dispatcher.forward(request, response);
		
	}
}
