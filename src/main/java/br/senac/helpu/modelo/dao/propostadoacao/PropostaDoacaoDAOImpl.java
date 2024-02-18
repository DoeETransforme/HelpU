package br.senac.helpu.modelo.dao.propostadoacao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.helpu.modelo.entidade.alimento.Alimento;
import br.senac.helpu.modelo.entidade.alimento.Alimento_;
import br.senac.helpu.modelo.entidade.doador.Doador;
import br.senac.helpu.modelo.entidade.doador.Doador_;
import br.senac.helpu.modelo.entidade.item.Item;
import br.senac.helpu.modelo.entidade.item.Item_;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.ong.Ong_;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao_;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao_;
import br.senac.helpu.modelo.enumeracao.proposta.StatusProposta;
import br.senac.helpu.modelo.factory.conexao.ConexaoFactory;

public class PropostaDoacaoDAOImpl implements PropostaDoacaoDAO {

	private ConexaoFactory fabrica;

	public PropostaDoacaoDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirPropostaDoacao(PropostaDoacao propostaDoacao) {
		org.hibernate.Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.save(propostaDoacao);
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

	public void deletarPropostaDoacao(PropostaDoacao propostaDoacao) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.delete(propostaDoacao);
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

	public void atualizarPropostaDoacao(PropostaDoacao propostaDoacao) {
		org.hibernate.Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.update(propostaDoacao);
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
	
	public PropostaDoacao recuperarPropostaDoacaoId(Long id) {

		Session sessao = null;
		PropostaDoacao propostaDoacao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
			Root<PropostaDoacao> raizPropostaDoacao = criteria.from(PropostaDoacao.class);
			
			raizPropostaDoacao.fetch(PropostaDoacao_.PEDIDO_DOACAO, JoinType.LEFT).fetch("ong", JoinType.LEFT);
			

			criteria.select(raizPropostaDoacao);

			criteria.where(construtor.equal(raizPropostaDoacao.get(PropostaDoacao_.id), id));		
			propostaDoacao = sessao.createQuery(criteria).getSingleResult();
			
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
		return propostaDoacao;
	}
	
	public List<PropostaDoacao> recuperarPropostasDoacoesItemId(Long id) {

		Session sessao = null;
		List<PropostaDoacao> propostaDoacao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
			Root<PropostaDoacao> raizPropostaDoacao = criteria.from(PropostaDoacao.class);
			
			raizPropostaDoacao.fetch(PropostaDoacao_.ITENS, JoinType.LEFT).fetch("alimento", JoinType.LEFT);
			

			criteria.select(raizPropostaDoacao).distinct(true);

			criteria.where(construtor.equal(raizPropostaDoacao.get(PropostaDoacao_.id), id));		
			propostaDoacao = sessao.createQuery(criteria).getResultList();
			
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
		return propostaDoacao;
	}

	public List<PropostaDoacao> recuperarTodasPropostaDoacao() {
		Session sessao = null;
		List<PropostaDoacao> propostasDoacao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
			Root<PropostaDoacao> raizPropostaDoacao = criteria.from(PropostaDoacao.class);

			criteria.select(raizPropostaDoacao);

			propostasDoacao = sessao.createQuery(criteria).getResultList();

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

		return propostasDoacao;
	}

	public List<PropostaDoacao> recuperarPropostaDoacaoOng(Ong ong) {
		Session sessao = null;
		List<PropostaDoacao> propostas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
			Root<PropostaDoacao> raizConsulta = criteria.from(PropostaDoacao.class);
			Join<PropostaDoacao, PedidoDoacao> juncaoPedido = raizConsulta.join(PropostaDoacao_.pedidoDoacao);
			Join<PedidoDoacao, Ong> juncaoOng = juncaoPedido.join(PedidoDoacao_.ong);
			ParameterExpression<Long> idOng = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoOng.get(Ong_.id), idOng));
			propostas = sessao.createQuery(criteria).setParameter(idOng, ong.getId()).getResultList();

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

		return propostas;

	}

	public List<PropostaDoacao> recuperarPropostaDoacaoOngStatus(Ong ong, StatusProposta status) {
		Session sessao = null;
		List<PropostaDoacao> propostas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
			Root<PropostaDoacao> raizConsulta = criteria.from(PropostaDoacao.class);

			Join<PropostaDoacao, PedidoDoacao> juncaoPedido = raizConsulta.join(PropostaDoacao_.pedidoDoacao);
			criteria.select(raizConsulta);
			criteria.where(construtor.equal(raizConsulta.get(PropostaDoacao_.statusProposta), status),
					construtor.equal(juncaoPedido.get(PedidoDoacao_.ong).get(Ong_.id), ong.getId()));
			propostas = sessao.createQuery(criteria).getResultList();
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

		return propostas;

	}

	public List<PropostaDoacao> recuperarTodasPropostaDoacaoOngAlimento(Ong ong, Alimento alimento) {

		Session sessao = null;
		List<PropostaDoacao> propostas = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
			Root<PropostaDoacao> raizConsulta = criteria.from(PropostaDoacao.class);

			Join<PropostaDoacao, PedidoDoacao> juncaoPedido = raizConsulta.join(PropostaDoacao_.pedidoDoacao);
			Join<PropostaDoacao, Item> juncaoItem = raizConsulta.join(PropostaDoacao_.itens);
			Join<Item, Alimento> juncaoAlimento = juncaoItem.join(Item_.alimento);
			
			criteria.select(raizConsulta);
			criteria.where(construtor.equal(juncaoPedido.get(PedidoDoacao_.ong).get(Ong_.id), ong.getId()),
					construtor.equal(juncaoAlimento.get(Alimento_.id), alimento.getId()));
			
			propostas = sessao.createQuery(criteria).getResultList();
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
		return propostas;
	}

	public List<PropostaDoacao> recuperarTodasPropostaDoacaoAlimento(Alimento alimento) {
		Session sessao = null;
		List<PropostaDoacao> propostas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
			Root<PropostaDoacao> raizConsulta = criteria.from(PropostaDoacao.class);
			Join<PropostaDoacao, Item> juncaoItem = raizConsulta.join(PropostaDoacao_.itens);

			criteria.select(raizConsulta);
			
			criteria.where(construtor.equal(juncaoItem.get(Item_.alimento).get(Alimento_.id), alimento.getId()));
			
			propostas = sessao.createQuery(criteria).getResultList();


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

		return propostas;

	}

	public List<PropostaDoacao> recuperarTodasPropostaDoacaoOngAlimentoData(Ong ong, Alimento alimento,
			LocalDate dataInicial, LocalDate datafinal) {

		Session sessao = null;
		java.util.List<PropostaDoacao> propostas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
			Root<PropostaDoacao> raizConsulta = criteria.from(PropostaDoacao.class);

			Join<PropostaDoacao, PedidoDoacao> juncaoPedido = raizConsulta.join(PropostaDoacao_.pedidoDoacao);
			Join<PropostaDoacao, Item> juncaoItem = raizConsulta.join(PropostaDoacao_.itens);
			Join<Item, Alimento> juncaoAlimento = juncaoItem.join(Item_.alimento);
			
			criteria.select(raizConsulta);
			criteria.where(construtor.equal(juncaoPedido.get(PedidoDoacao_.ong).get(Ong_.id), ong.getId()),
					construtor.equal(juncaoAlimento.get(Alimento_.id), alimento.getId()), 
					construtor.between(raizConsulta.get(PropostaDoacao_.dataCriacao), dataInicial, datafinal));
			
			propostas = sessao.createQuery(criteria).getResultList();
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

		return propostas;
	}

	public List<PropostaDoacao> recuperarTodasPropostaDoacaoDoador(Doador doador) {
		Session sessao = null;
		List<PropostaDoacao> propostas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
			Root<PropostaDoacao> raizConsulta = criteria.from(PropostaDoacao.class);
			
			Join<PropostaDoacao, Doador> juncaoDoador = raizConsulta.join(PropostaDoacao_.doador);
			
			ParameterExpression<Long> idDoador = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoDoador.get(Doador_.id), idDoador));
			
			propostas = sessao.createQuery(criteria).setParameter(idDoador, doador.getId()).getResultList();

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

		return propostas;

	}
	
	public List<PropostaDoacao> recuperarPropostaDoacaoDoador(Doador doador) {
		Session sessao = null;
		List<PropostaDoacao> propostas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
			Root<PropostaDoacao> raizConsulta = criteria.from(PropostaDoacao.class);
			
			Join<PropostaDoacao, Doador> juncaoDoador = raizConsulta.join(PropostaDoacao_.doador);
			raizConsulta.fetch(PropostaDoacao_.ITENS,JoinType.LEFT).fetch("alimento", JoinType.LEFT);
			
			
			ParameterExpression<Long> idDoador = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoDoador.get(Doador_.id), idDoador));
			
			propostas = sessao.createQuery(criteria).setParameter(idDoador, doador.getId()).getResultList();

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

		return propostas;

	}

	public List<PropostaDoacao> recuperarTodasPropostaDoacaoDoadorStatusData(Doador doador,
			StatusProposta statusProposta, LocalDate dataInicial, LocalDate dataFinal) {
		Session sessao = null;
		List<PropostaDoacao> propostas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
			Root<PropostaDoacao> raizConsulta = criteria.from(PropostaDoacao.class);
			
			criteria.select(raizConsulta);
			
			criteria.where(construtor.equal(raizConsulta.get(PropostaDoacao_.doador).get(Doador_.id), doador.getId()),
					construtor.equal(raizConsulta.get(PropostaDoacao_.statusProposta), statusProposta), 
					construtor.between(raizConsulta.get(PropostaDoacao_.dataCriacao), dataInicial, dataFinal));
			
			propostas = sessao.createQuery(criteria).getResultList();
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

		return propostas;

	}

	public List<PropostaDoacao> recuperarTodasPropostaDoacaoDoadorStatus(Doador doador, StatusProposta statusProposta) {
		Session sessao = null;
		List<PropostaDoacao> propostas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
			Root<PropostaDoacao> raizConsulta = criteria.from(PropostaDoacao.class);
			
			
			raizConsulta.fetch(PropostaDoacao_.PEDIDO_DOACAO, JoinType.LEFT).fetch("ong", JoinType.LEFT);
			raizConsulta.fetch(PropostaDoacao_.ITENS,JoinType.LEFT).fetch("alimento", JoinType.LEFT);

			criteria.select(raizConsulta).distinct(true);

			criteria.where(construtor.equal(raizConsulta.get(PropostaDoacao_.statusProposta), statusProposta),
					construtor.equal(raizConsulta.get(PropostaDoacao_.doador).get(Doador_.id), doador.getId()));

			propostas = sessao.createQuery(criteria).getResultList();

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

		return propostas;

	}

	@Override
	public List<PropostaDoacao> recuperarPropostaDoacaoStatus(StatusProposta status) {
		Session sessao = null;
		List<PropostaDoacao> propostas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
			Root<PropostaDoacao> raizConsulta = criteria.from(PropostaDoacao.class);

			criteria.select(raizConsulta);

			criteria.where(construtor.equal(raizConsulta.get(PropostaDoacao_.statusProposta), status));
					

			propostas = sessao.createQuery(criteria).getResultList();

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

		return propostas;

	}

	
	public int recuperarQuantidadePropostaDoacaoStatusOng(StatusProposta status, Ong ong) {
	    Session sessao = null;
	    int quantidadePropostas = 0;

	    try {
	        sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();

	        CriteriaBuilder construtor = sessao.getCriteriaBuilder();

	        CriteriaQuery<Long> criteria = construtor.createQuery(Long.class);
	        Root<PropostaDoacao> raizConsulta = criteria.from(PropostaDoacao.class);

	        Join<PropostaDoacao, PedidoDoacao> juncaoPedido = raizConsulta.join(PropostaDoacao_.pedidoDoacao);
	        criteria.select(construtor.count(raizConsulta));
	        criteria.where(construtor.equal(raizConsulta.get(PropostaDoacao_.statusProposta), status),
	                construtor.equal(juncaoPedido.get(PedidoDoacao_.ong).get(Ong_.id), ong.getId()));

	        quantidadePropostas = sessao.createQuery(criteria).getSingleResult().intValue();
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

	    return quantidadePropostas;
	}
	
	public List<PropostaDoacao> recuperarTodasPropostaDoacaoOngStatusFetch(Ong ong, StatusProposta statusProposta) {
		Session sessao = null;
	    List<PropostaDoacao> propostas = null;
	    
	    try {
	        sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();
	        
	        CriteriaBuilder construtor = sessao.getCriteriaBuilder();
	        
	        CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
	        
	        Root<PropostaDoacao> raizProposta = criteria.from(PropostaDoacao.class);
	        raizProposta.fetch("pedidoDoacao", JoinType.LEFT).fetch("ong" , JoinType.LEFT);
	        raizProposta.fetch("doador", JoinType.LEFT);
	        Join<PropostaDoacao, PedidoDoacao> juncaoPedido = raizProposta.join(PropostaDoacao_.pedidoDoacao);
	        
	        
	        criteria.select(raizProposta);
	        
	        criteria.where(construtor.equal(raizProposta.get(PropostaDoacao_.statusProposta), statusProposta),
					construtor.equal(juncaoPedido.get(PedidoDoacao_.ong).get(Ong_.id), ong.getId()));
			propostas = sessao.createQuery(criteria).getResultList();
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
	    
	    return propostas;
	}
	
	public List<PropostaDoacao> recuperarTodasPropostaDoacaoPedido(PedidoDoacao pedido) {
		Session sessao = null;
	    List<PropostaDoacao> propostas = null;
	    
	    try {
	        sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();
	        
	        CriteriaBuilder construtor = sessao.getCriteriaBuilder();
	        
	        CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
	        
	        Root<PropostaDoacao> raizProposta = criteria.from(PropostaDoacao.class);
	        raizProposta.fetch(PropostaDoacao_.ITENS,JoinType.LEFT).fetch("alimento", JoinType.LEFT);
	        raizProposta.fetch("doador", JoinType.LEFT);	       
	        Join<PropostaDoacao, PedidoDoacao> juncaoPedido = raizProposta.join(PropostaDoacao_.pedidoDoacao);
	           
	        criteria.select(raizProposta).distinct(true);
	        
	        criteria.where(construtor.equal(juncaoPedido.get(PedidoDoacao_.id), pedido.getId()));
					
			propostas = sessao.createQuery(criteria).getResultList();
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
	    
	    return propostas;
	}
}
	


