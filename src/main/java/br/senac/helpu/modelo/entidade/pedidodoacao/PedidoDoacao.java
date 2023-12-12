package br.senac.helpu.modelo.entidade.pedidodoacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.item.Item;
import br.senac.helpu.modelo.enumeracao.statuspedido.StatusPedido;
@Entity
@Table(name = "pedido_doacao")
public class PedidoDoacao implements Serializable {

	private static final long serialVersionUID = 5828763779674937613L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido_doacao")
	private long id;
	
	@Column(name = "titulo_pedido_doacao", length = 45, nullable = false, unique = false)
	private String titulo;
	
	@Column(name = "descricao_pedido_doacao", length = 150, nullable = false, unique = false)
	private String descricao;
	
	@OneToMany(mappedBy = "pedido_doacao")
	private List<Item> itens;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "id_status_Pedido")
	@Enumerated ( EnumType.STRING)
	@Column(name = "status_pedido", length = 30, nullable = false, unique = false)
	private StatusPedido statuspedido;

	public PedidoDoacao() {}
	
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
		return this.statuspedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statuspedido = statusPedido;
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
