package br.senac.helpu.modelo.dao.propostadoacao;
 
 
import java.time.LocalDate;
import java.util.List;



import br.senac.helpu.modelo.entidade.alimento.Alimento;
import br.senac.helpu.modelo.entidade.doador.Doador;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;
import br.senac.helpu.modelo.enumeracao.statusproposta.StatusProposta;
 
public interface PropostaDoacaoDAO {
	
	void inserirPropostaDoacao(PropostaDoacao propostaDoacao);
	void deletarPropostaDoacao(PropostaDoacao propostaDoacao);
	void atualizarPropostaDoacao(PropostaDoacao propostaDoacao);
	
	List<PropostaDoacao> recuperarTodasPropostaDoacao();
	List<PropostaDoacao>recuperarPropostaDoacao(PropostaDoacao propostaDoacao);
	
	List<PropostaDoacao> recuperarPropostaDoacaoOng(Ong ong);
	List<PropostaDoacao> recuperarPropostaDoacaoOngStatus(Ong ong, StatusProposta statusProposta);
	List<PropostaDoacao> recuperarTodasPropostaDoacaoOngAlimento(Ong ong , Alimento alimento);
	List<PropostaDoacao> recuperarTodasPropostaDoacaoOngAlimentoData(Ong ong , Alimento alimento, LocalDate dataInicial, LocalDate datafinal);
	List<PropostaDoacao> recuperarTodasPropostaDoacaoDoador(Doador doador);
	List<PropostaDoacao> recuperarTodasPropostaDoacaoDoadorStatus(Doador doador, StatusProposta statusProposta);
	List<PropostaDoacao> recuperarTodasPropostaDoacaoDoadorStatusData(Doador doador, StatusProposta statusProposta,  LocalDate dataInicial, LocalDate datafinal);
	
 
	List<PropostaDoacao>recuperarTodasPropostaDoacaoAlimento(Alimento alimento);
	
 
	
	
	//List<PropostaDoacao> filtrarBuscaPropostaDoacao(Optional<> especiePet, Optional<PortePet> portePet,
			//Optional<SexoPet> sexoPet, Optional<PelagemPet> pelagemPet, Optional<EstadoPet> estadoPet);
	
	//List<PropostaDoacao> filtrarPetsEstado(Optional<EstadoPet> estadoPet, Ong ong);
	
	PropostaDoacao recuperarPropostaDoacao(Long id);
	
 
 
}
	