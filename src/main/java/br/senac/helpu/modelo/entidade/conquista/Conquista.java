package br.senac.helpu.modelo.entidade.conquista;

import java.io.Serializable;

public class Conquista implements Serializable {

	private static final long serialVersionUID = 764389677409877845L;

	private Long id;
	private String nome;
	private String descricao;

	public Conquista(Long id, String nome, String descricao) {
		setId(id);
		setNome(nome);
		setDescricao(descricao);
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}