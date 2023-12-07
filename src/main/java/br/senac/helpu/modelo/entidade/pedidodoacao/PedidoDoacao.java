package br.senac.helpu.modelo.entidade.pedidodoacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.Item.Item;
import br.senac.helpu.modelo.enumeracao.statuspedido.StatusPedido;

@Entity
@Table( name = "pedidoDoacao" )

public class PedidoDoacao implements Serializable {

	private static final long serialVersionUID = 5828763779674937613L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedidoDoacao")
	private long id;
	
	@Column(name = "titulo", length = 25, nullable = false)
	private String titulo;
	
	@Column(name = "descricao", length =150, nullable = true)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "StatusPedido", length = 50 , nullable = true)
	private StatusPedido statusPedido;
	
	@OneToMany(fetch= FetchType.LAZY, mappedBy = "propostaDoacao", cascade = CascadeType.ALL, orphanRemoval = true)
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
