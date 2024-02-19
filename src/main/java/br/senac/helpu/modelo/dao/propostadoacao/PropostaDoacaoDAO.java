package br.senac.helpu.modelo.dao.propostadoacao;

import java.time.LocalDate;
import java.util.List;

import br.senac.helpu.modelo.entidade.alimento.Alimento;
import br.senac.helpu.modelo.entidade.doador.Doador;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;
import br.senac.helpu.modelo.enumeracao.proposta.StatusProposta;

public interface PropostaDoacaoDAO {
	void inserirPropostaDoacao(PropostaDoacao propostaDoacao);

	void deletarPropostaDoacao(PropostaDoacao propostaDoacao);

	void atualizarPropostaDoacao(PropostaDoacao propostaDoacao);

	List<PropostaDoacao> recuperarTodasPropostaDoacao();
	
	PropostaDoacao recuperarPropostaDoacaoId(Long id);
	
	PropostaDoacao recuperarPropostaDoacaoContatoId(Long id);

	List<PropostaDoacao> recuperarPropostaDoacaoOng(Ong ong);

	List<PropostaDoacao> recuperarPropostaDoacaoStatus(StatusProposta status);

	int recuperarQuantidadePropostaDoacaoStatusOng(StatusProposta status, Ong ong);

	List<PropostaDoacao> recuperarTodasPropostaDoacaoAlimento(Alimento alimento);

	List<PropostaDoacao> recuperarTodasPropostaDoacaoDoador(Doador doador);
	
	List<PropostaDoacao> recuperarPropostaDoacaoDoador(Doador doador);
	
	List<PropostaDoacao> recuperarTodasPropostaDoacaoOngAlimento(Ong ong, Alimento alimento);

	List<PropostaDoacao> recuperarPropostaDoacaoOngStatus(Ong ong, StatusProposta statusProposta);

	List<PropostaDoacao> recuperarTodasPropostaDoacaoDoadorStatus(Doador doador, StatusProposta statusProposta);

	List<PropostaDoacao> recuperarTodasPropostaDoacaoOngAlimentoData(Ong ong, Alimento alimento, LocalDate dataInicial,
			LocalDate dataFinal);

	List<PropostaDoacao> recuperarTodasPropostaDoacaoDoadorStatusData(Doador doador, StatusProposta statusProposta,
			LocalDate dataInicial, LocalDate datafinal);

    List<PropostaDoacao> recuperarTodasPropostaDoacaoOngStatusFetch(Ong ong, StatusProposta statusProposta);
    
    List<PropostaDoacao> recuperarTodasPropostaDoacaoDoadorStatusLimitTrace(Doador doador, StatusProposta statusProposta);
    
    List<PropostaDoacao> recuperarTodasPropostaDoacaoPedido(PedidoDoacao pedido);

}