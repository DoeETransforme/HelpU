package br.senac.helpu.modelo.entidade.foto;

import java.io.Serializable;

public class Foto implements Serializable {
	private static final long serialVersionUID = -5786556278275043519L;

	private Long id;
	private Byte[] binario;
	private String extensao;

	public Foto(Long id, Byte[] binario, String extensao) {
		setId(id);
		setBinario(binario);
		setExtensao(extensao);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte[] getBinario() {
		return binario;
	}

	public void setBinario(Byte[] binario) {
		this.binario = binario;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
