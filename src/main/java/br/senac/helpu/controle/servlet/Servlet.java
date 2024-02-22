package br.senac.helpu.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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
import br.senac.helpu.modelo.dao.foto.FotoDAO;
import br.senac.helpu.modelo.dao.foto.FotoDAOImpl;
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
import br.senac.helpu.modelo.entidade.foto.Foto;
import br.senac.helpu.modelo.entidade.item.Item;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;
import br.senac.helpu.modelo.entidade.usuario.Usuario;
import br.senac.helpu.modelo.enumeracao.pedido.StatusPedido;
import br.senac.helpu.modelo.enumeracao.proposta.StatusProposta;
import br.senac.helpu.modelo.enumeracao.usuario.StatusUsuario;
import br.senac.helpu.util.ConversorImagem;

@MultipartConfig
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
	private FotoDAO fotoDAO;

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
		fotoDAO = new FotoDAOImpl();
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
		} else {
			String tipoUsuario = "3";
			request.setAttribute(tipoUsuario, tipoUsuario);
		}

		String action = request.getServletPath();

		try {
			switch (action) {
			case "/home":
				mostrarIndex(request, response);
				break;

			case "/mostrar-cadastro":
				mostrarCadastro(request, response);
				break;

			case "/login":
				mostrarLogin(request, response);
				break;

			case "/confirmar-login":
				confirmarLogin(request, response);
				break;
			

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

			case "/editar-conquista":
				mostrarEditarConquista(request, response);
				break;

			case "/editar-alimento":
				mostrarEditarAlimento(request, response);
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

			case "/mostrar-resultado-pesquisa":
				mostrarResultadoPesquisa(request, response);
				break;

			case "/mostrar-conquistas":
				mostrarConquistas(request, response);
				break;

			case "/mostrar-alimentos":
				mostrarAlimentos(request, response);
				break;

			case "/descricao-proposta":
				mostrarDescricacaoProposta(request, response);
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

			case "/pedido-editado":
				editarPedido(request, response);
				break;

			case "/excluir-pedido":
				mostrarExcluirPedido(request, response);
				break;

			case "/pedido-excluido":
				excluirPedido(request, response);
				break;

			case "/conquista-editada":
				editarConquista(request, response);
				break;

			case "/alimento-editado":
				editarAlimento(request, response);
				break;

			case "/propostas-pendentes":
				mostrarPropostasPendentes(request, response);
				break;

			case "/editar-proposta":
				mostrarEditarProposta(request, response);
				break;

			case "/excluir-proposta":
				mostrarExcluirProposta(request, response);
				break;

			case "/proposta-editada":
				editarProposta(request, response);
				break;

			case "/proposta-excluida":
				excluirProposta(request, response);
				break;

			case "/filtro-pedido":
				mostrarFiltroPedido(request, response);
				break;

			case "/pesquisar-pedido":
				pesquisarPedido(request, response);
				break;

			case "/logout":
				logout(request, response);
				break;

			case "/conta-desativada":
				desativarConta(request, response);
				break;
				
			case "/validar-proposta":
				mostrarValidarProposta(request, response);
				break;
 
			case "/invalidar-proposta":
				mostrarInvalidarProposta(request, response);
				break;
				
			case "/proposta-aceita":
				validarProposta(request, response);
				break;
 
			case "/proposta-recusada":
				invalidarProposta(request, response);
				break;

			default:
				mostrarIndex(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void mostrarInvalidarProposta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		PropostaDoacao proposta = propostaDoacaoDAO.recuperarPropostaDoacaoId(id);

		request.setAttribute("proposta", proposta);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/paginas/invalidar-proposta.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarValidarProposta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		PropostaDoacao proposta = propostaDoacaoDAO.recuperarPropostaDoacaoId(id);

		request.setAttribute("proposta", proposta);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/paginas/validar-proposta.jsp");
		dispatcher.forward(request, response);

	}

	private void validarProposta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario instanceof Ong) {

			Long id = Long.parseLong(request.getParameter("id"));
			PropostaDoacao propostaDoacao = propostaDoacaoDAO.recuperarPropostaDoacaoId(id);

			propostaDoacao.setStatusProposta(StatusProposta.ACEITO);
			propostaDoacaoDAO.atualizarPropostaDoacao(propostaDoacao);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/paginas/proposta-aceita.jsp");
			dispatcher.forward(request, response);
		} else if (usuario instanceof Doador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./login.jsp");
			dispatcher.forward(request, response);

		}
	}

	private void invalidarProposta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario instanceof Ong) {

			Long id = Long.parseLong(request.getParameter("id"));
			PropostaDoacao propostaDoacao = propostaDoacaoDAO.recuperarPropostaDoacaoId(id);

			propostaDoacao.setStatusProposta(StatusProposta.RECUSADO);
			propostaDoacaoDAO.atualizarPropostaDoacao(propostaDoacao);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/paginas/proposta-recusada.jsp");
			dispatcher.forward(request, response);
		} else if (usuario instanceof Doador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./login.jsp");
			dispatcher.forward(request, response);

		}
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

	private void mostrarCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/mostrar-cadastro.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarPerfilDoador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario instanceof Doador) {
			Doador doador = doadorDAO.recuperarDoadorId(usuario.getId());

			List<Conquista> conquistas = conquistaDAO.recuperarConquistasPorDoador(doador);
			long conquista = conquistaDAO.recuperarQuantidadeConquistaDoador(doador);
			List<PropostaDoacao> propostas = propostaDoacaoDAO
					.recuperarTodasPropostaDoacaoDoadorStatusLimitTrace(doador, StatusProposta.ACEITO);

			request.setAttribute("propostas", propostas);
			request.setAttribute("qntdConquistas", conquista);
			request.setAttribute("doador", doador);
			request.setAttribute("conquistas", conquistas);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/paginas/perfil-doador.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarPerfilOng(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario instanceof Ong) {
			Ong ong = ongDAO.recuperarOngId(usuario.getId());
			Contato contato = contatoDAO.recuperarContatoId(usuario.getId());
			List<PedidoDoacao> pedidos = pedidoDoacaoDAO.recuperarPedidoDoacaoOng(ong);

			request.setAttribute("pedidos", pedidos);
			request.setAttribute("contato", contato);
			request.setAttribute("ong", ong);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/paginas/perfil-ong.jsp");
			dispatcher.forward(request, response);
		} else if (usuario instanceof Doador) {
			Ong ong = ongDAO.recuperarOngId(usuario.getId());

			Contato contato = contatoDAO.recuperarContatoId(usuario.getId());
			List<PedidoDoacao> pedidos = pedidoDoacaoDAO.recuperarPedidoDoacaoOng(ong);

			request.setAttribute("pedidos", pedidos);
			request.setAttribute("contato", contato);
			request.setAttribute("ong", ong);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/paginas/perfil-ong.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void mostrarAvaliarProposta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao.getAttribute("usuario") instanceof Ong) {
			Ong ong = (Ong) usuario;

			Long id = Long.parseLong(request.getParameter("id"));

			PropostaDoacao proposta = propostaDoacaoDAO.recuperarPropostaDoacaoId(id);
			PropostaDoacao propostaContato = propostaDoacaoDAO.recuperarPropostaDoacaoContatoId(id);

			request.setAttribute("proposta", proposta);
			request.setAttribute("propostaContato", propostaContato);

			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/avaliar-proposta.jsp");
			dispatcher.forward(request, response);

		} else {
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

		if (usuario instanceof Ong) {
			Ong ong = (Ong) usuario;

			Long id = Long.parseLong(request.getParameter("id"));

			PedidoDoacao pedido = pedidoDoacaoDAO.recuperarPedidoDoacaoId(id);
			List<PropostaDoacao> propostas = propostaDoacaoDAO.recuperarTodasPropostaDoacaoPedido(pedido);
			List<PedidoDoacao> pedidos = pedidoDoacaoDAO.recuperarPedidoDoacaoOng(ong);

			request.setAttribute("pedido", pedido);
			request.setAttribute("propostas", propostas);
			request.setAttribute("pedidos", pedidos);

			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/descricao-pedido.jsp");
			dispatcher.forward(request, response);

		} else if (usuario instanceof Doador) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/descricao-pedido.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	private void mostrarEditarPedido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();

		if (sessao.getAttribute("usuario") instanceof Ong) {
			List<Alimento> alimentos = alimentoDAO.recuperarAlimentos();
			Long id = Long.parseLong(request.getParameter("id"));
			PedidoDoacao pedido = pedidoDoacaoDAO.recuperarPedidoDoacaoId(id);

			request.setAttribute("pedido", pedido);
			request.setAttribute("alimentos", alimentos);

			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/editar-pedido.jsp");
			dispatcher.forward(request, response);
		} else {
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
		} else {
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
		} else {
			response.sendRedirect("login");
		}
	}

	private void mostrarExcluirContaUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao.getAttribute("usuario") instanceof Doador) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("./resources/paginas/excluir-conta-usuario.jsp");
			dispatcher.forward(request, response);
		} else if (sessao.getAttribute("usuario") instanceof Ong) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("./resources/paginas/excluir-conta-usuario.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	private void mostrarHistoricoDoacoes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario instanceof Doador) {
			Doador doador = doadorDAO.recuperarDoadorId(usuario.getId());

			List<PropostaDoacao> propostasDoacoes = propostaDoacaoDAO.recuperarTodasPropostaDoacaoDoadorStatus(doador,
					StatusProposta.ACEITO);

			request.setAttribute("propostasDoacoes", propostasDoacoes);

			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/historico-doacoes.jsp");
			dispatcher.forward(request, response);
		} else {
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

		if (usuario instanceof Ong) {

			Ong ong = (Ong) usuario;

			List<PropostaDoacao> propostas = propostaDoacaoDAO.recuperarTodasPropostaDoacaoOngStatusFetch(ong,
					StatusProposta.ANALISE);

			request.setAttribute("propostas", propostas);

			request.setAttribute("ong", ong);

			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/propostas-analise.jsp");
			dispatcher.forward(request, response);
		} else {
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
		} else {
			response.sendRedirect("login");
		}
	}

	private void mostrarPropostasPendentes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario instanceof Doador) {

			Doador doador = (Doador) usuario;

			List<PropostaDoacao> propostas = propostaDoacaoDAO.recuperarTodasPropostaDoacaoDoadorStatus(doador,
					StatusProposta.ANALISE);
			request.setAttribute("propostas", propostas);

			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/propostas-pendentes.jsp");
			dispatcher.forward(request, response);
		} else {
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
		} else if (sessao.getAttribute("usuario") instanceof Doador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/recuperar-senha.jsp");
			dispatcher.forward(request, response);
		} else {
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
		} else {
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

		if (usuario instanceof Ong) {
			List<Alimento> alimentos = alimentoDAO.recuperarAlimentos();

			request.setAttribute("alimentos", alimentos);

			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/cadastro-pedido.jsp");
			dispatcher.forward(request, response);
		} else {
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
		} else {
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

	private void mostrarConquistas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Conquista> conquistas = conquistaDAO.recuperarConquistas();
		request.setAttribute("conquistas", conquistas);

		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/mostrar-conquistas.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarDescricacaoProposta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario instanceof Doador) {

			Long id = Long.parseLong(request.getParameter("id"));
			PropostaDoacao proposta = propostaDoacaoDAO.recuperarPropostaDoacaoId(id);

			request.setAttribute("proposta", proposta);

			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/descricao-proposta.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("login");
		}
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
		String strData = request.getParameter("data-nascimento");
		System.out.println(strData);
		LocalDate data = LocalDate.parse(strData);
		String cpf = request.getParameter("cpf");

		Part partDoador = request.getPart("foto");
		String extensao = partDoador.getContentType();
		byte[] fotobyte = ConversorImagem.obterBytes(partDoador);
		Foto foto = new Foto(fotobyte, extensao);

		Contato contato = null;

		String email = request.getParameter("email");
		String telefone = request.getParameter("celular");

		doador = new Doador(nome, senha, StatusUsuario.ATIVO, foto, cpf, data);
		contato = new Contato(telefone, email, doador);

		fotoDAO.inserirFoto(foto);
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
		String telefone = request.getParameter("telefone-ong");
		
		Part partOng = request.getPart("foto");
		String extensao = partOng.getContentType();
		byte[] fotobyte = ConversorImagem.obterBytes(partOng);
		
		Foto foto = new Foto(fotobyte, extensao);
		
		

		ong = new Ong(nome, senha, StatusUsuario.ATIVO, foto ,cnpj);
		contato = new Contato(telefone, email, ong);

		fotoDAO.inserirFoto(foto);
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
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
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
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		LocalDate data = LocalDate.parse(request.getParameter("data-validade"));

		propostaDoacao = new PropostaDoacao(StatusProposta.ANALISE, doador, data, pedidosDoacao);
		item = new Item(quantidade, alimentos, propostaDoacao);

		propostaDoacaoDAO.inserirPropostaDoacao(propostaDoacao);
		itemDAO.inserirItem(item);

		response.sendRedirect("perfil-doador");

	}

	private void inserirItem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Alimento alimentos = alimentoDAO.recuperarAlimentoId(Long.parseLong(request.getParameter("alimento")));

		Item item = null;

		int quantidade = Integer.parseInt(request.getParameter("quantidade"));

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
		Foto foto = fotoDAO.recuperarFotoUsuario(usuario);
		
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		LocalDate data = null;
		if (request.getParameter("data-nascimento").trim().length() > 0) {
			data = LocalDate.parse(request.getParameter("data-nascimento"));			
		}
		
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String celular = request.getParameter("celular");
		
		Part partDoador = request.getPart("foto");
		String extensao = partDoador.getContentType();
		byte[] fotobyte = ConversorImagem.obterBytes(partDoador);
		
		
		foto.setBinario(fotobyte);
		foto.setExtensao(extensao);
		doador.setNome(nome);
		doador.setSenha(senha);
		doador.setData(data);
		doador.setCpf(cpf);
		doador.setFotoUsuario(foto);
		contato.setCelular(celular);
		contato.setEmail(email);
		
		fotoDAO.atualizarFoto(foto);
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
		Foto foto = fotoDAO.recuperarFotoUsuario(ong);
		
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
		
		//Foto
		Part partDoador = request.getPart("foto");
		String extensao = partDoador.getContentType();
		byte[] fotobyte = ConversorImagem.obterBytes(partDoador);
		
		//foto setters
		foto.setBinario(fotobyte);
		foto.setExtensao(extensao);

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
		ong.setFotoUsuario(foto);

		// contato setters
		contato.setEmail(email);
		contato.setCelular(celular);
		
		fotoDAO.atualizarFoto(foto);
		enderecoDAO.atualizarEndereco(endereco);
		contatoDAO.atualizarContato(contato);
		usuarioDAO.atualizarUsuario(ong);

		response.sendRedirect("perfil-ong");

	}

	private void editarPedido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		StatusPedido status = StatusPedido.valueOf(request.getParameter("status"));
		Alimento alimento = alimentoDAO.recuperarAlimentoId(Long.parseLong(request.getParameter("alimento")));
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		int meta = Integer.parseInt(request.getParameter("meta"));
		LocalDate data = LocalDate.parse(request.getParameter("data"));

		PedidoDoacao pedido = pedidoDoacaoDAO.recuperarPedidoDoacaoId(id);
		Item item = itemDAO.recuperarItemPorPedido(pedido);

		pedido.setData(data);
		pedido.setDescricao(descricao);
		pedido.setMetaDoacoes(meta);
		pedido.setStatusPedido(status);
		pedido.setTitulo(titulo);
		item.setAlimento(alimento);
		item.setQuantidade(quantidade);

		pedidoDoacaoDAO.atualizarPedidoDoacao(pedido);
		itemDAO.atualizarItem(item);

		response.sendRedirect("historico-pedidos");

	}

	private void mostrarExcluirPedido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		PedidoDoacao pedido = pedidoDoacaoDAO.recuperarPedidoDoacaoId(id);

		request.setAttribute("pedido", pedido);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/paginas/excluir-pedido.jsp");
		dispatcher.forward(request, response);

	}

	private void excluirPedido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		PedidoDoacao pedido = pedidoDoacaoDAO.recuperarPedidoDoacaoId(id);

		pedidoDoacaoDAO.deletarPedidoDoacao(pedido);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/paginas/historico-pedidos.jsp");
		dispatcher.forward(request, response);

	}

	private void editarProposta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		Alimento alimentos = alimentoDAO.recuperarAlimentoId(Long.parseLong(request.getParameter("alimento")));
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));

		PropostaDoacao proposta = propostaDoacaoDAO.recuperarPropostaDoacaoId(id);
		Item item = itemDAO.recuperarItemPorProposta(proposta);

		item.setAlimento(alimentos);
		item.setQuantidade(quantidade);

		itemDAO.atualizarItem(item);
		propostaDoacaoDAO.atualizarPropostaDoacao(proposta);

		response.sendRedirect("propostas-pendentes");
	}

	private void mostrarEditarProposta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario instanceof Doador) {
			List<Alimento> alimentos = alimentoDAO.recuperarAlimentos();
			List<PedidoDoacao> pedidos = pedidoDoacaoDAO.recuperarPedidosDoacao();
			List<Doador> doadores = doadorDAO.recuperarListaDoadores();
			Long id = Long.parseLong(request.getParameter("id"));
			PropostaDoacao proposta = propostaDoacaoDAO.recuperarPropostaDoacaoId(id);

			request.setAttribute("proposta", proposta);
			request.setAttribute("alimentos", alimentos);
			request.setAttribute("pedidos", pedidos);
			request.setAttribute("doadores", doadores);

			RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/editar-proposta.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	private void mostrarExcluirProposta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		PropostaDoacao proposta = propostaDoacaoDAO.recuperarPropostaDoacaoId(id);

		request.setAttribute("proposta", proposta);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/paginas/excluir-proposta.jsp");
		dispatcher.forward(request, response);

	}

	private void excluirProposta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		PropostaDoacao proposta = propostaDoacaoDAO.recuperarPropostaDoacaoId(id);

		propostaDoacaoDAO.deletarPropostaDoacao(proposta);

	}

	private void mostrarEditarConquista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Conquista conquista = conquistaDAO.recuperarConquistaId(id);

		request.setAttribute("conquista", conquista);

		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/editar-conquista.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarEditarAlimento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Alimento alimento = alimentoDAO.recuperarAlimentoId(id);

		request.setAttribute("alimento", alimento);

		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/editar-alimento.jsp");
		dispatcher.forward(request, response);

	}

	private void editarConquista(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		Conquista conquista = conquistaDAO.recuperarConquistaId(id);

		conquista.setNome(nome);
		conquista.setDescricao(descricao);

		conquistaDAO.atualizarConquista(conquista);

		response.sendRedirect("mostrar-conquistas");
	}

	private void editarAlimento(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		LocalDate data = LocalDate.parse(request.getParameter("data"));

		Alimento alimento = alimentoDAO.recuperarAlimentoId(id);

		alimento.setNome(nome);
		alimento.setDataValidade(data);

		alimentoDAO.atualizarAlimento(alimento);

		response.sendRedirect("mostrar-alimentos");
	}

	private void mostrarFiltroPedido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Alimento> alimentos = alimentoDAO.recuperarAlimentos();
		request.setAttribute("alimentos", alimentos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/paginas/filtro-pedido.jsp");
		dispatcher.forward(request, response);

	}

	private void pesquisarPedido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String status = request.getParameter("status");
		Optional<StatusPedido> statusop = (status == "") ? Optional.empty() : Optional.of(StatusPedido.valueOf(status));

		String nome = request.getParameter("nome");
		Optional<String> nomeop = (nome == "") ? Optional.empty() : Optional.of(nome);

		String dataInicial = request.getParameter("datainicial");
		Optional<LocalDate> dataInicialop = (dataInicial == "") ? Optional.empty()
				: Optional.of(LocalDate.parse(dataInicial));

		String dataFinal = request.getParameter("datainicial");
		Optional<LocalDate> dataFinalop = (dataFinal == "") ? Optional.empty()
				: Optional.of(LocalDate.parse(dataFinal));

		String alimento = request.getParameter("alimento");
		Optional<Alimento> alimentoop = Optional.empty();
		if (alimento != null) {
			alimentoop = (alimento == "") ? Optional.empty()
					: Optional.of((alimentoDAO.recuperarAlimentoId(Long.parseLong(alimento))));

		}
		List<PedidoDoacao> pedidos = pedidoDoacaoDAO.filtrarPedidos(statusop, nomeop, dataInicialop, dataFinalop,
				alimentoop);
		request.setAttribute("pedidos", pedidos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/paginas/resultado-pesquisa.jsp");
		dispatcher.forward(request, response);

	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().invalidate();

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}

	private void desativarConta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario instanceof Doador) {
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");

			boolean existe = usuarioDAO.verificarUsuario(email, senha);

			if (existe) {
				usuario = usuarioDAO.recuperarUsuarioEmail(email);
				usuario.setStatus(StatusUsuario.INATIVO);
				usuarioDAO.atualizarUsuario(usuario);
				RequestDispatcher dispatcher = request.getRequestDispatcher("resources/paginas/conta-desativada.jsp");
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("confirmar-exclusao");
			}
		} else if (usuario instanceof Ong) {
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");

			boolean existe = usuarioDAO.verificarUsuario(email, senha);

			if (existe) {
				usuario = usuarioDAO.recuperarUsuarioEmail(email);
				usuario.setStatus(StatusUsuario.INATIVO);
				usuarioDAO.atualizarUsuario(usuario);
				RequestDispatcher dispatcher = request.getRequestDispatcher("resources/paginas/conta-desativada.jsp");
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("confirmar-exclusao");
			}
		}

	}

	private void mostrarAlimentos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Alimento> alimentos = alimentoDAO.recuperarAlimentos();
		request.setAttribute("alimentos", alimentos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("resources/paginas/mostrar-alimentos.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarResultadoPesquisa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<PedidoDoacao> pedidos = pedidoDoacaoDAO.recuperarPedidosDoacao();
		request.setAttribute("pedidos", pedidos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("resources/paginas/resultado-pesquisa");
		dispatcher.forward(request, response);

	}
}