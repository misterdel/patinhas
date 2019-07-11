package pt.javeiros.patinhas.sessao;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.faces.application.ResourceHandler;
import javax.servlet.DispatcherType;

import pt.javeiros.patinhas.modelo.Utilizador;

/**
 * Filter checks if LoginBean has loginIn property set to true. If it is not set
 * then request is being redirected to the login.xhml page.
 * 
 * @author itcuties
 *
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, }, urlPatterns = { "/patinhas/*" })
public class LoginFilter implements Filter {

	/**
	 * Checks if user is logged in. If not it redirects to the login.xhtml page.
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession(false);

		String loginURI = request.getContextPath() + "/login.jsf";

		boolean loggedIn = session != null && session.getAttribute("utilizador") != null;
		boolean loginRequest = request.getRequestURI().equals(loginURI);
		boolean resourceRequest = request.getRequestURI()
				.startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);

		if (loggedIn || loginRequest || resourceRequest) {
			chain.doFilter(request, response);
		} else {
			response.sendRedirect(loginURI);
		}

	}

	public void init(FilterConfig config) throws ServletException {
		// Nothing to do here!
	}

	public void destroy() {
		// Nothing to do here!
	}

}
