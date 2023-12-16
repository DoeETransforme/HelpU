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
import br.senac.helpu.modelo.entidade.item.Item;
import br.senac.helpu.modelo.entidade.item.Item_;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.ong.Ong_;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao_;
import br.senac.helpu.modelo.enumeracao.statusproposta.StatusProposta;
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
		org.hibernate.Session sessao = null;

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
			
			Join <PropostaDoacao , Ong> juncaoOng = raizConsulta.join(PropostaDoacao_.ong);
			
			ParameterExpression<Long> idOng = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoOng.get(Ong_.id),idOng));
			
			propostas =  sessao.createQuery(criteria).setParameter( idOng, ong.getId()).getResultList();

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

	
	

	public java.util.List<PropostaDoacao> recuperarPropostaDoacaoOngStatus(Ong ong, StatusProposta statusProposta) {
		Session sessao = null;
		List<PropostaDoacao> propostas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
			Root<PropostaDoacao> raizConsulta = criteria.from(PropostaDoacao.class);
			
			Join<PropostaDoacao, Ong> JuncaoOng = raizConsulta.join(PropostaDoacao_.ong); 

			criteria.select(raizConsulta);

			criteria.where(construtor.equal(raizConsulta.get(PropostaDoacao_.statusProposta), statusProposta),
				construtor.equal(raizConsulta.get(PropostaDoacao_.ong), ong));

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
			Root<PropostaDoacao> raizPedido = criteria.from(PropostaDoacao.class);
 
			Join<PropostaDoacao, Ong> juncaoOng = raizPedido.join(PropostaDoacao_.ong);
			Join<PropostaDoacao, Item> juncaoItem = raizPedido.join(PropostaDoacao_.itens);
			Join<Item, Alimento> juncaoAlimento = juncaoItem.join(Item_.alimentos);
 
			ParameterExpression<Long> idOng = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoOng.get(Ong_.id), idOng));
 
			ParameterExpression<Long> idItem = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoItem.get(Item_.id), idItem));
 
			ParameterExpression<Long> idAlimento = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoAlimento.get(Alimento_.id), idAlimento));
 
			propostas = sessao.createQuery(criteria).setParameter(idOng, ong.getId())
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
			
			Join <PropostaDoacao , Item > juncaoItem = raizConsulta.join(PropostaDoacao_.itens);
			Join<Item , Alimento> juncaoAlimento = juncaoItem.join(Item_.alimentos);
			
			ParameterExpression<Long> idItem = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoItem.get(Item_.id),idItem));
			
			ParameterExpression<Long> idAlimento = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoAlimento.get(Alimento_.id),idAlimento));
			
			propostas =  sessao.createQuery(criteria).setParameter( idAlimento, alimento.getId()).getResultList();

			criteria.select(raizConsulta);

			

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

	
	
	
	public java.util.List<PropostaDoacao> recuperarTodasPropostaDoacaoOngAlimentoData(Ong ong, Alimento alimento,
			LocalDate dataInicial, LocalDate datafinal) {
		
		return null;
	}
	
	
	
	public java.util.List<PropostaDoacao> recuperarTodasPropostaDoacaoStatus(Doador doador,
			StatusProposta statusProposta, LocalDate dataInicial, LocalDate datafinal) {
		
		return null;
	}

	@Override
	public List<PropostaDoacao> recuperarTodasPropostaDoacaoDoador(Doador doador) {
		
		return null;
	}

	

	@Override
	public List<PropostaDoacao> recuperarTodasPropostaDoacaoDoadorStatusData(Doador doador,
			StatusProposta statusProposta, LocalDate dataInicial, LocalDate datafinal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropostaDoacao> recuperarTodasPropostaDoacaoDoadorStatus(Doador doador, StatusProposta statusProposta) {
		// TODO Auto-generated method stub
		return null;
	}


	

	

	
}