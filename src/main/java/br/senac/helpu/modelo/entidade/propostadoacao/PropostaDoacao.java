package br.senac.helpu.modelo.entidade.propostadoacao;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.doador.Doador;
import br.senac.helpu.modelo.entidade.item.Item;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.enumeracao.proposta.StatusProposta;

@Entity
@Table(name = "proposta_doacao")

public class PropostaDoacao implements Serializable {

	private static final long serialVersionUID = 2158729290494590333L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proposta_doacao")
	private Long id;

	@Enumerated(EnumType.STRING)
	private StatusProposta statusProposta;

	@Column(name = "data_proposta", length = 10, nullable = false, unique = false)
	private LocalDate dataCriacao;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "propostaDoacao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Item> itens;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_doador")
	private Doador doador;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido_doacao", nullable = false)
	private PedidoDoacao pedidoDoacao;

	public PropostaDoacao() {
	}

	public PropostaDoacao(StatusProposta statusProposta, Doador doador, LocalDate dataCriacao) {
		setId(id);
		setStatusProposta(statusProposta);
		setDoador(doador);
		setDataCriacao(dataCriacao);
		itens = new ArrayList<>();
	}

	public PropostaDoacao(StatusProposta statusProposta, Doador doador, LocalDate dataCriacao, PedidoDoacao pedido) {
		setId(id);
		setStatusProposta(statusProposta);
		setDataCriacao(dataCriacao);
		setDoador(doador);
		setPedidoDoacao(pedido);
		itens = new ArrayList<>();
	}

	public PropostaDoacao(Long id, StatusProposta statusProposta, LocalDate dataCriacao, Doador doador) {
		setId(id);
		setStatusProposta(statusProposta);
		setDataCriacao(dataCriacao);
		setDoador(doador);
		itens = new ArrayList<>();
		;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusProposta getStatusProposta() {
		return statusProposta;
	}

	public void setStatusProposta(StatusProposta statusProposta) {
		this.statusProposta = statusProposta;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void addItem(Item item) {
		itens.add(item);
	}

	public void removeItem(Item item) {
		itens.remove(item);
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public PedidoDoacao getPedidoDoacao() {
		return pedidoDoacao;
	}

	public void setPedidoDoacao(PedidoDoacao pedidoDoacao) {
		this.pedidoDoacao = pedidoDoacao;
	}
}