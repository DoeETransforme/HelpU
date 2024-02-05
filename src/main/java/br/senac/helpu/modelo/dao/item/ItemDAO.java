package br.senac.helpu.modelo.dao.item;

import java.util.List;

import br.senac.helpu.modelo.entidade.item.Item;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;

public interface ItemDAO {

	void inserirItem(Item item);

	void deletarItem(Item item);

	void atualizarItem(Item item);

	Item recuperarItemPorProposta(PropostaDoacao propostaDoacao);

	List<Item> recuperarItem();

}