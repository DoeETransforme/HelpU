package br.senac.helpu.modelo.entidade.contato;
 
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
import br.senac.helpu.modelo.entidade.usuario.Usuario;
 
@Entity
@Table(name = "contato")
public class Contato implements Serializable {
	
	private static final long serialVersionUID = 8094576640471907006L;
	
	@Id
	private Long id;
	
	@Column(name = "email_contato", length = 65, unique = true, nullable = false)
	private String email;
	
	@Column(name = "celular_contato", length = 16, unique = true, nullable = false)
	private String celular;
 
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	public Contato() {}
	
	public Contato(String celular, String email, Usuario usuario) {
		setCelular(celular);
		setEmail(email);
		setUsuario(usuario);
	}
		
	public Contato(Long id, String celular, String email, Usuario usuario) {
		setId(id);
		setCelular(celular);
		setEmail(email);
		setUsuario(usuario);
	}
 
	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
 
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
	public String getCelular() {
		return celular;
	}
 
	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}