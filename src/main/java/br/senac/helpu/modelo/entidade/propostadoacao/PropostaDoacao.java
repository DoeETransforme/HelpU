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
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.enumeracao.statusproposta.StatusProposta;

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
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_ong", nullable = false)
//	@Column(name = "ong", length = 45, nullable = false)
//	private Ong ong;

	@Column(name = "data_proposta", length = 10, nullable = false, unique = false)
	private LocalDate dataCriacao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propostaDoacao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Item> itens;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_doador")
	private Doador doador;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido_doacao", nullable = false)
	private PedidoDoacao pedidoDoacao;

	

	public PropostaDoacao() {}

	public PropostaDoacao(StatusProposta statusProposta, Doador doador, LocalDate dataCriacao, Ong ong) {
	    setId(id);
	    setStatusProposta(statusProposta);
	    setDoador(doador);
	    setDataCriacao(dataCriacao);
	  
//	    setOng(ong);
	}
	public PropostaDoacao(StatusProposta statusProposta, Doador doador, LocalDate dataCriacao, Ong ong, PedidoDoacao pedido) {
	    setId(id);
	    setStatusProposta(statusProposta);
	    //this.dataCriacao = dataCriacao != null ? dataCriacao : LocalDate.now(); 
	    setDataCriacao(dataCriacao);
	    setDoador(doador);
	 
//	    setOng(ong);
	    setPedidoDoacao(pedido);
	}
	public PropostaDoacao(StatusProposta statusProposta, Doador doador, LocalDate dataCriacao, PedidoDoacao pedido) {
	    setId(id);
	    setStatusProposta(statusProposta);
	    setDataCriacao(dataCriacao);
	    setDoador(doador);
	    setPedidoDoacao(pedido);
	}

	public PropostaDoacao(Long id, StatusProposta statusProposta, LocalDate dataCriacao, Doador doador) {
		setId(id);
		setStatusProposta(statusProposta);
		setDataCriacao(dataCriacao);
	    setDoador(doador);
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

	public void addItem(Item item) {
		itens.add(item);
	}

	public void removeItem(Item item) {
		itens.remove(item);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

//	public Ong getOng() {
//		return ong;
//	}
//
//
//	public void setOng(Ong ong) {
//		this.ong = ong;
//	}

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

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public PedidoDoacao getPedidoDoacao() {
		return pedidoDoacao;
	}

	public void setPedidoDoacao(PedidoDoacao pedidoDoacao) {
		this.pedidoDoacao = pedidoDoacao;
	}
}