package br.senac.helpu.modelo.dao.ong;
import java.util.List;

import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.entidade.ong.Ong;
public interface OngDAO {
	Ong recuperarOngPeloNome(String nome);
	Ong recuperarOngId(Long id);
	Ong recuperarOng(Ong ong);
	List<Ong> recuperarListaOng();
	List<Endereco>recuperarListaEnderecos(Ong ong);
	Ong recuperarOngPorIdFetch(Long id);
	
}