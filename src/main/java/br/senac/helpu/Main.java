package br.senac.helpu;
 
import java.time.LocalDate;

import br.senac.helpu.modelo.dao.pedidodoacao.PedidoDoacaoDAO;
import br.senac.helpu.modelo.dao.pedidodoacao.PedidoDoacaoDAOImpl;
import br.senac.helpu.modelo.dao.propostadoacao.PropostaDoacaoDAO;
import br.senac.helpu.modelo.dao.propostadoacao.PropostaDoacaoDAOImpl;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAO;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.helpu.modelo.entidade.doador.Doador;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;
import br.senac.helpu.modelo.enumeracao.statuspedido.StatusPedido;
import br.senac.helpu.modelo.enumeracao.statusproposta.StatusProposta;
 
public class Main {
	public static void main(String[] args) {
		
		
		Doador doador = new Doador("joão", "senha1234",null, "cpf", LocalDate.of(2022, 10, 10));
		Ong ong = new Ong("amiguinhfeliz", "senha213", null, "cnpj");
		UsuarioDAO daoUsuario = new UsuarioDAOImpl();
		daoUsuario.inserirUsuario(ong);
		PedidoDoacao pedido = new PedidoDoacao("ajude", "descricao", StatusPedido.ATIVO, LocalDate.of(2022,10, 10), ong);
		PedidoDoacaoDAO daoPedido = new PedidoDoacaoDAOImpl();
		daoPedido.inserirPedidoDoacao(pedido);
		

		PropostaDoacao proposta = new PropostaDoacao(StatusProposta.ANALISE, doador, LocalDate.of(2022, 10, 10), pedido);
		
		daoUsuario.inserirUsuario(doador);
		PropostaDoacaoDAO daoProposta = new PropostaDoacaoDAOImpl();
		daoProposta.inserirPropostaDoacao(proposta);
		
		

 
		
	}
}