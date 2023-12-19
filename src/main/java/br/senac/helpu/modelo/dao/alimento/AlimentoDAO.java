package br.senac.helpu.modelo.dao.alimento;

import java.util.List;

import br.senac.helpu.modelo.entidade.alimento.Alimento;

public interface AlimentoDAO {

	void inserirAlimento(Alimento alimento);

	void deletarAlimento(Alimento alimento);

	void atualizarAlimento(Alimento alimento);
	
	List<Alimento> recuperarAlimentos();

}
