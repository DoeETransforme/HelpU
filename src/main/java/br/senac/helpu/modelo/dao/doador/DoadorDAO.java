package br.senac.helpu.modelo.dao.doador;

import java.util.List;

import br.senac.helpu.modelo.entidade.doador.Doador;

public interface DoadorDAO {
 
	void inserirDoador(Doador doador);
	
	void deletarDoador(Doador doador);
	
	void atualizarDoador(Doador doador);
	
	List<Doador> recuperarDoadorPeloNome(String nome);
	
	Doador recuperarDoadorId(Long id);
	
	
}