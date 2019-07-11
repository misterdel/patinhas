package pt.javeiros.patinhas.sessao;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pt.javeiros.patinhas.modelo.Utilizador;

/**
 * Filter checks if LoginBean has loginIn property set to true.
 * If it is not set then request is being redirected to the login.xhml page.
 * 
 * @author itcuties
 *
 */
public class LoginFilter implements Filter {

	
	/**
	 * Checks if user is logged in. If not it redirects to the login.xhtml page.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Get the loginBean from session attribute
		Utilizador utilizador = (Utilizador)((HttpServletRequest)request).getSession().getAttribute("utilizador");
		
		// For the first application request there is no loginBean in the session so user needs to log in
		// For other requests loginBean is present but we need to check if user has logged in successfully
		if (utilizador == null) {
			String contextPath = ((HttpServletRequest)request).getContextPath();
			((HttpServletResponse)response).sendRedirect(contextPath + "/login.jsf");
		}
		
		chain.doFilter(request, response);
			
	}

	public void init(FilterConfig config) throws ServletException {
		// Nothing to do here!
	}

	public void destroy() {
		// Nothing to do here!
	}


	
}
