package br.com.portal.model.configuration;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.portal.controller.UsuarioController;
import br.com.portal.model.UsuarioWeb;

@Intercepts
public class AutorizacaoInterceptor implements Interceptor {

	private final UsuarioWeb usuario;
	private final Result result;

	public AutorizacaoInterceptor(UsuarioWeb usuario, Result result) {
		this.usuario = usuario;
		this.result = result;
	}

	public boolean accepts(ResourceMethod method) {
		return !usuario.isLogado() && method.containsAnnotation(Restrito.class);
	}

	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		result.redirectTo(UsuarioController.class).loginForm();
	}

}
