package br.senac.helpu.modelo.dao.contato;

import br.senac.helpu.modelo.entidade.contato.Contato;

public interface ContatoDAO {

	void inserirContato(Contato contato);
	
	void deletarContato(Contato contato);
	
	void atualizarContato(Contato contato);
	
	
}
