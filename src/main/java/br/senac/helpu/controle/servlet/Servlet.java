package br.senac.helpu.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

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
			case "/cadastrar-doador":
				inserirDoador(request, response);
				break;

			default:
				break;
			}
		} catch (Exception e) {

		}
	}

	private void inserirDoador(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, IOException, ServletException	{

		Doador doador = null;

		String nome = request.getParameter("nome");
		LocalDate data = LocalDate.parse(request.getParameter("data_nascimento"));
		String senha = request.getParameter("senha");
		String cpf = request.getParameter("cpf");


		Contato contato = null;

		String email = request.getParameter("email");
		String telefone = request.getParameter("celular");

		doador = new Doador(nome, senha, cpf, data);
		contato = new Contato(telefone, email, doador);


		contatoDAO.inserirContato(contato);
		usuarioDAO.inserirUsuario(doador);
	}
}