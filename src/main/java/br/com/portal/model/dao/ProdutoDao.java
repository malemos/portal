package br.com.portal.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.portal.model.Produto;

@Component
public class ProdutoDao {

	private Session session;

	public ProdutoDao(Session session) {
		this.session = session;
	}

	public void adicao(Produto produto) {
		Transaction transaction = this.session.beginTransaction();
		session.save(produto);
		transaction.commit();
	}

	public void edicao(Produto produto) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(produto);
		transaction.commit();
	}

	public void exclusao(Produto produto) {
		Transaction transaction = session.beginTransaction();
		session.delete(produto);
		transaction.commit();
	}

	public Produto findById(Long id) {
		return (Produto) session.load(Produto.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Produto> findAll() {
		return (List<Produto>) session.createCriteria(Produto.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> findByNome(String nome) {
		Criteria criteria = session.createCriteria(Produto.class);
		return criteria.add(
				Restrictions.ilike("nome", nome, MatchMode.ANYWHERE)).list();
	}

	public void findByProduto(Produto produto) {
		session.refresh(produto);
	}
}
