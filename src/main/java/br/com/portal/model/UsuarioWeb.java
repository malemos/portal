package br.com.portal.model;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@SessionScoped
@Component
public class UsuarioWeb {

	private Usuario logado;

	public void login(Usuario usuario) {
		this.logado = usuario;
	}

	public String getNome() {
		return logado.getNome();
	}

	public boolean isLogado() {
		return logado != null;
	}

	public void logout() {
		this.logado = null;
	}

}
