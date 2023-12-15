package br.senac.helpu.modelo.dao.usuario;
 
import br.senac.helpu.modelo.entidade.usuario.Usuario;
 
public interface UsuarioDAO {
 
	void inserirUsuario(Usuario usuario);
 
	void deletarUsuario(Usuario usuario);
 
	void atualizarUsuario(Usuario usuario);
		
}
