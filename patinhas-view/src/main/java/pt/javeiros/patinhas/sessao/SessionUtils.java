package pt.javeiros.patinhas.sessao;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import pt.javeiros.patinhas.modelo.Utilizador;

public class SessionUtils {
	
	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public static Utilizador getUtilizadorSessao() {
		//HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return (Utilizador) getSession().getAttribute("utilizador");
	}
	
	public static void SetUtilizadorSessao(Utilizador utilizador) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	     session.setAttribute("utilizador",utilizador );
	}

	public static String getUserId() {
		HttpSession session = getSession();
		if (session != null)
			return (String) session.getAttribute("userid");
		else
			return null;
	}
}
