package br.senac.helpu.modelo.entidade.conquista;
 
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.doador.Doador;
import br.senac.helpu.modelo.entidade.foto.Foto;
 
@Entity
@Table(name = "Conquista")
public class Conquista implements Serializable {
 
	private static final long serialVersionUID = 764389677409877845L;
 
	@Id
	@GeneratedValue
	@Column(name = "id_conquista")
	private Long id;
 
	@Column(name = "nome_conquista", length = 30, nullable = false, unique = true)
	private String nome;
 
	@Column(name = "descricao_conquista", length = 150, nullable = false, unique = true)
	private String descricao;
 
	@ManyToMany(mappedBy = "conquistas")
	private List<Doador> doadores;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Foto foto;
 
	

	public Conquista() {
	}
 
	public Conquista(String nome, String descricao, Foto foto) {
		setNome(nome);
		setDescricao(descricao);
		setFoto(foto);
 
	}
 
	public Conquista(Long id, String nome, String descricao, Foto foto) {
		setId(id);
		setNome(nome);
		setDescricao(descricao);
		setFoto(foto);
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
	
	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}
 
 
}
