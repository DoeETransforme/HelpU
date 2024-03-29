package br.senac.helpu.modelo.entidade.doador;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.conquista.Conquista;
import br.senac.helpu.modelo.entidade.foto.Foto;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;
import br.senac.helpu.modelo.entidade.usuario.Usuario;
import br.senac.helpu.modelo.enumeracao.usuario.StatusUsuario;

@Entity
@Table(name = "doador")
public class Doador extends Usuario implements Serializable {

	private static final long serialVersionUID = 5246756539851329248L;

	@Column(name = "cpf_doador", length = 14, nullable = false, unique = true)
	private String cpf;

	@Column(name = "data_nascimento_doador", nullable = false)
	private LocalDate dataNascimento;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doador", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PropostaDoacao> propostas = new ArrayList<>();;
	
	
	@ManyToMany
	@JoinTable(name = "conquista_doador", 
	joinColumns = @JoinColumn(name = "id_usuario"), 
	inverseJoinColumns = @JoinColumn(name = "id_conquista"))
	private List<Conquista> conquistas = new ArrayList<>();


	public Doador() {}

	public Doador(Long id, String nome, String senha, StatusUsuario status, String cpf, LocalDate data) {
		super(id, nome, senha, status);
		setCpf(cpf);
		setData(data);

	}

	public Doador(String nome, String senha, StatusUsuario status, String cpf, LocalDate data) {
		super(nome, senha, status);
		setCpf(cpf);
		setData(data);
	}
	
	public Doador(Long id, String nome, String senha, StatusUsuario status, Foto fotoUsuario,String cpf, LocalDate data) {
		super(id, nome, senha, status, fotoUsuario);
		setCpf(cpf);
		setData(data);

	}
	
	public Doador(String nome, String senha, StatusUsuario status, Foto fotoUsuario,String cpf, LocalDate data) {
		super(nome, senha, status, fotoUsuario);
		setCpf(cpf);
		setData(data);

	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getData() {
		return dataNascimento;
	}
  
	public void setData(LocalDate data) {
		this.dataNascimento = data;
	}
	
	public void addConquista(Conquista conquista) {
		conquistas.add(conquista);
  }
	
	public void removeConquista(Conquista conquista) {
		conquistas.remove(conquista);
	}	
	
	public void addProposta(PropostaDoacao propostaDoacao) {
		propostas.add(propostaDoacao);
  }
	
	public void removeProposta(PropostaDoacao propostaDoacao) {
		propostas.remove(propostaDoacao);
	}	


}
