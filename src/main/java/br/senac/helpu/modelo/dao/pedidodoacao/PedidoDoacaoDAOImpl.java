package br.senac.helpu.modelo.dao.pedidodoacao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.helpu.modelo.entidade.alimento.Alimento;
import br.senac.helpu.modelo.entidade.alimento.Alimento_;
import br.senac.helpu.modelo.entidade.item.Item;
import br.senac.helpu.modelo.entidade.item.Item_;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.ong.Ong_;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao_;
import br.senac.helpu.modelo.enumeracao.statuspedido.StatusPedido;
import br.senac.helpu.modelo.factory.conexao.ConexaoFactory;

public class PedidoDoacaoDAOImpl implements PedidoDoacaoDAO {

	private ConexaoFactory fabrica;

	public PedidoDoacaoDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	@Override
	public void inserirPedidoDoacao(PedidoDoacao pedidoDoacao) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(pedidoDoacao);

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

	@Override
	public void deletarPedidoDoacao(PedidoDoacao pedidoDoacao) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(pedidoDoacao);

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

	@Override
	public void atualizarPedidoDoacao(PedidoDoacao pedidoDoacao) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(pedidoDoacao);

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

	public List<PedidoDoacao> recuperarPedidosDoacao() {
		Session sessao = null;
		List<PedidoDoacao> pedidos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PedidoDoacao> criteria = construtor.createQuery(PedidoDoacao.class);
			Root<PedidoDoacao> raizConquista = criteria.from(PedidoDoacao.class);
			
			criteria.select(raizConquista);
			
			pedidos = sessao.createQuery(criteria).getResultList();

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
		return pedidos;
	}

	public List<PedidoDoacao> recuperarPedidoDoacaoOng(Ong ong) {
		Session sessao = null;
		List<PedidoDoacao> pedidos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<PedidoDoacao> criteria = construtor.createQuery(PedidoDoacao.class);
			Root<PedidoDoacao> raizPedido = criteria.from(PedidoDoacao.class);

			Join<PedidoDoacao, Ong> juncaoPedidos = raizPedido.join(PedidoDoacao_.ong);

			ParameterExpression<Long> idOng = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoPedidos.get(Ong_.id), idOng));

			pedidos = sessao.createQuery(criteria).setParameter(idOng, ong.getId()).getResultList();

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
		return pedidos;
	}

	public List<PedidoDoacao> recuperarPedidoDoacaoOngAlimento(Ong ong, Alimento alimento) {
		Session sessao = null;
		List<PedidoDoacao> pedidos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<PedidoDoacao> criteria = construtor.createQuery(PedidoDoacao.class);
			Root<PedidoDoacao> raizPedido = criteria.from(PedidoDoacao.class);

			Join<PedidoDoacao, Ong> juncaoOng = raizPedido.join(PedidoDoacao_.ong);
			Join<PedidoDoacao, Item> juncaoItem = raizPedido.join(PedidoDoacao_.itens);
			Join<Item, Alimento> juncaoAlimento = juncaoItem.join(Item_.alimento);

			ParameterExpression<Long> idOng = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoOng.get(Ong_.id), idOng));

			ParameterExpression<Long> idItem = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoItem.get(Item_.id), idItem));

			ParameterExpression<Long> idAlimento = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoAlimento.get(Alimento_.id), idAlimento));

			pedidos = sessao.createQuery(criteria).setParameter(idOng, ong.getId())
					.setParameter(idAlimento, alimento.getId()).getResultList();

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
		return pedidos;

	}

	public List<PedidoDoacao> recuperarPedidoDoacaoOngStatus(Ong ong, StatusPedido status) {
		Session sessao = null;
		List<PedidoDoacao> pedidos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<PedidoDoacao> criteria = construtor.createQuery(PedidoDoacao.class);
			Root<PedidoDoacao> raizPedido = criteria.from(PedidoDoacao.class);

			Join<PedidoDoacao, Ong> juncaoPedidos = raizPedido.join(PedidoDoacao_.ong);

			ParameterExpression<Long> idOng = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoPedidos.get(Ong_.id), idOng));

			ParameterExpression<StatusPedido> statusPedido = construtor.parameter(StatusPedido.class);
			criteria.where(construtor.equal(raizPedido.get(PedidoDoacao_.statuspedido), statusPedido));

			pedidos = sessao.createQuery(criteria).setParameter(idOng, ong.getId()).setParameter(statusPedido, status)
					.getResultList();

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
		return pedidos;
	}

	public List<PedidoDoacao> recuperarPedidoDoacaoOngStatusIntervalo(Ong ong, StatusPedido status,
			LocalDate datainicial, LocalDate datafinal) {
		Session sessao = null;
		List<PedidoDoacao> pedidos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<PedidoDoacao> criteria = construtor.createQuery(PedidoDoacao.class);
			Root<PedidoDoacao> raizPedido = criteria.from(PedidoDoacao.class);

			Join<PedidoDoacao, Ong> juncaoPedidos = raizPedido.join(PedidoDoacao_.ong);

			ParameterExpression<Long> idOng = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoPedidos.get(Ong_.id), idOng));

			ParameterExpression<StatusPedido> statusPedido = construtor.parameter(StatusPedido.class);
			criteria.where(construtor.equal(raizPedido.get(PedidoDoacao_.statuspedido), statusPedido));

			criteria.where(construtor.between(raizPedido.get(PedidoDoacao_.data), datainicial, datafinal));

			pedidos = sessao.createQuery(criteria).setParameter(idOng, ong.getId()).setParameter(statusPedido, status)
					.getResultList();

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
		return pedidos;
	}

}
