package br.senac.helpu.modelo.dao.alimento;

import br.senac.helpu.modelo.entidade.alimento.Alimento;

public interface AlimentoDAO {

	 void inserirAlimento (Alimento alimento);
		
	void deletarAlimento (Alimento alimento);

	void atualizarAlimento (Alimento alimento);
	
}
