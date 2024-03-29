package br.senac.helpu.modelo.dao.pedidodoacao;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
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
import br.senac.helpu.modelo.enumeracao.pedido.StatusPedido;
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

	public PedidoDoacao recuperarPedidoDoacaoId(Long id) {

		Session sessao = null;
		PedidoDoacao pedidoDoacao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PedidoDoacao> criteria = construtor.createQuery(PedidoDoacao.class);
			Root<PedidoDoacao> raizPedidoDoacao = criteria.from(PedidoDoacao.class);
			raizPedidoDoacao.fetch("ong", JoinType.LEFT);
			raizPedidoDoacao.fetch(PedidoDoacao_.foto);

			criteria.select(raizPedidoDoacao);

			criteria.where(construtor.equal(raizPedidoDoacao.get(PedidoDoacao_.id), id));
			pedidoDoacao = sessao.createQuery(criteria).getSingleResult();

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
		return pedidoDoacao;
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
			
			raizConquista.fetch(PedidoDoacao_.foto);
			raizConquista.fetch(PedidoDoacao_.ong);
			
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
	
	
	public List<PedidoDoacao> recuperarPedidosDoacaoLimitTrace() {
		Session sessao = null;
		List<PedidoDoacao> pedidos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PedidoDoacao> criteria = construtor.createQuery(PedidoDoacao.class);
			Root<PedidoDoacao> raizProposta = criteria.from(PedidoDoacao.class);
			
			raizProposta.fetch(PedidoDoacao_.ONG);
			raizProposta.fetch(PedidoDoacao_.foto);

			criteria.select(raizProposta);

			pedidos = sessao.createQuery(criteria).setMaxResults(5).getResultList();

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
			raizPedido.fetch("ong", JoinType.LEFT);
			raizPedido.fetch(PedidoDoacao_.foto);

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

	public List<PedidoDoacao> recuperarPedidoDoacaoStatus(StatusPedido status) {
		Session sessao = null;
		List<PedidoDoacao> pedidos = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<PedidoDoacao> criteria = construtor.createQuery(PedidoDoacao.class);
			Root<PedidoDoacao> raizPedido = criteria.from(PedidoDoacao.class);

			criteria.where(construtor.equal(raizPedido.get(PedidoDoacao_.statuspedido), status));

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

	public List<PedidoDoacao> recuperarPedidoDoacaoOngAlimento(Ong ong, Alimento alimento) {
		Session sessao = null;
		List<PedidoDoacao> pedidos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<PedidoDoacao> criteria = construtor.createQuery(PedidoDoacao.class);
			Root<PedidoDoacao> raizPedido = criteria.from(PedidoDoacao.class);

			Join<PedidoDoacao, Item> juncaoItem = raizPedido.join(PedidoDoacao_.itens);
			Join<Item, Alimento> juncaoAlimento = juncaoItem.join(Item_.alimento);

			criteria.select(raizPedido);
			criteria.where(construtor.equal(raizPedido.get(PedidoDoacao_.ong).get(Ong_.id), ong.getId()),
					construtor.equal(juncaoAlimento.get(Alimento_.id), alimento.getId()));
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

	public List<PedidoDoacao> recuperarPedidoDoacaoOngStatus(Ong ong, StatusPedido status) {
		Session sessao = null;
		List<PedidoDoacao> pedidos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<PedidoDoacao> criteria = construtor.createQuery(PedidoDoacao.class);
			Root<PedidoDoacao> raizPedido = criteria.from(PedidoDoacao.class);

			criteria.select(raizPedido);

			criteria.where(construtor.equal(raizPedido.get(PedidoDoacao_.statuspedido), status),
					construtor.equal(raizPedido.get(PedidoDoacao_.ong).get(Ong_.id), ong.getId()));

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

			criteria.where(construtor.equal(raizPedido.get(PedidoDoacao_.ong).get(Ong_.id), ong.getId()),
					(construtor.equal(raizPedido.get(PedidoDoacao_.statuspedido), status)),
					(construtor.between(raizPedido.get(PedidoDoacao_.data), datainicial, datafinal)));

			pedidos = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();

			criteria.select(raizPedido);
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

	public List<PedidoDoacao> filtrarPedidos(Optional<StatusPedido> status, Optional<String> nome,
			Optional<LocalDate> dataInicial, Optional<LocalDate> dataFinal, Optional<Alimento> alimento) {

		Session sessao = null;
		List<PedidoDoacao> pedidos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<PedidoDoacao> criteria = construtor.createQuery(PedidoDoacao.class);
			Root<PedidoDoacao> raizPedido = criteria.from(PedidoDoacao.class);

			Join<PedidoDoacao, Item> juncaoItem = raizPedido.join(PedidoDoacao_.itens);
			Join<Item, Alimento> juncaoAlimento = juncaoItem.join(Item_.alimento);
			raizPedido.fetch(PedidoDoacao_.ong);

			List<Predicate> predicados = new ArrayList<>();

			status.ifPresent(statuspedido -> predicados
					.add(construtor.equal(raizPedido.get(PedidoDoacao_.statuspedido), status.get())));
			nome.ifPresent(nomepedido -> predicados
					.add(construtor.equal(raizPedido.get(PedidoDoacao_.ong).get(Ong_.nome), nome.get())));
			dataInicial.ifPresent(datacomeco -> {
				predicados
						.add(construtor.greaterThanOrEqualTo((raizPedido.get(PedidoDoacao_.data)), dataInicial.get()));
				dataFinal.ifPresent(dataFim -> {
					predicados.add(construtor.lessThanOrEqualTo(raizPedido.get(PedidoDoacao_.data), dataFinal.get()));
				});
			});
			alimento.ifPresent(alimentopedido -> predicados.add(construtor.equal(juncaoAlimento, alimento.get())));
			
			if (!predicados.isEmpty()) {
				criteria.where(construtor.and(predicados.toArray(new Predicate[predicados.size()])));
				
			}
			raizPedido.fetch(PedidoDoacao_.foto);
			
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

}
