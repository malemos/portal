package br.com.portal.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public class Usuario {

	@Id
	private String login;

	@Length(min=6, message="A senha deve ter no mínimo 6 caracteres.")
	private String senha;

	private String nome;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
