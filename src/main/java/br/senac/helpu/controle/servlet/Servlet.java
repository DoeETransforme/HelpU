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

import br.senac.helpu.modelo.dao.contato.ContatoDAO;
import br.senac.helpu.modelo.dao.contato.ContatoDAOImpl;
import br.senac.helpu.modelo.dao.doador.DoadorDAO;
import br.senac.helpu.modelo.dao.doador.DoadorDAOImpl;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAO;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.helpu.modelo.entidade.contato.Contato;
import br.senac.helpu.modelo.entidade.doador.Doador;
import br.senac.helpu.modelo.entidade.ong.Ong;

@WebServlet("/")
public class Servlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	private DoadorDAO doadorDAO;
	private ContatoDAO contatoDAO;

	public void init() {
		usuarioDAO = new UsuarioDAOImpl();
		doadorDAO = new DoadorDAOImpl();
		contatoDAO = new ContatoDAOImpl();
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
				
			case "/login":
				mostrarLogin(request, response);
				break;
				
			case "/inserir-doador":
				inserirDoador(request, response);
				break;
			case "/cadastrar-ong":
				inserirOng(request,response);
				break;

			default:
				mostrarIndex(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void inserirOng(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		Ong ong = null;

		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String cnpj = request.getParameter("cnpj");


		Contato contato = null;

		String email = request.getParameter("email");
		String telefone = request.getParameter("celular");
		
		ong = new Ong(nome, senha, cnpj, data);
		contato = new Contato(telefone, email, doador);

		contatoDAO.inserirContato(contato);
		usuarioDAO.inserirUsuario(doador);
		
		response.sendRedirect("login");
	}
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