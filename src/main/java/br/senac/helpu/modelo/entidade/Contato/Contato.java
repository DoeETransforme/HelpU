package br.senac.helpu.modelo.entidade.Contato;

import java.io.Serializable;
 
public class Contato implements Serializable{

	private static final long serialVersionUID = 8094576640471907006L;
	private String email;
	private String celular;
	private Long id;
	
	
	public Contato (String celular, String email, Long id) {
		setCelular(celular);
		setEmail(email);
		setId(id);
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}