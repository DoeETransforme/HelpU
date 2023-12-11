package br.senac.helpu.modelo.entidade.propostadoacao;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.Item.Item;
import br.senac.helpu.modelo.enumeracao.statusproposta.StatusProposta;


@Entity
@Table(name = "proposta_doacao")

public class PropostaDoacao implements Serializable{
	
	private static final long serialVersionUID = 2158729290494590333L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proposta_doacao")
	private long id;
	
	
	@Enumerated ( EnumType.STRING)
	@Column(name = "status_proposta", length = 30, nullable = false, unique = false)
	private StatusProposta statusProposta;
	
	@OneToMany(mappedBy = "proposta_doacao")
	private List<Item> itens;
	
	public PropostaDoacao(long id, StatusProposta statusProposta) {
		setId(id);
		setStatusProposta(statusProposta);
		itens = new ArrayList<>();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
}
