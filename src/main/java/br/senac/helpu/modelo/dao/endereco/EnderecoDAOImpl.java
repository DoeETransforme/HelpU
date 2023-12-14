package br.senac.helpu.modelo.dao.endereco;

import org.hibernate.Session;

import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.factory.conexao.ConexaoFactory;

public class EnderecoDAOImpl implements EnderecoDAO {
	 
		private ConexaoFactory fabrica;
	 
		public EnderecoDAOImpl() {
			fabrica = new ConexaoFactory();
		}
		
		@Override
		public void inserirEndereco(Endereco endereco) {
	 
			Session sessao = null;
	 
			try {
	 
				sessao = fabrica.getConexao().openSession();
				sessao.beginTransaction();
	 
				sessao.save(endereco);
	 
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
		public void deletarEndereco(Endereco endereco) {
	 
			Session sessao = null;
	 
			try {
	 
				sessao = fabrica.getConexao().openSession();
				sessao.beginTransaction();
	 
				sessao.delete(endereco);
	 
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
		public void atualizarEndereco(Endereco endereco) {
	 
			Session sessao = null;
	 
			try {
	 
				sessao = fabrica.getConexao().openSession();
				sessao.beginTransaction();
	 
				sessao.update(endereco);
	 
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
	 

