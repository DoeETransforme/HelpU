package br.senac.helpu.modelo.dao.contato;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.helpu.modelo.entidade.contato.Contato;

import br.senac.helpu.modelo.entidade.usuario.Usuario;

import br.senac.helpu.modelo.entidade.contato.Contato_;
import br.senac.helpu.modelo.entidade.doador.Doador;
import br.senac.helpu.modelo.entidade.doador.Doador_;

import br.senac.helpu.modelo.factory.conexao.ConexaoFactory;

public class ContatoDAOImpl implements ContatoDAO {

	private ConexaoFactory fabrica;

	public ContatoDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirContato(Contato contato) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(contato);
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

	public void deletarContato(Contato contato) {
		Session sessao = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(contato);
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

	public void atualizarContato(Contato contato) {
		Session sessao = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(contato);
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

	public List<Contato> recuperarListaContatos() {

		Session sessao = null;
		List<Contato> listaRecuperada = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Contato> criteria = construtor.createQuery(Contato.class);
			Root<Contato> RaizContato = criteria.from(Contato.class);

			criteria.select(RaizContato);

			listaRecuperada = sessao.createQuery(criteria).getResultList();

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
		return listaRecuperada;
	}


	public  Contato recuperarContatoUsuario(Usuario usuario) {

		Session sessao = null;
		Contato contato = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();

	        CriteriaBuilder construtor = sessao.getCriteriaBuilder();
	        CriteriaQuery<Contato> criteria = construtor.createQuery(Contato.class);
	        Root<Contato> raizContato = criteria.from(Contato.class);

	        criteria.select(raizContato);
	        criteria.where(construtor.equal(raizContato.get("usuario"), usuario));

	        contato = sessao.createQuery(criteria).getSingleResult();

	        sessao.getTransaction().commit();
			
		}catch(Exception sqlException) {
			sqlException.printStackTrace();
			
			if(sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
		}finally {
			if(sessao != null) {
				sessao.close();
			}
			
		}
		return contato;

	public Contato recuperarContatoId(Long id) {
		Session sessao = null;
		Contato contatoRecuperado = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Contato> criteria = construtor.createQuery(Contato.class);

			Root<Contato> raizContato = criteria.from(Contato.class);

			criteria.select(raizContato);

			criteria.where(construtor.equal(raizContato.get(Contato_.id), id));

			contatoRecuperado = sessao.createQuery(criteria).getSingleResult();

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

		return contatoRecuperado;


	}

}
