package br.senac.helpu.modelo.entidade.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.Contato.Contato;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -8566282827144097443L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private long id;
	
	@Column(name = "nome_usuario", length = 30, nullable = false, unique = true)
	private String nome;
	
	@Column(name = "senha_usuario", length = 15, nullable = false)
	private String senha;
	
	@Column(name = "contato_usuario", nullable = false)
	private Contato contato;
	
	public Usuario() {}
	
	public Usuario(long id, String nome, String senha, Contato contato) {
		setId(id);
		setNome(nome);
		setSenha(senha);
		setContato(contato);
	}
	
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
