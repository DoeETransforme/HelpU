package br.senac.helpu.modelo.dao.alimento;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.helpu.modelo.entidade.alimento.Alimento;
import br.senac.helpu.modelo.entidade.alimento.Alimento_;
import br.senac.helpu.modelo.factory.conexao.ConexaoFactory;

public class AlimentoDAOImpl implements AlimentoDAO {

	private ConexaoFactory fabrica;

	public AlimentoDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirAlimento(Alimento alimento) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(alimento);

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

	public void deletarAlimento(Alimento alimento) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(alimento);

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

	public void atualizarAlimento(Alimento alimento) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(alimento);

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

	public List<Alimento> recuperarAlimentos() {

		Session sessao = null;
		List<Alimento> alimentos = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Alimento> criteria = construtor.createQuery(Alimento.class);
			Root<Alimento> raizAlimento = criteria.from(Alimento.class);

			criteria.select(raizAlimento);

			alimentos = sessao.createQuery(criteria).getResultList();

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
		return alimentos;
	}
	
	public Alimento recuperarAlimentoId(Long id) {

		Session sessao = null;
		Alimento alimento = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Alimento> criteria = construtor.createQuery(Alimento.class);
			Root<Alimento> raizAlimento = criteria.from(Alimento.class);

			criteria.select(raizAlimento);

			criteria.where(construtor.equal(raizAlimento.get(Alimento_.id), id));		
			alimento = sessao.createQuery(criteria).getSingleResult();
			
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
		return alimento;
	}
}