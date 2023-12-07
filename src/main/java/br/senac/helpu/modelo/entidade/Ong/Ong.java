package br.senac.helpu.modelo.entidade.Ong;

import java.io.Serializable;
import java.util.List;

import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.enumeracao.statuspedido.StatusPedido;

public class Ong implements Serializable{

	private int id;
	private String cnpj;
	private Endereco endereco;
	private List<StatusPedido> pedidodoacao;
	private static final long serialVersionUID = -3707751312475379705L;
	
	public Ong(int id, String cnpj, Endereco endereco, List<StatusPedido> pedidodoacao) {
		setId(id);
		setCnpj(cnpj);
		setEndereco(endereco);
		setPedidodoacao(pedidodoacao);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<StatusPedido> getPedidodoacao() {
		return pedidodoacao;
	}
	public void setPedidodoacao(List<StatusPedido> pedidodoacao) {
		this.pedidodoacao = pedidodoacao;
	}

}
