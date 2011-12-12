package br.com.portal.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.portal.model.Usuario;
import br.com.portal.model.UsuarioWeb;
import br.com.portal.model.dao.UsuarioDao;

@Resource
public class UsuarioController {

	private final UsuarioDao usuarioDao;
	private final Result result;
	private final Validator validator;
	private final UsuarioWeb usuarioWeb;

	public UsuarioController(UsuarioDao dao, Result result,
			Validator validator, UsuarioWeb usuarioWeb) {
		this.usuarioDao = dao;
		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
	}

	@Post
	@Path("/usuario")
	public void adiciona(Usuario usuario) {
		if (usuarioDao.existeUsuario(usuario)) {
			validator.add(new ValidationMessage("Login já existe",
					"usuario.login"));
		}
		validator.onErrorUsePageOf(UsuarioController.class).novo();
		usuarioDao.add(usuario);
		result.redirectTo(ProdutoController.class).lista();
	}

	public void novo() {
	}

	@Get
	@Path("/login")
	public void loginForm() {
	}

	@Post
	@Path("/login")
	public void login(Usuario usuario) {
		Usuario carregado = usuarioDao.load(usuario);
		if (carregado == null) {
			validator.add(new ValidationMessage("Login e/ou senha inválidos",
					"usuario.login"));
		}
		validator.onErrorUsePageOf(UsuarioController.class).loginForm();
		usuarioWeb.login(carregado);
		result.redirectTo(ProdutoController.class).lista();
	}

	@Path("/logout")
	public void logout() {
		usuarioWeb.logout();
		result.redirectTo(ProdutoController.class).lista();
	}

}
