package br.senac.helpu.modelo.dao.pedidodoacao;

import java.time.LocalDate;
import java.util.List;

import br.senac.helpu.modelo.entidade.alimento.Alimento;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.enumeracao.statuspedido.StatusPedido;

public interface PedidoDoacaoDAO {

	void inserirPedidoDoacao(PedidoDoacao pedidoDoacao);

	void deletarPedidoDoacao(PedidoDoacao pedidoDoacao);

	void atualizarPedidoDoacao(PedidoDoacao pedidoDoacao);

	List<PedidoDoacao> recuperarPedidoDoacaoOng(Ong ong);

	List<PedidoDoacao> recuperarPedidoDoacaoOngAlimento(Ong ong, Alimento alimento);

	List<PedidoDoacao> recuperarPedidoDoacaoOngStatus(Ong ong, StatusPedido status);

	List<PedidoDoacao> recuperarPedidoDoacaoOngStatusIntervalo(Ong ong, StatusPedido status,LocalDate datainicial, LocalDate datafinal);
}
