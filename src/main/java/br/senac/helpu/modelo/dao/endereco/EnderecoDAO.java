package br.senac.helpu.modelo.dao.endereco;

import java.util.List;

import br.senac.helpu.modelo.entidade.endereco.Endereco;

public interface EnderecoDAO {
	void inserirEndereco(Endereco endereco);
	 
	void deletarEndereco(Endereco endereco);
 
	void atualizarEndereco(Endereco endereco);
	
	Endereco recuperarEnderecoId(Long id);

}
