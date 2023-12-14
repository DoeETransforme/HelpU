package br.senac.helpu.modelo.dao.contato;



import org.hibernate.Session;

import br.senac.helpu.modelo.entidade.contato.Contato;
import br.senac.helpu.modelo.factory.conexao.ConexaoFactory;

public class ContatoDAOimpl implements ContatoDAO {

	private ConexaoFactory fabrica;

	public ContatoDAOimpl() {
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

	

}
