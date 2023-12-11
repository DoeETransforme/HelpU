package br.senac.helpu.modelo.entidade.Ong;

import java.io.Serializable;
import java.util.List;

import br.senac.helpu.modelo.entidade.Contato.Contato;
import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.entidade.usuario.Usuario;

public class Ong extends Usuario implements Serializable {

	private String cnpj;
	private Endereco endereco;
	List<PedidoDoacao> pedidos;

	public Ong(long id, String nome, String senha, Contato contato, String cnpj, Endereco endereco) {
		super(id, nome, senha, contato);
		this.cnpj = cnpj;
		this.endereco = endereco;
	
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
	
	
	
}
