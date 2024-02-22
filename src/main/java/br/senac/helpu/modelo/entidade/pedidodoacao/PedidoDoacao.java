package br.senac.helpu.modelo.entidade.pedidodoacao;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.foto.Foto;
import br.senac.helpu.modelo.entidade.item.Item;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;
import br.senac.helpu.modelo.enumeracao.pedido.StatusPedido;

@Entity
@Table(name = "pedido_doacao")
public class PedidoDoacao implements Serializable {

	private static final long serialVersionUID = 5828763779674937613L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido_doacao")
	private Long id;
	
	@Column(name = "titulo_pedido_doacao", length = 45, nullable = false, unique = false)
	private String titulo;
	
	@Column(name = "descricao_pedido_doacao", length = 150, nullable = false, unique = false)
	private String descricao;
	
	@Column(name = "data_pedido_doacao", length = 10, nullable = false, unique = false)
	private LocalDate data;
	
	@Enumerated ( EnumType.STRING)
	private StatusPedido statuspedido;
	
	@Column(name = "meta_doacoes", nullable = true)
	private int metaDoacoes;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Foto foto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ong", nullable = false, unique = false)
	private Ong ong;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedidoDoacao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Item> itens;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedidoDoacao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PropostaDoacao> propostasDoacao;
	
	public PedidoDoacao() {}
	
	public PedidoDoacao(Long id, String titulo, String descricao, LocalDate data, StatusPedido statusPedido, int metaDoacoes, Ong ong) {
		setId(id);
		setData(data);
		setTitulo(titulo);
		setDescricao(descricao);	
		setStatusPedido(statusPedido);
		setMetaDoacoes(metaDoacoes);
		setOng(ong);
	}

	public PedidoDoacao(String titulo, String descricao, LocalDate data, StatusPedido statusPedido, int metaDoacoes, Ong ong) {
		setData(data);
		setTitulo(titulo);
		setDescricao(descricao);
		setStatusPedido(statusPedido);
		setMetaDoacoes(metaDoacoes);
		setOng(ong);
	}
	
	public PedidoDoacao(String titulo, String descricao, LocalDate data, StatusPedido statusPedido, int metaDoacoes, Ong ong, Foto foto) {
		setData(data);
		setTitulo(titulo);
		setDescricao(descricao);
		setStatusPedido(statusPedido);
		setMetaDoacoes(metaDoacoes);
		setOng(ong);
		setFoto(foto);
	}
	
	public PedidoDoacao(String titulo, String descricao, LocalDate data, StatusPedido statusPedido, Ong ong) {
		setData(data);
		setTitulo(titulo);
		setDescricao(descricao);
		setStatusPedido(statusPedido);
		setOng(ong);
	}
	
	public PedidoDoacao(String titulo, String descricao, LocalDate data, StatusPedido statusPedido, Ong ong, Foto foto) {
		setData(data);
		setTitulo(titulo);
		setDescricao(descricao);
		setStatusPedido(statusPedido);
		setOng(ong);
		setFoto(foto);
	}
	
	public PedidoDoacao(String titulo, String descricao, LocalDate data, StatusPedido statusPedido) {
		setData(data);
		setTitulo(titulo);
		setDescricao(descricao);
		setStatusPedido(statusPedido);
	}
	
	public PedidoDoacao(String titulo, String descricao, LocalDate data, StatusPedido statusPedido, Foto foto) {
		setData(data);
		setTitulo(titulo);
		setDescricao(descricao);
		setStatusPedido(statusPedido);
		setFoto(foto);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
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
	
	public Ong getOng() {
		return ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
	}

	public StatusPedido getStatusPedido() {
		return statuspedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statuspedido = statusPedido;
	}

	public int getMetaDoacoes() {
		return metaDoacoes;
	}

	public void setMetaDoacoes(int metaDoacoes) {
		this.metaDoacoes = metaDoacoes;
	}
	
	public void addItem(Item item) {
		itens.add(item);
	}
	
	public void removeItem(Item item) {
		itens.remove(item);
	}
	
	public void addPropostaDoacao(PropostaDoacao proposta) {
		propostasDoacao.add(proposta);
	}
	
	public void removePropostaDoacao(PropostaDoacao proposta) {
		propostasDoacao.remove(proposta);
	}
	
	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}
}
