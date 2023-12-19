package br.senac.helpu.modelo.entidade.alimento;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "alimento")
public class Alimento implements Serializable {

	private static final long serialVersionUID = -4895659664756496928L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alimento")
	private Long id;
	
	@Column(name = "nome", length = 35, nullable = false)
	private String nome;
	
	@Column(name = "peso", nullable = false)
	private float peso;
	
	@Column(name = "dataValidade", length = 20, nullable = false)
	private LocalDate dataValidade;
	

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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	
}
