package br.senac.helpu.modelo.entidade.propostadoacao;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.doador.Doador;
import br.senac.helpu.modelo.entidade.item.Item;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doador", nullable = false)
    private Doador doador;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propostaDoacao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Item> itens;

	public PropostaDoacao() {}
	
	
	public PropostaDoacao(Long id, StatusProposta statusProposta) {
		setId(id);
		setStatusProposta(statusProposta);
		itens = new ArrayList<>();
	}
	public PropostaDoacao( StatusProposta statusProposta) {
		setStatusProposta(statusProposta);
		itens = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public StatusProposta getStatusProposta() {
		return statusProposta;
	}

	public void setStatusProposta(StatusProposta statusProposta) {
		this.statusProposta = statusProposta;
	}

	

}