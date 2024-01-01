package br.senac.helpu;
 
import java.time.LocalDate;
 
import br.senac.helpu.modelo.dao.alimento.AlimentoDAO;
import br.senac.helpu.modelo.dao.alimento.AlimentoDAOImpl;
import br.senac.helpu.modelo.dao.contato.ContatoDAO;
import br.senac.helpu.modelo.dao.contato.ContatoDAOimpl;
import br.senac.helpu.modelo.dao.item.ItemDAOImpl;
import br.senac.helpu.modelo.dao.item.ItemDao;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAO;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.helpu.modelo.entidade.alimento.Alimento;
import br.senac.helpu.modelo.entidade.contato.Contato;
import br.senac.helpu.modelo.entidade.item.Item;
import br.senac.helpu.modelo.entidade.ong.Ong;
 
public class Main {
	public static void main(String[] args) {
		
 
			
		Item item = new Item(10);
		Alimento alimento = new Alimento(LocalDate.of(2022, 1, 1), 20 , "arroz" );
		AlimentoDAO daoalimento = new AlimentoDAOImpl();
		ItemDao dao = new ItemDAOImpl();
		Contato contato = new Contato((long) 1 ,"92993591231", "email@gmail.com");
		ContatoDAO daoContato = new ContatoDAOimpl();
		
		daoContato.inserirContato(contato);
		
		Ong ong = new Ong("amiguingho", "senhasenha", contato, "cnpjBolado");
		
		contato.setUsuario(ong);
		UsuarioDAO daoUsuario = new UsuarioDAOImpl();
		
		daoUsuario.inserirUsuario(ong);
		
		daoalimento.inserirAlimento(alimento);
		
		dao.inserirItem(item);
		
		
		System.out.println(item.getQuantidade());
 
		
	}
}