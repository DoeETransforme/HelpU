package br.senac.helpu.modelo.entidade.alimento;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.item.Item;

@Entity
@Table(name = "alimento")
public class Alimento implements Serializable {

	private static final long serialVersionUID = -4895659664756496928L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alimento")
	private Long id;
	
	@Column(name = "data_validade_alimento", length = 20, nullable = false)
	private LocalDate dataValidade;
	
	@Column(name = "peso_alimento", nullable = false)
	private float peso;
	
	@Column(name = "nome_alimento", length = 35, nullable = false)
	private String nome;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_item", nullable = false)
	private Item itens;
	
	public Alimento() {}

	public Alimento(LocalDate dataValidade, float peso, String nome) {
		setDataValidade(dataValidade);
		setPeso(peso);
		setNome(nome);

	}
	
	public Alimento(Long id, LocalDate dataValidade, float peso, String nome) {
		setId(id);
		setDataValidade(dataValidade);
		setPeso(peso);
		setNome(nome);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public void setNome(String nome) {
		this.nome = nome;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
