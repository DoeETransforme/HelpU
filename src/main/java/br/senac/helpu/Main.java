package br.senac.helpu;

import java.time.LocalDate;

import br.senac.helpu.modelo.dao.alimento.AlimentoDAO;
import br.senac.helpu.modelo.dao.alimento.AlimentoDAOImpl;
import br.senac.helpu.modelo.dao.contato.ContatoDAO;
import br.senac.helpu.modelo.dao.contato.ContatoDAOImpl;
import br.senac.helpu.modelo.dao.doador.DoadorDAO;
import br.senac.helpu.modelo.dao.doador.DoadorDAOImpl;
import br.senac.helpu.modelo.dao.endereco.EnderecoDAO;
import br.senac.helpu.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.helpu.modelo.dao.item.ItemDAOImpl;
import br.senac.helpu.modelo.dao.item.ItemDao;
import br.senac.helpu.modelo.dao.ong.OngDAO;
import br.senac.helpu.modelo.dao.ong.OngDAOImpl;
import br.senac.helpu.modelo.dao.pedidodoacao.PedidoDoacaoDAO;
import br.senac.helpu.modelo.dao.pedidodoacao.PedidoDoacaoDAOImpl;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAO;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.helpu.modelo.entidade.alimento.Alimento;
import br.senac.helpu.modelo.entidade.contato.Contato;
import br.senac.helpu.modelo.entidade.doador.Doador;
import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.entidade.item.Item;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.entidade.usuario.Usuario;
import br.senac.helpu.modelo.enumeracao.pedido.StatusPedido;

public class Main {
	public static void main(String[] args) {
		UsuarioDAO usuarioDao = new UsuarioDAOImpl();
		ContatoDAO contatoDao = new ContatoDAOImpl();
		OngDAO ongDao = new OngDAOImpl();
		EnderecoDAO enderecoDao = new EnderecoDAOImpl();
		DoadorDAO doadorDao = new DoadorDAOImpl();
		ItemDao itemDao = new ItemDAOImpl();
		AlimentoDAO alimentoDao = new AlimentoDAOImpl();
		
		
		Usuario usuario = new Usuario("Marlon", "123456", null);	
		usuarioDao.inserirUsuario(usuario);
		
		Contato contato = new Contato("992832557", "marlon@gmail.com", usuario);
		
		usuario.setContato(contato);
		contatoDao.inserirContato(contato);
		
		Ong ong = new Ong("HelpU", "654321", null, "5148212856455");
		usuarioDao.inserirUsuario(ong);
		
		Doador doador = new Doador("Ruan", "123456", null, "13351789732", LocalDate.now());
		usuarioDao.inserirUsuario(doador);
		
		/*
		 * Endereco endereco = new Endereco("Rua Floriano", "Fortaleza", 113,
		 * "Blumenau", "SC", "89066900"); enderecoDao.inserirEndereco(endereco);
		 */
				
		Item item = new Item(10);		
		itemDao.inserirItem(item);

		Alimento alimento = new Alimento(LocalDate.now(), 10, "Arroz");		
		alimentoDao.inserirAlimento(alimento);
		
		Item item = new Item(10);		
		itemDao.inserirItem(item);

		Alimento alimento = new Alimento(LocalDate.now(), 10, "Arroz");		
		alimentoDao.inserirAlimento(alimento);

		System.out.println(item.getQuantidade());

		
	}
}