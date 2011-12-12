package br.com.portal.controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.portal.model.Carrinho;
import br.com.portal.model.Item;
import br.com.portal.model.dao.ProdutoDao;

@Resource
public class CarrinhoController {

	private final Carrinho carrinho;
	private final ProdutoDao produtoDao;
	private final Result result;

	public CarrinhoController(Carrinho carrinho, ProdutoDao produtoDao,
			Result result) {
		this.carrinho = carrinho;
		this.produtoDao = produtoDao;
		this.result = result;
	}

	@Post("/carrinho")
	public void adiciona(Item item) {
		produtoDao.findByProduto(item.getProduto());
		carrinho.adiciona(item);

		result.redirectTo(ProdutoController.class).lista();
	}

	@Get("/carrinho")
	public void visualiza() {
	}

	@Delete
	@Path("/carrinho/{indiceItem}")
	public void remove(int indiceItem) {
		carrinho.remove(indiceItem);
		result.redirectTo(this).visualiza();
	}

}
