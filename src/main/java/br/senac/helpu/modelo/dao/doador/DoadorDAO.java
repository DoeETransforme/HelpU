package br.senac.helpu.modelo.dao.doador;
 
import java.util.List;
 
import br.senac.helpu.modelo.entidade.doador.Doador;
 
public interface DoadorDAO {
	List<Doador>recuperarListaDoadores();
	List<Doador> recuperarDoadorPeloNome(String nome);
	Doador recuperarDoadorId(Long id);
	Doador recuperarDoador(Doador doador);

}