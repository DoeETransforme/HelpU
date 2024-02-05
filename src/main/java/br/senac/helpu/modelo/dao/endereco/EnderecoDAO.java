package br.senac.helpu.modelo.dao.endereco;

import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.entidade.ong.Ong;

public interface EnderecoDAO {
	void inserirEndereco(Endereco endereco);
	 
	void deletarEndereco(Endereco endereco);
 
	void atualizarEndereco(Endereco endereco);
	
	Endereco recuperarEnderecoId(Long id);
	Endereco RecuperarEnderecoPorOng( Ong ong);

}
