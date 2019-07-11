package pt.javeiros.patinhas.sessao;

import java.io.IOException;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pt.javeiros.patinhas.modelo.Utilizador;
import pt.javeiros.patinhas.util.UtilObjeto;
import pt.javeiros.patinhas.view.controller.LoginController;

@WebFilter({"/pageFilter"})
public class PageFilter implements Filter {

	// private final String urlLogin = "/AuthenticateFilter";

	private final String pageLogin = "/paginas/login/login.xhtml";

	private final String pageEntrar = "/paginas/login/entrar.xhtml";

	private final String pageRegistrar = "/paginas/login/registrar.xhtml";

	private final String pageEsqueciSenha = "/paginas/login/esqueci-senha.xhtml";

	// private final String servico= "/servico";

	private final String CSS = ".css";

	private final String JS = ".js";

	private final String PNG = ".png";

	private final String JPG = ".jpg";

	private @Inject LoginController loginBean;

	// Utilizador utilizador;

	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String contextPath = ((HttpServletRequest) request).getContextPath();
		// String contextPath = ((HttpServletRequest) request).getContextPath();

	//	FacesContext context = FacesContext.getCurrentInstance();

		Utilizador utilizador = (Utilizador) ((HttpServletRequest) request).getSession().getAttribute("utilizador");

		if (utilizador == null || contextPath.endsWith("/login.xhtml")) {
			((HttpServletResponse) response).sendRedirect(contextPath + "/login/login.xhtml");
			// ((HttpServletResponse) response).sendRedirect(contextPath + "/login.jsf");

		//	context.getExternalContext().redirect("login/login.xhtml");
		} else {

			chain.doFilter(request, response);

		}

		/**
		 * HttpServletRequest httpRequest = (HttpServletRequest) request;
		 * 
		 * String path = httpRequest.getServletPath();
		 * 
		 * Utilizador utilizador= (Utilizador)
		 * httpRequest.getSession().getAttribute("utilizador");
		 * 
		 * if (UtilObjeto.isNotNull(utilizador) || path.equals(urlLogin) ||
		 * isStylePaginasLiberadas(path) || isStyle(path) || path.equals(servico)) {
		 * 
		 * chain.doFilter(request, response);
		 * 
		 * } else {
		 * 
		 * abrirLogin(response, httpRequest);
		 * 
		 * }
		 */

		/**
		 * try {
		 * 
		 * HttpServletRequest reqt = (HttpServletRequest) request; HttpServletResponse
		 * resp = (HttpServletResponse) response; // HttpSession ses =
		 * reqt.getSession(false);
		 * 
		 * // boolean auth = reqt.getSession().getAttribute("utilizador") != null;
		 * boolean auth = SessionUtils.getUtilizadorSessao() != null; String
		 * newCurrentPage = ((HttpServletRequest) request).getServletPath();
		 * 
		 * // String reqURI = reqt.getRequestURI(); if (auth) { chain.doFilter(request,
		 * response); return; } else { reqt.setAttribute("messagem", "O utilizador não
		 * existe no sistema"); } } catch (Exception e) {
		 * System.out.println(e.getMessage()); }
		 * 
		 * RequestDispatcher view = request.getRequestDispatcher("login.xhtml");
		 * view.forward(request, response);
		 */
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	private boolean isStylePaginasLiberadas(String path) {

		return path.contains(pageLogin) || path.contains(pageEntrar) || path.contains(pageRegistrar)
				|| path.contains(pageEsqueciSenha);
	}

	private boolean isStyle(String path) {

		return path.endsWith(CSS) || path.endsWith(JS) || path.endsWith(PNG) || path.endsWith(JPG);
	}

	private void abrirLogin(ServletResponse response, HttpServletRequest httpRequest)
			throws ServletException, IOException {
		HttpServletResponse resp = (HttpServletResponse) response;

		resp.sendRedirect("/patinhas/#/");
	}

}