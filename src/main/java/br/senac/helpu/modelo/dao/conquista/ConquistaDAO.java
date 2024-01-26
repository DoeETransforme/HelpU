package br.senac.helpu.modelo.dao.conquista;

import java.util.List;

import br.senac.helpu.modelo.entidade.conquista.Conquista;
import br.senac.helpu.modelo.entidade.doador.Doador;

public interface ConquistaDAO {
		
		void inserirConquista (Conquista conquista);
		void deletarConquista (Conquista conquista);
		void atualizarConquista (Conquista conquista);
		
		List<Conquista> recuperarConquistas();
		List<Conquista> recuperarConquistasPorDoador(Doador doador);
		Conquista recuperarConquistaPorNome(String nome);
		
	 
}
