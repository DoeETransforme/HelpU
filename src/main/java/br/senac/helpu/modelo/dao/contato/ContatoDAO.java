package br.senac.helpu.modelo.dao.contato;

import java.util.List;

import br.senac.helpu.modelo.entidade.contato.Contato;
import br.senac.helpu.modelo.entidade.usuario.Usuario;

public interface ContatoDAO {

	void inserirContato(Contato contato);
	
	void deletarContato(Contato contato);
	
	void atualizarContato(Contato contato);
	
	List<Contato>recuperarListaContatos();
	Contato recuperarContatoUsuario(Usuario usuario);
	
	Contato recuperarContatoId(Long id);
	
	
}
