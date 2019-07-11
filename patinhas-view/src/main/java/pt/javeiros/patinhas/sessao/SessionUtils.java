package pt.javeiros.patinhas.sessao;

import javax.faces.context.FacesContext;

public class SessionUtils {

	public static FacesContext getContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context;

	}

}
