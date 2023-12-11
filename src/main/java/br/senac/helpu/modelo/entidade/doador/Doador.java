package br.senac.helpu.modelo.entidade.doador;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.senac.helpu.modelo.entidade.Contato.Contato;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;
import br.senac.helpu.modelo.entidade.usuario.Usuario;

public class Doador extends Usuario implements Serializable {

	private static final long serialVersionUID = 5246756539851329248L;

	private String cpf;
	private LocalDate data;
	private List<PropostaDoacao> propostas;
	
	public Doador(long id, String nome, String senha, Contato contato, String cpf, LocalDate data) {
		super(id, nome, senha, contato);
		setCpf(cpf);
		setData(data);
		propostas = new ArrayList<>();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
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
