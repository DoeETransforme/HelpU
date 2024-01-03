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
	
	@Column(name = "nome_alimento", length = 35, nullable = false)
	private String nome;
	
	@Column(name = "unidade_alimento", nullable = false)
	private float unidadeAlimento;
	
	@Column(name = "data_validade_alimento", length = 20, nullable = false)
	private LocalDate dataValidade;
	

	public Alimento() {}

	public Alimento(LocalDate dataValidade, float unidadeAlimento, String nome) {
		setDataValidade(dataValidade);
		setUnidadeAlimento(unidadeAlimento);
		setNome(nome);

	}
	
	public Alimento(Long id, LocalDate dataValidade, float unidadeAlimento, String nome) {
		setId(id);
		setDataValidade(dataValidade);
		setUnidadeAlimento(unidadeAlimento);
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
	
	public float getUnidadeAlimento() {
		return unidadeAlimento;
	}

	public void setUnidadeAlimento(float unidadeAlimento) {
		this.unidadeAlimento = unidadeAlimento;
	}
	
	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	
}
