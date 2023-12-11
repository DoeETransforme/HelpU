package br.senac.helpu.modelo.entidade.item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.alimento.Alimento;
@Entity
@Table(name = "item")

public class Item implements Serializable {

	private static final long serialVersionUID = -4650927518777774993L;

	private static final String Generationtype = null;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Long id;
	@Column(name = "quantidade_pedido", nullable = false)
	private int quantidade;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "alimento", cascade = CascadeType.ALL, orphanRemoval = true)
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