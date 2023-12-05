package br.senac.helpu.modelo.entidade.usuario;

import java.io.Serializable;

import br.senac.helpu.modelo.entidade.Contato.Contato;

public class Usuario implements Serializable {

	private static final long serialVersionUID = -8566282827144097443L;

	private long id;
	private String nome;
	private String senha;
	private Contato contato;

	public Usuario(String nome, String senha, Contato contato) {

		setNome(nome);
		setSenha(senha);
		setContato(contato);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
