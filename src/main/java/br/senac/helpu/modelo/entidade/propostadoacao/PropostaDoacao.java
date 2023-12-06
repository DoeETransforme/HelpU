package br.senac.helpu.modelo.entidade.propostadoacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.senac.helpu.modelo.entidade.item.Item;
import br.senac.helpu.modelo.enumeracao.statusproposta.StatusProposta;

public class PropostaDoacao implements Serializable{
	
	private static final long serialVersionUID = 2158729290494590333L;
	
	private long id;
	private StatusProposta statusProposta;
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
