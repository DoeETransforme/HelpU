package br.senac.helpu.modelo.dao.pedidodoacao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import br.senac.helpu.modelo.entidade.alimento.Alimento;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.enumeracao.pedido.StatusPedido;

public interface PedidoDoacaoDAO {

	void inserirPedidoDoacao(PedidoDoacao pedidoDoacao);

	void deletarPedidoDoacao(PedidoDoacao pedidoDoacao);

	void atualizarPedidoDoacao(PedidoDoacao pedidoDoacao);

	PedidoDoacao recuperarPedidoDoacaoId(Long id);

	List<PedidoDoacao> recuperarPedidosDoacao();
	
	List<PedidoDoacao> recuperarPedidosDoacaoOng();
	
	List<PedidoDoacao> recuperarPedidosDoacaoLimitTrace();

	List<PedidoDoacao> recuperarPedidoDoacaoOng(Ong ong);

	List<PedidoDoacao> recuperarPedidoDoacaoStatus(StatusPedido status);

	List<PedidoDoacao> recuperarPedidoDoacaoOngAlimento(Ong ong, Alimento alimento);

	List<PedidoDoacao> recuperarPedidoDoacaoOngStatus(Ong ong, StatusPedido status);

	List<PedidoDoacao> recuperarPedidoDoacaoOngStatusIntervalo(Ong ong, StatusPedido status, LocalDate datainicial,
			LocalDate datafinal);

	List<PedidoDoacao> filtrarPedidos(Optional<StatusPedido> status, Optional<String> nome,
			Optional<LocalDate> dataInicial, Optional<LocalDate> dataFinal, Optional<Alimento> alimento);
}
