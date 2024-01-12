package br.senac.helpu;
 
import br.senac.helpu.modelo.dao.contato.ContatoDAO;

import br.senac.helpu.modelo.dao.endereco.EnderecoDAO;
import br.senac.helpu.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAO;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.helpu.modelo.entidade.contato.Contato;
import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.entidade.ong.Ong;
 
public class Main {
	public static void main(String[] args) {
		

	
		Ong ong = new Ong("nomeborwlado", "3rw123123", null ,"cnpjbrwolado");
		
		
		Endereco endereco = new Endereco ("logradourobolado", "bairoobolado", 10 , "CidadeBolada" , "am", "122-21", ong);
		EnderecoDAO daoEndereco = new EnderecoDAOImpl();
		daoEndereco.inserirEndereco(endereco);
		
		

 
		
	}
}