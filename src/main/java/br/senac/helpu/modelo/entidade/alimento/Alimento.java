package br.senac.helpu.modelo.entidade.alimento;

import java.io.Serializable;
import java.time.LocalDate;

public class Alimento implements Serializable{
	
	
	private static final long serialVersionUID = -4895659664756496928L;
	
	private long id;
	private LocalDate dataValidade;
	private float peso;
	private String nome;
	
	
	public Alimento (long id, LocalDate dataValidade, float peso, String nome) {
		
		setId(id);
		setDataValidade(dataValidade);
		setPeso(peso);
		setNome(nome);
		
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String nome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;

	}
}
