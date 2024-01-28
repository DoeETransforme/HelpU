package br.senac.helpu.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.helpu.modelo.dao.alimento.AlimentoDAO;
import br.senac.helpu.modelo.dao.alimento.AlimentoDAOImpl;
import br.senac.helpu.modelo.dao.contato.ContatoDAO;
import br.senac.helpu.modelo.dao.contato.ContatoDAOImpl;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAO;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.helpu.modelo.entidade.alimento.Alimento;
import br.senac.helpu.modelo.entidade.contato.Contato;
import br.senac.helpu.modelo.entidade.doador.Doador;

@WebServlet("/")
public class Servlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	private ContatoDAO contatoDAO;
	private AlimentoDAO alimentoDAO;

	public void init() {
		usuarioDAO = new UsuarioDAOImpl();
		contatoDAO = new ContatoDAOImpl();
		alimentoDAO = new AlimentoDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		String action = request.getServletPath();

		try {
			switch (action) {
			case "/":
				mostrarIndex(request, response);
				break;
				
			case "/login":
				mostrarLogin(request, response);
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
				
			case "/conta-desativada":
				mostrarContaDesativada(request, response);
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
				
			case "/excluir-conta-doador":
				mostrarExcluirContaDoador(request, response);
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
				
			case "/cadastro-proposta":
				mostrarCadastroProposta(request, response);
				break;	
				
//			case "/cadastro-pedido":
//				mostrarCadastroPedido(request, response);
//				break;
				
			case "/cadastro-alimento":
				mostrarCadastroAlimento(request, response);
				break;
				
			case "/inserir-doador":
				inserirDoador(request, response);
				break;
				
			case "/inserir-alimento":
				inserirAlimento(request, response);
				break;
				
			default:
				mostrarIndex(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
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
	
	private void mostrarPerfilDoador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/perfil-doador.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarPerfilOng(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/perfil-ong.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarAvaliarProposta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/avaliar-proposta.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarConfirmarExclusao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/confirmar-exclusao.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarContaDesativada(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/conta-desativada.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarDescricaoPedido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/descricao-pedido.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarEditarPedido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/editar-pedido.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarEditarPerfilOng(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/editar-perfil-ong.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarEditarPerfilDoador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/editar-perfil-doador.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarExcluirContaDoador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/excluir-conta-doador.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarHistoricoDoacoes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/historico-doacoes.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarHistoricoPedidos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/historico-pedidos.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarPropostasAnalise(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/propostas-analise.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarPropostasRealizadas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/propostas-realizadas.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarRecuperarSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/recuperar-senha.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarRedefinirSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/redefinir-senha.jsp");
		dispatcher.forward(request, response);
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
	
	private void mostrarCadastroProposta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/cadastro-proposta.jsp");
		dispatcher.forward(request, response);
	}

//	private void mostrarCadastroPedido(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/cadastro-pedido.jsp");
//		dispatcher.forward(request, response);
//	}
	
	private void mostrarCadastroAlimento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/cadastro-alimento.jsp");
		dispatcher.forward(request, response);
	}

	private void inserirDoador(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, IOException, ServletException	{

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
	
	
	
	private void inserirAlimento(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Alimento alimento = null;
		
		String nome = request.getParameter("nome-alimento");
		LocalDate data = LocalDate.parse(request.getParameter("data-validade"));
		float quantidade = Float.parseFloat(request.getParameter("quantidade-alimento"));
			
		alimento = new Alimento(nome, data, quantidade);
		
		alimentoDAO.inserirAlimento(alimento);
		
		response.sendRedirect("cadastro-proposta");
	}
}