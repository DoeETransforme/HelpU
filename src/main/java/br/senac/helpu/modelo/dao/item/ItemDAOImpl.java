package br.senac.helpu.modelo.dao.item;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.helpu.modelo.entidade.item.Item;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;
import br.senac.helpu.modelo.factory.conexao.ConexaoFactory;

public class ItemDAOImpl implements ItemDAO {

	private ConexaoFactory fabrica;

	public ItemDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirItem(Item item) {
		org.hibernate.Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.save(item);
			sessao.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
		} finally {
			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public void deletarItem(Item item) {
		org.hibernate.Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.delete(item);
			sessao.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
		} finally {
			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public void atualizarItem(Item item) {
		org.hibernate.Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.update(item);
			sessao.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
		} finally {
			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public List<Item> recuperarItem() {
		Session sessao = null;
		List<Item> itens = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Item> criteria = construtor.createQuery(Item.class);
			Root<Item> raizItem = criteria.from(Item.class);

			criteria.select(raizItem);

			itens = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
		} finally {
			if (sessao != null) {
				sessao.close();
			}
		}

		return itens;
	}

	public Item recuperarItemPorProposta(PropostaDoacao propostaDoacao) {

	    Session sessao = null;
	    Item item = null;

	    try {
	        sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();

	        CriteriaBuilder construtor = sessao.getCriteriaBuilder();
	        CriteriaQuery<Item> criteria = construtor.createQuery(Item.class);
	        Root<Item> raizItem = criteria.from(Item.class);

	        raizItem.fetch("propostaDoacao", JoinType.LEFT).fetch("doador", JoinType.LEFT);
	        raizItem.fetch("pedidoDoacao", JoinType.LEFT);
	        raizItem.fetch("alimento" , JoinType.LEFT);

	        criteria.select(raizItem);
	        criteria.where(construtor.equal(raizItem.get("propostaDoacao"), propostaDoacao));

	        item = sessao.createQuery(criteria).getSingleResult();

	        sessao.getTransaction().commit();

	    } catch (Exception sqlException) {
	        sqlException.printStackTrace();

	        if (sessao.getTransaction() != null) {
	            sessao.getTransaction().rollback();
	        }
	    } finally {
	        if (sessao != null) {
	            sessao.close();
	        }
	    }
	    return item;
	}

	public Item recuperarItemPorPedido(PedidoDoacao pedidoDoacao) {

	    Session sessao = null;
	    Item item = null;

	    try {
	        sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();

	        CriteriaBuilder construtor = sessao.getCriteriaBuilder();
	        CriteriaQuery<Item> criteria = construtor.createQuery(Item.class);
	        Root<Item> raizItem = criteria.from(Item.class);
	      
	        raizItem.fetch("pedidoDoacao", JoinType.LEFT);
	        raizItem.fetch("alimento" , JoinType.LEFT);

	        criteria.select(raizItem);
	        criteria.where(construtor.equal(raizItem.get("pedidoDoacao"), pedidoDoacao));

	        item = sessao.createQuery(criteria).getSingleResult();

	        sessao.getTransaction().commit();

	    } catch (Exception sqlException) {
	        sqlException.printStackTrace();

	        if (sessao.getTransaction() != null) {
	            sessao.getTransaction().rollback();
	        }
	    } finally {
	        if (sessao != null) {
	            sessao.close();
	        }
	    }
	    return item;
	}
	



	
}
