package br.senac.helpu.modelo.factory.conexao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConexaoFactory {

	public SessionFactory getConexao() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(br.senac.helpu.modelo.entidade.alimento.Alimento.class);
		configuracao.addAnnotatedClass(br.senac.helpu.modelo.entidade.contato.Contato.class);
		configuracao.addAnnotatedClass(br.senac.helpu.modelo.entidade.doador.Doador.class);
		configuracao.addAnnotatedClass(br.senac.helpu.modelo.entidade.endereco.Endereco.class);
		configuracao.addAnnotatedClass(br.senac.helpu.modelo.entidade.item.Item.class);
		configuracao.addAnnotatedClass(br.senac.helpu.modelo.entidade.ong.Ong.class);
		configuracao.addAnnotatedClass(br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao.class);
		configuracao.addAnnotatedClass(br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao.class);
		configuracao.addAnnotatedClass(br.senac.helpu.modelo.entidade.usuario.Usuario.class);
		configuracao.addAnnotatedClass(br.senac.helpu.modelo.enumeracao.statuspedido.StatusPedido.class);
		configuracao.addAnnotatedClass(br.senac.helpu.modelo.enumeracao.statusproposta.StatusProposta.class);
		
		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
				.build();
		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;
	}
}
