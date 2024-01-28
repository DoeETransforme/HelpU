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
import javax.servlet.http.HttpSession;

import br.senac.helpu.modelo.dao.contato.ContatoDAO;
import br.senac.helpu.modelo.dao.contato.ContatoDAOImpl;
import br.senac.helpu.modelo.dao.doador.DoadorDAO;
import br.senac.helpu.modelo.dao.doador.DoadorDAOImpl;
import br.senac.helpu.modelo.dao.endereco.EnderecoDAO;
import br.senac.helpu.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAO;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.helpu.modelo.entidade.contato.Contato;
import br.senac.helpu.modelo.entidade.doador.Doador;
import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.entidade.ong.Ong;

@WebServlet("/")
public class Servlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	private DoadorDAO doadorDAO;
	private ContatoDAO contatoDAO;
	private EnderecoDAO enderecoDAO;

	public void init() {
		usuarioDAO = new UsuarioDAOImpl();
		doadorDAO = new DoadorDAOImpl();
		contatoDAO = new ContatoDAOImpl();
		enderecoDAO = new EnderecoDAOImpl();
		
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
				
			case "/cadastro-doador":
				mostrarFormularioDoador(request, response);
				break;
			case "/cadastro-ong":
				mostrarCadastroOng(request, response);
				break;
				
			case "/login":
				mostrarLogin(request, response);
				break;
			case "/cadastro-ongsegundo":
				mostrarCadastroOngP2(request, response);
				break;
				
			case "/inserir-doador":
				inserirDoador(request, response);
				break;
				
			case "/inserir-ong":
				inserirOng(request,response);
				break;
			case "/inserir-endereco-ong":
				inserirEnderecoOng(request,response);
				break;

			default:
				mostrarIndex(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void mostrarCadastroOng(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/cadastro-ong.jsp");
		dispatcher.forward(request, response);
	}
	
	private void inserirOng(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
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
		// No método mostrarCadastroOng
		HttpSession session = request.getSession();
		session.setAttribute("ong", ong);
		
		
		

	}
	
	private void inserirEnderecoOng(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// No método mostrarCadastroOngP2
		HttpSession session = request.getSession();
		Ong ong = (Ong) session.getAttribute("ong");
		
		Endereco endereco = null;
		
		

		
		
		String cidade = request.getParameter("cidade-ong");
		String cep = request.getParameter("cep-ong");
		String logradouro = request.getParameter("logradouro-ong");
		String complemento = request.getParameter("complemento-ong");
		String unidadeFederativa1 = request.getParameter("uf-ong");
		String bairro = request.getParameter("bairro-ong");
		String tipoLogradouro = request.getParameter("tipo-logradouro");
		int numero = Integer.parseInt(request.getParameter("numero-ong"));
		
		
		
		endereco = new Endereco(logradouro, bairro, complemento, numero, cidade , unidadeFederativa1 , cep, ong);
		enderecoDAO.inserirEndereco(endereco);
		
		response.sendRedirect("login");
		
	}
		
	
	
	private void mostrarCadastroOngP2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/cadastro-ongsegundo.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarIndex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./index.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarFormularioDoador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/cadastro-doador.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./resources/paginas/login.jsp");
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
}
