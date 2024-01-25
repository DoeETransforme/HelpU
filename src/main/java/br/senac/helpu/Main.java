package br.senac.helpu;

import java.time.LocalDate;
import java.util.List;

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
import br.senac.helpu.modelo.dao.propostadoacao.PropostaDoacaoDAO;
import br.senac.helpu.modelo.dao.propostadoacao.PropostaDoacaoDAOImpl;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAO;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.helpu.modelo.entidade.alimento.Alimento;
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

public class Main {
	public static void main(String[] args) {
		UsuarioDAO usuarioDao = new UsuarioDAOImpl();
		ContatoDAO contatoDao = new ContatoDAOImpl();
		OngDAO ongDao = new OngDAOImpl();
		EnderecoDAO enderecoDao = new EnderecoDAOImpl();
		DoadorDAO doadorDao = new DoadorDAOImpl();
		PedidoDoacaoDAO pedidoDoacaoDao = new PedidoDoacaoDAOImpl();
		PropostaDoacaoDAO propostaDoacaoDao = new PropostaDoacaoDAOImpl();
		ItemDao itemDao = new ItemDAOImpl();
		AlimentoDAO alimentoDao = new AlimentoDAOImpl();

		Usuario usuario = new Usuario("Marlon", "123456");
		usuarioDao.inserirUsuario(usuario);

		Contato contato = new Contato("992832557", "marlon@gmail.com", usuario);

		
		contatoDao.inserirContato(contato);

		Ong ong = new Ong("HelpU", "654321", "5148212856455");
		usuarioDao.inserirUsuario(ong);

		Doador doador = new Doador("Ruan", "123456", "13351789732", LocalDate.now());
		usuarioDao.inserirUsuario(doador);

		PedidoDoacao pedidoDoacao = new PedidoDoacao("Arroz", "100 kg de arroz", LocalDate.of(1999, 07, 10),
				StatusPedido.ATIVO, ong);
		pedidoDoacaoDao.inserirPedidoDoacao(pedidoDoacao);

		PropostaDoacao propostaDoacao = new PropostaDoacao(StatusProposta.ANALISE, doador, LocalDate.now(),
				pedidoDoacao);
		propostaDoacaoDao.inserirPropostaDoacao(propostaDoacao);

		Endereco endereco = new Endereco("Rua Francisco", "Fortaleza", 255, "Blumenau", "SC", "89056900", ong);

		List<PedidoDoacao> pedidos = pedidoDoacaoDao.recuperarPedidoDoacaoOngStatus(ong, StatusPedido.ATIVO);
		for (PedidoDoacao pedido : pedidos) {
			System.out.println(pedido.getTitulo());
		}
	}
}