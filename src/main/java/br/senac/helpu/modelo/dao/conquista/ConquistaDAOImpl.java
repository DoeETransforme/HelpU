package br.senac.helpu.modelo.dao.conquista;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.helpu.modelo.entidade.conquista.Conquista;
import br.senac.helpu.modelo.entidade.conquista.Conquista_;
import br.senac.helpu.modelo.entidade.doador.Doador;
import br.senac.helpu.modelo.entidade.doador.Doador_;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao_;
import br.senac.helpu.modelo.factory.conexao.ConexaoFactory;

public class ConquistaDAOImpl implements ConquistaDAO {

	private ConexaoFactory fabrica;

	public ConquistaDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirConquista(Conquista conquista) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.save(conquista);
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

	public void deletarConquista(Conquista conquista) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.delete(conquista);
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

	public void atualizarConquista(Conquista conquista) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.update(conquista);
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

	public List<Conquista> recuperarConquistas() {

		Session sessao = null;
		List<Conquista> conquistas = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Conquista> criteria = construtor.createQuery(Conquista.class);
			Root<Conquista> raizConquista = criteria.from(Conquista.class);

			criteria.select(raizConquista);

			conquistas = sessao.createQuery(criteria).getResultList();

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

		return conquistas;

	}
	
	public Conquista recuperarConquistaId(Long id) {

		Session sessao = null;
		Conquista conquista = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Conquista> criteria = construtor.createQuery(Conquista.class);
			Root<Conquista> raizConquista = criteria.from(Conquista.class);

			criteria.select(raizConquista);

			criteria.where(construtor.equal(raizConquista.get(Conquista_.id), id));		
			conquista = sessao.createQuery(criteria).getSingleResult();
			
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
		return conquista;
	}

	public Conquista recuperarConquistaPorNome(String nome) {
		Session sessao = null;
		Conquista conquistaRecuperadoPeloNome = null;
		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Conquista> criteria = construtor.createQuery(Conquista.class);
			Root<Conquista> raizConquista = criteria.from(Conquista.class);
			
			criteria.select(raizConquista);
			criteria.where(construtor.equal(raizConquista.get(Conquista_.nome), nome));
			conquistaRecuperadoPeloNome = sessao.createQuery(criteria).getSingleResult();
			
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

		return conquistaRecuperadoPeloNome;
	}

	
	public Long recuperarQuantidadeConquistaDoador(Doador doador) {
		Session sessao = null;
		Long quantidadeConquista = 0L;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Long> criteria = construtor.createQuery(Long.class);
			Root<Doador> raizConsulta = criteria.from(Doador.class);

			Join<Doador, Conquista> joinConquistas = raizConsulta.join("conquistas", JoinType.LEFT);

			ParameterExpression<Long> idDoador = construtor.parameter(Long.class);
			criteria.select(construtor.count(joinConquistas));
			criteria.where(construtor.equal(raizConsulta.get(Doador_.id), idDoador));

			quantidadeConquista = sessao.createQuery(criteria).setParameter(idDoador, doador.getId()).getSingleResult();

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

		return quantidadeConquista;

	}



	public List<Conquista> recuperarConquistasPorDoador(Doador doador) {
		Session sessao = null;
		List<Conquista> conquistas = null;
			    try  {
			    	sessao = fabrica.getConexao().openSession();
			        CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			        CriteriaQuery<Conquista> criteria = construtor.createQuery(Conquista.class);
			        Root<Conquista> raizConsulta = criteria.from(Conquista.class);
			        
			        Join<Conquista, Doador> juncaoDoador = raizConsulta.join("doadores");
			        
			        ParameterExpression<Long> idDoador = construtor.parameter(Long.class);
			        criteria.where(construtor.equal(juncaoDoador.get("id"), idDoador));
			        
			        return sessao.createQuery(criteria)
			                     .setParameter(idDoador, doador.getId())
			                     .getResultList();
			    

 
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
 
		return conquistas;
 
	}}


