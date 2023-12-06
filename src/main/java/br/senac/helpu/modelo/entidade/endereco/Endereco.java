package br.senac.helpu.modelo.entidade.endereco;

import java.io.Serializable;

public class Endereco implements Serializable {
	
	private static final long serialVersionUID = -7731215238349813452L;
	
	private Long id;	
	private String logradouro;	
	private String bairro;	
	private String complemento;	
	private int numero;	
	private String cidade;	
	private String unidadeFederativa;	
	private String cep;
	
	public Endereco(Long id, String logradouro, String bairro, String complemento, int numero, String cidade,
			String unidadeFederativa, String cep) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.complemento = complemento;
		this.numero = numero;
		this.cidade = cidade;
		this.unidadeFederativa = unidadeFederativa;
		this.cep = cep;
	}

	public Endereco(String logradouro, String bairro, String complemento, int numero, String cidade,
			String unidadeFederativa, String cep) {
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.complemento = complemento;
		this.numero = numero;
		this.cidade = cidade;
		this.unidadeFederativa = unidadeFederativa;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUnidadeFederativa() {
		return unidadeFederativa;
	}

	public void setUnidadeFederativa(String unidadeFederativa) {
		this.unidadeFederativa = unidadeFederativa;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}
