package br.senac.helpu.modelo.dao.item;
 
import java.util.List;

import br.senac.helpu.modelo.entidade.item.Item;
 
public interface ItemDao {
	
	
	void inserirItem(Item item);
	void deletarItem(Item item);
	void atualizarItem(Item item);
	List <Item> recuperarItem();
	
	
	
	
	
	
	
	
	
 
}