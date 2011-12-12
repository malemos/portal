package br.com.portal.model.test.test;

import java.math.BigDecimal;

import org.hibernate.classic.Session;

import br.com.portal.model.Produto;
import br.com.portal.model.dao.ProdutoDao;
import br.com.portal.model.infra.FactorySessionCreate;

public class testeDeSessao {

	public static void main(String[] args) {

		Session session = new FactorySessionCreate().getInstance()
				.openSession();
		testeAdicao(session);
		testeEdicao(1L, session);
		testeExclusao(1L, session);

	}

	private static void testeExclusao(Long id, Session session) {
		Produto produto = new ProdutoDao(session).findById(id);
		if (produto != null) {
			produto.setQuantidade(100L);
			new ProdutoDao(session).exclusao(produto);
		}
	}

	private static void testeEdicao(Long id, Session session) {
		Produto produto = new ProdutoDao(session).findById(id);
		if (produto != null) {
			produto.setQuantidade(100L);
			new ProdutoDao(session).edicao(produto);
		}

	}

	private static void testeAdicao(Session session) {
		Produto produto = new Produto();
		produto.setDescricao("Caneta Bic");
		produto.setNome("Caneta Bic");
		produto.setPreco(new BigDecimal(10.50));
		produto.setQuantidade(1000L);
		new ProdutoDao(session).adicao(produto);
	}

}
