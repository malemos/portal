package br.com.portal.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Produto {

	@Id
	@GeneratedValue
	private Long id;

	@Length(min = 3, message = "O nome tem que ter no mínimo 3 caracteres.")
	@NotEmpty(message = "Não pode ser vazio.")
	private String nome;

	@Length(max = 40, message = "O nome tem que ter no mínimo 3 caracteres.")
	@NotEmpty(message = "Não pode ser vazio.")
	private String descricao;

	@Min(value = 0, message = "O valor mínimo para o preço é zero.")
	private BigDecimal preco;

	private Long quantidade;

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
