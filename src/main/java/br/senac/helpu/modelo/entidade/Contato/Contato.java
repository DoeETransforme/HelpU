package br.senac.helpu.modelo.entidade.Contato;

import java.io.Serializable;
 
public class Contato implements Serializable{

	private static final long serialVersionUID = 8094576640471907006L;
	private String email;
	private String celular;
	private int idcontato;
	
	
	public Contato (String celular, String email, int idcontato) {
		setCelular(celular);
		setEmail(email);
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

	public int getIdcontato() {
		return idcontato;
	}

	public void setIdcontato(int idcontato) {
		this.idcontato = idcontato;
	}
}