package br.senac.helpu;

import br.senac.helpu.modelo.dao.item.ItemDAOImpl;
import br.senac.helpu.modelo.dao.item.ItemDao;
import br.senac.helpu.modelo.entidade.item.Item;

public class Main {
	public static void main(String[] args) {
		

			
		Item item = new Item(10);
		ItemDao dao = new ItemDAOImpl();
		
		dao.inserirItem(item);
		
		
		System.out.println(item.getQuantidade());

		
	}
}
