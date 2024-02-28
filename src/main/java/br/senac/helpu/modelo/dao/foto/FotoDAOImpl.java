package br.senac.helpu.modelo.dao.foto;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.helpu.modelo.entidade.conquista.Conquista;
import br.senac.helpu.modelo.entidade.foto.Foto;
import br.senac.helpu.modelo.entidade.foto.Foto_;
import br.senac.helpu.modelo.entidade.ong.Ong_;
import br.senac.helpu.modelo.entidade.usuario.Usuario;
import br.senac.helpu.modelo.entidade.usuario.Usuario_;
import br.senac.helpu.modelo.factory.conexao.ConexaoFactory;

public class FotoDAOImpl implements FotoDAO {

	private ConexaoFactory fabrica;

	public FotoDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirFoto(Foto foto) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(foto);

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

	public void deletarFoto(Foto foto) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(foto);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null)
				sessao.getTransaction().rollback();
		} finally {
			if (sessao != null)
				sessao.close();
		}

	}

	public void atualizarFoto(Foto foto) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(foto);

			sessao.getTransaction().commit();
		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null)
				sessao.getTransaction().rollback();

		} finally {
			if (sessao != null)
				sessao.close();
		}

	}

	public Foto recuperarFotoId(Long id) {

		Session sessao = null;

		Foto fotoRecuperadaPeloId = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Foto> criteria = construtor.createQuery(Foto.class);

			Root<Foto> raizFoto = criteria.from(Foto.class);
			criteria.select(raizFoto);
			criteria.where(construtor.equal(raizFoto.get("usuario_.id"), id));

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

		return fotoRecuperadaPeloId;

	}

	public Foto recuperarFotoUsuario(Usuario usuario) {
		Session session = null;
		Foto foto = null;

		try {
			session = fabrica.getConexao().openSession();
			session.beginTransaction();
			
			CriteriaBuilder construtor = session.getCriteriaBuilder();
			CriteriaQuery<Foto> criteria = construtor.createQuery(Foto.class);
			Root<Foto> raizFoto = criteria.from(Foto.class);
			
			criteria.select(raizFoto);
			
			criteria.where(construtor.equal(raizFoto.get(Foto_.id), usuario.getFotoUsuario().getId()));
			
			foto = session.createQuery(criteria).getSingleResult();
			
			session.getTransaction().commit();
			
		} catch (Exception sqlException) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return foto;
	}

	public List<Foto> recuperarFotos() {
		Session sessao = null;
		List<Foto> fotos = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Foto> criteria = construtor.createQuery(Foto.class);
			Root<Foto> raizFoto = criteria.from(Foto.class);

			criteria.select(raizFoto);

			fotos = sessao.createQuery(criteria).getResultList();

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

		return fotos;
	}

}
