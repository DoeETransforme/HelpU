package br.senac.helpu.modelo.dao.propostadoacao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.helpu.modelo.entidade.alimento.Alimento;
import br.senac.helpu.modelo.entidade.doador.Doador;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao_;
import br.senac.helpu.modelo.enumeracao.statusproposta.StatusProposta;
import br.senac.helpu.modelo.factory.conexao.ConexaoFactory;

public class PropostaDoacaoDAOImpl implements PropostaDoacaoDAO {

	private ConexaoFactory fabrica;

	public PropostaDoacaoDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void salvarPropostaDoacao(PropostaDoacao propostaDoacao) {
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

	public List<PropostaDoacao> recuperarTodasPropostasDoacao() {
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

	public void recuperarPropostaDoacao(PropostaDoacao propostaDoacao) {

	}

	public java.util.List<PropostaDoacao> recuperarTodasPropostaDoacao() {

		return null;
	}

	public java.util.List<PropostaDoacao> recuperarPropostaDoacaoOng(Ong ong) {

		return null;
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

			criteria.select(raizConsulta);

			criteria.where(construtor.equal(raizConsulta.get(PropostaDoacao_.STATUS), status), construtor
					.equal(raizConsulta.get().get(Instituicao_.ID), instituicao.getId()));

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

		
	
	

	public java.util.List<PropostaDoacao> recuperarTodasPropostaDoacaoOngAlimento(Ong ong, Alimento alimento) {
		Session sessao = null;
		List<PropostaDoacao> propostas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PropostaDoacao> criteria = construtor.createQuery(PropostaDoacao.class);
			Root<PropostaDoacao> raizConsulta = criteria.from(PropostaDoacao.class);

			criteria.select(raizConsulta);

			criteria.where(construtor.equal(raizConsulta.get(PropostaDoacao_.STATUS), status), construtor
					.equal(raizConsulta.get().get(Instituicao_.ID), instituicao.getId()));

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

	public java.util.List<PropostaDoacao> recuperarTodasPropostaDoacaoOngAlimentoData(Ong ong, Alimento alimento,
			LocalDate dataInicial, LocalDate datafinal) {

		return null;
	}


	public java.util.List<PropostaDoacao> recuperarTodasPropostaDoacaoStatus(Doador doador) {

		return null;
	}

	public java.util.List<PropostaDoacao> recuperarTodasPropostaDoacaoStatus(Doador doador,
			StatusProposta statusProposta) {
	
		return null;
	}


	public java.util.List<PropostaDoacao> recuperarTodasPropostaDoacaoStatus(Doador doador,
			StatusProposta statusProposta, LocalDate dataInicial, LocalDate datafinal) {
		
		return null;
	}


	public java.util.List<PropostaDoacao> recuperarTodasPropostaDoacaoAlimento(Alimento alimento) {
	
		return null;
	}


	public PropostaDoacao recuperarPropostaDoacao(Long id) {
		
		return null;
	}


	public void inserirPropostaDoacao(PropostaDoacao propostaDoacao) {
	
		
	}
}