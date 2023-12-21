
package br.senac.helpu.modelo.dao.ong;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.ong.Ong_;
import br.senac.helpu.modelo.factory.conexao.ConexaoFactory;

public class OngDAOimpl implements OngDAO {

	private ConexaoFactory fabrica;

	public OngDAOimpl() {

		fabrica = new ConexaoFactory();

	}

	public Ong recuperarOngPeloNome(String nome) {

		Session sessao = null;

		Ong ong = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Ong> criteria = construtor.createQuery(Ong.class);

			Root<Ong> raizOng = criteria.from(Ong.class);

			criteria.where(construtor.equal(raizOng.get(Ong_.nome), nome));

			ong = sessao.createQuery(criteria).getSingleResult();

			sessao.getTransaction().commit();

		} catch (Exception sqException) {

			if (sessao.getTransaction() != null) {

				sessao.getTransaction().rollback();

			}

		} finally {

			if (sessao != null) {

				sessao.close();

			}

		}

		return ong;

	}

	public Ong recuperarOngId(Long id) {

		Session sessao = null;

		Ong ongRecuperadaPeloid = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Ong> criteria = construtor.createQuery(Ong.class);

			Root<Ong> raizOng = criteria.from(Ong.class);

			criteria.select(raizOng);

			criteria.where(construtor.equal(raizOng.get(Ong_.id), id));

			ongRecuperadaPeloid = sessao.createQuery(criteria).getSingleResult();

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

		return ongRecuperadaPeloid;

	}

	public Ong recuperarOng(Ong ong) {

		Session sessao = null;

		Ong ongRecuperada = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Ong> criteria = construtor.createQuery(Ong.class);

			Root<Ong> raizOng = criteria.from(Ong.class);

			criteria.select(raizOng);

			criteria.where(construtor.equal(raizOng.get(Ong_.id), ong.getId()));

			ongRecuperada = sessao.createQuery(criteria).getSingleResult();

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

		return ongRecuperada;

	}

	public List<Ong> recuperarListaOng() {

		Session sessao = null;

		List<Ong> listaRecuperada = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Ong> criteria = construtor.createQuery(Ong.class);

			Root<Ong> raizOng = criteria.from(Ong.class);

			criteria.select(raizOng);

			listaRecuperada = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();

			return null;

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {

				sessao.getTransaction().rollback();

			}

		}

		return listaRecuperada;

	}

	public List<Endereco> recuperarListaEnderecos(Ong ong) {
		Session sessao = null;
		List<Endereco> listaRecuperada = null;

		try {
			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);

			Root<Endereco> raizEndereco = criteria.from(Endereco.class);

			criteria.select(raizEndereco);

			listaRecuperada = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();

			return null;
		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
		}
		return listaRecuperada;
	}


}
