package br.senac.helpu.modelo.dao.endereco;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.factory.conexao.ConexaoFactory;

public class EnderecoDAOImpl implements EnderecoDAO {
	 
		private ConexaoFactory fabrica;
	 
		public EnderecoDAOImpl() {
			fabrica = new ConexaoFactory();
		}
		
		
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
		
		
		public List<Endereco> recuperarEnderecos() {
		
			Session sessao = null;
			List<Endereco> enderecos = null;

			try {
				sessao = fabrica.getConexao().openSession();
				sessao.beginTransaction();

				CriteriaBuilder construtor = sessao.getCriteriaBuilder();

				CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);
				Root<Endereco> raizEndereco = criteria.from(Endereco.class);

				criteria.select(raizEndereco);

				enderecos = sessao.createQuery(criteria).getResultList();

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
			return enderecos;
			
			
			
		}

	 
			
	}
	 

