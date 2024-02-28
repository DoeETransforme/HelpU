package br.senac.helpu.modelo.entidade.usuario;
 
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.foto.Foto;
import br.senac.helpu.modelo.enumeracao.usuario.StatusUsuario;
 

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {
 
	private static final long serialVersionUID = -8566282827144097443L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;
 
	@Column(name = "nome_usuario", length = 30, nullable = false)
	private String nome;
 
	@Column(name = "senha_usuario", length = 15, nullable = false)
	private String senha;
	
	@Enumerated ( EnumType.STRING)
	private StatusUsuario status;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Foto fotoUsuario;
	
	public Usuario() {
	}
 
	public Usuario(Long id, String nome, String senha, StatusUsuario status) {
		setId(id);
		setNome(nome);
		setSenha(senha);
		setStatus(status);
	}
 
	public Usuario(String nome, String senha, StatusUsuario status) {
		setNome(nome);
		setSenha(senha);
		setStatus(status);
	}
	
	public Usuario(Long id, String nome, String senha, StatusUsuario status, Foto fotoUsuario) {
		setId(id);
		setNome(nome);
		setSenha(senha);
		setStatus(status);
		setFotoUsuario(fotoUsuario);
	}
	
	public Usuario(String nome, String senha, StatusUsuario status, Foto fotoUsuario) {
		setNome(nome);
		setSenha(senha);
		setStatus(status);
		setFotoUsuario(fotoUsuario);
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
 
	public String getSenha() {
		return senha;
	}
 
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public StatusUsuario getStatus() {
		return status;
	}

	public void setStatus(StatusUsuario status) {
		this.status = status;
	}
	
	public Foto getFotoUsuario() {
		return fotoUsuario;
	}

	public void setFotoUsuario(Foto fotoUsuario) {
		this.fotoUsuario = fotoUsuario;
	}
 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}