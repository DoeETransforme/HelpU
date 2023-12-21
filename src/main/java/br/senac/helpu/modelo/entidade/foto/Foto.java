package br.senac.helpu.modelo.entidade.foto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

public class Foto implements Serializable {
	private static final long serialVersionUID = -5786556278275043519L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_foto", nullable = false, unique = true)
	private Long id;

	@Lob
	@Column(name = "binario_foto", nullable = false, unique = true)
	private Byte[] binario;

	@Column(name = "extensao_foto", nullable = false, unique = true)
	private String extensao;

	public Foto() {}
	
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

}