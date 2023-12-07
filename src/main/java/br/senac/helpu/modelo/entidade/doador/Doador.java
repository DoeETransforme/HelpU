package br.senac.helpu.modelo.entidade.doador;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;


@Entity
@Table(name = "doador")
public class Doador implements Serializable {

	private static final long serialVersionUID = 5246756539851329248L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_doador")
	private Long id;
	
	@Column(name = "cpf", length = 14, nullable = false , unique = true)
	private String cpf;
	
	@Column(name = "data_nascimento", nullable = false)
	private LocalDate dataNascimento;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doador", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PropostaDoacao> propostas;

	public Doador(long id, String cpf, LocalDate data) {
		setId(id);
		setCpf(cpf);
		setData(data);
		propostas = new ArrayList<>();
	}
	
	public Doador( String cpf, LocalDate data) {
		setCpf(cpf);
		setData(data);
		propostas = new ArrayList<>();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void addProposta(PropostaDoacao proposta) {
		propostas.add(proposta);
	}

	public void removeProposta(PropostaDoacao proposta) {
		propostas.remove(proposta);
	}

	public String removePropostapeloID(long id) {
		for (PropostaDoacao propostaDoacao : propostas) {
			if (id == propostaDoacao.getId()) {
				propostas.remove(propostaDoacao);
				return "A proposta de doação foi removida com sucesso.";
			}
		}
		return "Não foi possível encontrar uma proposta de doação com este id.";
	}
	
	/*public String editarProposta(long id) {
		Scanner sc = new Scanner(System.in);
		for (PropostaDoacao propostaDoacao : propostas) {
			if (id == propostaDoacao.getId()) {
				System.out.println("1 - Adicionar Item\n2 - Remover Item\n3 - Alterar Status");
				int opcao = sc.nextInt();
				switch (opcao) {
				case 1:
					
					break;

				default:
					break;
				}
			}
		}
	}*/
}
