package br.senac.helpu.modelo.dao.doador;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.helpu.modelo.entidade.doador.Doador;
import br.senac.helpu.modelo.entidade.doador.Doador_;
import br.senac.helpu.modelo.factory.conexao.ConexaoFactory;

public class DoadorDAOimpl implements DoadorDAO {
 
	private ConexaoFactory fabrica;
 
	public DoadorDAOimpl () {
		fabrica = new ConexaoFactory();
	}
 
	public void inserirDoador(Doador doador) {
		Session sessao = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
 
			sessao.save(doador);
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
 
	public void deletarDoador(Doador doador) {
		Session sessao = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
 
			sessao.delete(doador);
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
 
	public void atualizarDoador(Doador doador) {
		Session sessao = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
 
			sessao.update(doador);
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
	
	public List<Doador> recuperarListaDoadores() {
		Session sessao = null;
		List<Doador> listaRecuperada = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Doador> criteria = construtor.createQuery(Doador.class);
			Root<Doador> raizDoador = criteria.from(Doador.class);
			
			criteria.select(raizDoador);
			
			listaRecuperada = sessao.createQuery(criteria).getResultList();
			
			sessao.getTransaction().commit();
		}catch(Exception sqlException) {
			sqlException.printStackTrace();
			
			if(sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
		}finally {
			if (sessao != null) {
				sessao.close();
			}
		}
		return listaRecuperada;
	}



	public Doador recuperarDoador(Doador doador) {
		Session sessao = null;
		Doador doadorRecuperado = null;
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Doador> criteria = construtor.createQuery(Doador.class);
			Root<Doador> raizDoador = criteria.from(Doador.class);
			criteria.select(raizDoador);
			criteria.where(construtor.equal(raizDoador.get(Doador_.id), doador.getId()));
			
			doadorRecuperado = sessao.createQuery(criteria).getSingleResult();
			
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
 
	
		return doadorRecuperado;
	}

	
	public List<Doador>recuperarDoadorPeloNome(String nome) {
		Session sessao = null;
		 List<Doador>doadorRecuperadoPeloNome = null;
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Doador> criteria = construtor.createQuery(Doador.class);
			Root<Doador> raizDoador = criteria.from(Doador.class);
			criteria.select(raizDoador);
			criteria.where(construtor.equal(raizDoador.get(Doador_.nome), nome));
			doadorRecuperadoPeloNome = sessao.createQuery(criteria).getResultList();
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

	
		return   doadorRecuperadoPeloNome;
	}

	


	public Doador recuperarDoadorId(Long id) {
		Session sessao = null;
		Doador doadorRecuperado = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Doador> criteria = construtor.createQuery(Doador.class);
			
			Root<Doador> raizDoador = criteria.from(Doador.class);
			
			criteria.select(raizDoador);
			
			criteria.where(construtor.equal(raizDoador.get(Doador_.id), id));
			
			doadorRecuperado = sessao.createQuery(criteria).getSingleResult();
			
			sessao.getTransaction().commit();
		}catch (Exception sqlException) {
 
				sqlException.printStackTrace();
 
				if (sessao.getTransaction() != null) {
					sessao.getTransaction().rollback();
 
				}
			} finally {
 
				if (sessao != null) {
					sessao.close();
				}
			}
 
			return doadorRecuperado;
			
		
		}
	}


	
 
