package br.senac.helpu.modelo.entidade.pedidodoacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.senac.helpu.modelo.entidade.item.Item;
import br.senac.helpu.modelo.enumeracao.statuspedido.StatusPedido;

public class PedidoDoacao implements Serializable {

	private static final long serialVersionUID = 5828763779674937613L;

	private long id;
	private String titulo;
	private String descricao;
	private StatusPedido statusPedido;
	private List<Item> itens;

	public PedidoDoacao(long id, String titulo, String descricao, StatusPedido statusPedido) {
		setId(id);
		setTitulo(titulo);
		setDescricao(descricao);
		setStatusPedido(statusPedido);
		itens = new ArrayList<>();
	}

	public PedidoDoacao(String titulo, String descricao, StatusPedido statusPedido) {
		setTitulo(titulo);
		setDescricao(descricao);
		setStatusPedido(statusPedido);
		itens = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public void addItem(Item item) {
		itens.add(item);
	}

	public void removeItem(Item item) {
		itens.remove(item);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
