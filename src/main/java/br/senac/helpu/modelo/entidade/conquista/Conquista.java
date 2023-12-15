package br.senac.helpu.modelo.entidade.conquista;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Conquista")
public class Conquista implements Serializable {

	private static final long serialVersionUID = 764389677409877845L;

	@Id
	@GeneratedValue
	@Column(name = "id_conquista")
	private Long id;

	@Column (name = "nome_conquista", length = 30, nullable = false, unique = true)
	private String nome;

	@Column(name = "descricao_conquista", length = 150, nullable = false, unique = true)
	private String descricao;

	public Conquista() {
	}

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