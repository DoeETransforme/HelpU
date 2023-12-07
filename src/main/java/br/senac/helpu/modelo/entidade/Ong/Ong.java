package br.senac.helpu.modelo.entidade.Ong;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;

@Entity
@Table(name = "ONG")
public class Ong implements Serializable {

	private static final long serialVersionUID = -3707751312475379705L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ong")
	private Long id;

	@Column(name = "cnpj_ong", length = 18, nullable = false, unique = true)
	private String cnpj;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "ong", cascade = CascadeType.ALL)
	private List<PedidoDoacao> pedidosdoacao;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "ong_endereco", joinColumns = @JoinColumn(name = "id_ong"), inverseJoinColumns = @JoinColumn(name = "id_endereco"))
	private List<Endereco> enderecos;



	public Ong() {
	}

	public Ong(Long id, String cnpj, Endereco endereco) {
		setId(id);
		setCnpj(cnpj);
		enderecos = new ArrayList<>();
		enderecos.add(endereco);
		pedidosdoacao = new ArrayList<>();
	}

	public Ong(String cnpj, Endereco endereco) {
		setCnpj(cnpj);
		enderecos = new ArrayList<>();
		enderecos.add(endereco);
		pedidosdoacao = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void addEndereco(Endereco endereco) {
		enderecos.add(endereco);
	}

	public void removeEndereco(Endereco endereco) {
		enderecos.add(endereco);
	}

	public void addPedido(PedidoDoacao pedido) {
		pedidosdoacao.add(pedido);
	}

	public void removePedido(PedidoDoacao pedido) {
		pedidosdoacao.remove(pedido);
	}

}
