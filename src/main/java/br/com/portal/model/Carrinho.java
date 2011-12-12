package br.com.portal.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class Carrinho {
	private List<Item> itens = new ArrayList<Item>();

	private BigDecimal valorTotal = BigDecimal.ZERO;

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void adiciona(Item item) {
		this.getItens().add(item);
		BigDecimal valorProduto = item.getProduto().getPreco();
		valorProduto.multiply(new BigDecimal(item.getQuantidade()));
		this.valorTotal = valorTotal.add(valorProduto);
	}

	public Integer getTotalDeItens() {
		Integer total = 0;
		for (Item item : this.itens) {
			total+=item.getQuantidade();
		}
		return total;
	}
	
	public void remove(int indiceItem) {
	    Item removido = itens.remove(indiceItem);
	    BigDecimal valorProduto = removido.getProduto().getPreco();
		valorProduto.multiply(new BigDecimal(removido.getQuantidade()));
		this.valorTotal = valorTotal.subtract(valorProduto);
	}

}
