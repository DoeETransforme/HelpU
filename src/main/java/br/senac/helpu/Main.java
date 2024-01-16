package br.senac.helpu;
 
import java.time.LocalDate;

import br.senac.helpu.modelo.dao.contato.ContatoDAO;
import br.senac.helpu.modelo.dao.contato.ContatoDAOImpl;
import br.senac.helpu.modelo.dao.endereco.EnderecoDAO;
import br.senac.helpu.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAO;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.helpu.modelo.entidade.contato.Contato;
import br.senac.helpu.modelo.entidade.doador.Doador;
import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.entidade.ong.Ong;
 
public class Main {
	public static void main(String[] args) {
		
		Doador doador = new Doador("nome bolado", "senha bolada", null, "94787423", LocalDate.of(2022, 10, 10));
		
		Contato contato = new Contato("483478294", "email@gmail.com", doador );
		Ong ong = new Ong("amiguinho feliz", "456478", contato,"873487");

		ContatoDAO daoContato = new ContatoDAOImpl();
		UsuarioDAO usuarioDao = new UsuarioDAOImpl();
		daoContato.inserirContato(contato);
		usuarioDao.inserirUsuario(ong);
		
		Endereco endereco = new Endereco ("logradouro da paz", "bairro da paz", 10 , "Blumenau" , "SC", "122-21", ong);
		EnderecoDAO daoEndereco = new EnderecoDAOImpl();
		daoEndereco.inserirEndereco(endereco);

		
		


		
	}
}