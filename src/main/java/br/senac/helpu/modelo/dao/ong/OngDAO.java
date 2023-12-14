package br.senac.helpu.modelo.dao.ong;
 
import br.senac.helpu.modelo.entidade.ong.Ong;
 
public interface OngDAO {
	
	void inserirOng(Ong ong);
	
	void deletarOng(Ong ong);
	
	void atualizarOng(Ong ong);
	
	Ong recuperarOngNome(String nome);
	
	Ong recuperarOngId(Long id);
	
	Ong recuperarOng(Ong ong);
}