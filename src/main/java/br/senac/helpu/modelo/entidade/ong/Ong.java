package br.senac.helpu.modelo.entidade.ong;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import br.senac.helpu.modelo.entidade.contato.Contato;
import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.entidade.foto.Foto;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.entidade.usuario.Usuario;
import br.senac.helpu.modelo.enumeracao.usuario.StatusUsuario;

@Entity
@Table(name = "ong")
public class Ong extends Usuario implements Serializable {
	private static final long serialVersionUID = -2680258071107532867L;

	@Column(name = "cnpj_ong", length = 18, nullable = false, unique = true)
	private String cnpj;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ong", cascade = CascadeType.ALL)
	private List<PedidoDoacao> pedidosdoacao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ong", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Endereco> enderecos;

	public Ong() {}

	public Ong(Long id, String nome, String senha, StatusUsuario status, String cnpj) {
		super(id, nome, senha, status);
		setCnpj(cnpj);
	}

	public Ong(String nome, String senha, StatusUsuario status, String cnpj) {
		super(nome, senha, status);
		setCnpj(cnpj);
	}
	
	public Ong(String nome, String senha, StatusUsuario status, Foto fotoUsuario ,String cnpj) {
		super(nome, senha, status, fotoUsuario);
		setCnpj(cnpj);
		setFotoUsuario(fotoUsuario);
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
