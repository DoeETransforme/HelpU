package br.senac.helpu.modelo.entidade.Ong;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.senac.helpu.modelo.entidade.contato.Contato;
import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.entidade.usuario.Usuario;

public class Ong extends Usuario implements Serializable {

	private static final long serialVersionUID = -2680258071107532867L;

	private String cnpj;
	private Endereco endereco;
	List<PedidoDoacao> pedidos;

	public Ong(long id, String nome, String senha, Contato contato, String cnpj, Endereco endereco) {
		super(id, nome, senha, contato);
		setCnpj(cnpj);
		setEndereco(endereco);
		pedidos = new ArrayList<>();
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

	public void addPedido(PedidoDoacao pedido) {
		pedidos.add(pedido);
	}

	public void removePedido(PedidoDoacao pedido) {
		pedidos.remove(pedido);
	}

}
