package br.senac.helpu.modelo.entidade.item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.senac.helpu.modelo.entidade.alimento.Alimento;

public class Item implements Serializable {

	private static final long serialVersionUID = -4650927518777774993L;

	private Long id;
	private int quantidade;
	private List<Alimento> alimentos;

	public Item(Long id, int quantidade) {
		setId(id);
		setQuantidade(quantidade);
		alimentos = new ArrayList<>();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Item(int quantidade) {
		setQuantidade(quantidade);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void addAlimento(Alimento alimento) {
		alimentos.add(alimento);
	}

	public void removeAlimento(Alimento alimento) {
		alimentos.remove(alimento);
	}
}