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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.alimento.Alimento;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;

@Entity
@Table(name = "item")

public class Item implements Serializable {

	private static final long serialVersionUID = -4650927518777774993L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Long id;

	@Column(name = "quantidade_item", nullable = false)
	private int quantidade;
	
	@OneToMany(fetch = FetchType.LAZY)
	@MapsId("id_alimento")
	private List<Alimento> alimentos;	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proposta_doacao")
    private PropostaDoacao propostaDoacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido_doacao")
	private PedidoDoacao pedidosDoacao;

	public Item() {}

	public Item(Long id, int quantidade) {
		setId(id);
		setQuantidade(quantidade);
		alimentos = new ArrayList<>();
	}

	public Item(int quantidade) {
		setQuantidade(quantidade);
		alimentos = new ArrayList<>();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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