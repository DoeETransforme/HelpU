package br.senac.helpu.modelo.entidade.item;
 
import java.io.Serializable;
 
import javax.persistence.Column;
 
import javax.persistence.Entity;
import javax.persistence.FetchType;
 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
import br.senac.helpu.modelo.entidade.alimento.Alimento;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;
 
@Entity
@Table(name = "item")
public class Item implements Serializable {
 
	private static final long serialVersionUID = -4650927518777774993L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Long id;
 
	@Column(name = "quantidade_pedido", nullable = false)
	private String quantidade;
 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido_doacao")
	private PedidoDoacao pedidoDoacao;
 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proposta_doacao")
	private PropostaDoacao propostaDoacao;
 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alimento")
	private Alimento alimento;
 
	public Item() {}
 
	public Item(Long id, String quantidade, Alimento alimento) {
		setId(id);
		setQuantidade(quantidade);
		setAlimento(alimento);
 
	}
 
	public Item(String quantidade, Alimento alimento) {
		setQuantidade(quantidade);
		setAlimento(alimento);
	}
 
	public Item(Long id, String quantidade, Alimento alimento, PedidoDoacao pedido) {
		setId(id);
		setQuantidade(quantidade);
		setAlimento(alimento);
		setPedidoDoacao(pedido);
	}
	public Item(Long id, String quantidade, Alimento alimento, PropostaDoacao proposta) {
		setId(id);
		setQuantidade(quantidade);
		setAlimento(alimento);
		setPropostaDoacao(proposta);
	}
	public Item(String quantidade, Alimento alimento, PropostaDoacao proposta) {
		setQuantidade(quantidade);
		setAlimento(alimento);
		setPropostaDoacao(proposta);
	}
	public Item(String quantidade, Alimento alimento, PedidoDoacao pedido) {
		setQuantidade(quantidade);
		setAlimento(alimento);
		setPedidoDoacao(pedido);
	}
	
	public Item(Long id, String quantidade, PedidoDoacao pedido) {
		setId(id);
		setQuantidade(quantidade);
		setPedidoDoacao(pedido);
	}
	public Item(Long id, String quantidade, PropostaDoacao proposta) {
		setId(id);
		setQuantidade(quantidade);
		setPropostaDoacao(proposta);
	}
	public Item(String quantidade,PedidoDoacao pedido) {
		setQuantidade(quantidade);
		setPedidoDoacao(pedido);
	}
	public Item(String quantidade, PropostaDoacao proposta) {
		setQuantidade(quantidade);
		setPropostaDoacao(proposta);
	}
	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
 
	public String getQuantidade() {
		return quantidade;
	}
 
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
 
	public Alimento getAlimento() {
		return alimento;
	}
 
	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}
 
	public PedidoDoacao getPedidoDoacao() {
		return pedidoDoacao;
	}
 
	public void setPedidoDoacao(PedidoDoacao pedidoDoacao) {
		this.pedidoDoacao = pedidoDoacao;
	}
 
	public PropostaDoacao getPropostaDoacao() {
		return propostaDoacao;
	}
 
	public void setPropostaDoacao(PropostaDoacao propostaDoacao) {
		this.propostaDoacao = propostaDoacao;
	}
 
}

