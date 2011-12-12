package br.com.portal.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.portal.model.Produto;
import br.com.portal.model.configuration.Restrito;
import br.com.portal.model.dao.ProdutoDao;

@Resource
public class ProdutoController {

	private ProdutoDao produtoDao;
	private Result result;
	private Validator validator;

	public ProdutoController(ProdutoDao produtoDao, Result result,
			Validator validator) {
		this.produtoDao = produtoDao;
		this.result = result;
		this.validator = validator;
	}

	@Get("/produto")
	public List<Produto> lista() {
		return produtoDao.findAll();
	}

	@Restrito
	@Get("/produto/novo")
	public void formulario() {
	}

	@Restrito
	@Post("/produto/")
	public void adiciona(Produto produto) {
		validator.validate(produto);
		validator.onErrorRedirectTo(this).formulario();
		produtoDao.adicao(produto);
		result.redirectTo(this).lista();
	}

	@Restrito
	@Get("/produto/{id}")
	public Produto edita(Long id) {
		return produtoDao.findById(id);
	}

	@Restrito
	@Put("/produto/{produto.id}")
	public void altera(Produto produto) {
		validator.validate(produto);
		validator.onErrorRedirectTo(this).formulario();
		produtoDao.edicao(produto);
		result.redirectTo(this).lista();
	}

	@Restrito
	@Delete("/produto/{id}")
	public void remove(Long id) {
		Produto produto = produtoDao.findById(id);
		produtoDao.exclusao(produto);
		result.redirectTo(this).lista();
	}

	public List<Produto> busca(String nome) {
		result.include("nome", nome);
		return produtoDao.findByNome(nome);
	}

	@Get("/produto/busca.json")
	public void buscaJson(String q) {
		result.use(Results.json()).withoutRoot().from(
				produtoDao.findByNome(q)).exclude("id", "descricao")
				.serialize();

	}

}
