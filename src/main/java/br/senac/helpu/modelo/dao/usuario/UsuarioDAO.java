package br.senac.helpu.modelo.dao.usuario;
<<<<<<< HEAD
 
import java.util.List;
 
=======

import java.util.List;

>>>>>>> e733e1194781c8885f002e75e60f23c7cf501e79
import br.senac.helpu.modelo.entidade.contato.Contato;
import br.senac.helpu.modelo.entidade.usuario.Usuario;
 
public interface UsuarioDAO {
 
	void inserirUsuario(Usuario usuario);
 
	void deletarUsuario(Usuario usuario);
 
	void atualizarUsuario(Usuario usuario);
		
	List<Contato>listaContatos();
}
 