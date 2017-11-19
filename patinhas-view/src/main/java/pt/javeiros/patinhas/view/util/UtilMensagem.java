package pt.javeiros.patinhas.view.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UtilMensagem implements Serializable {

	private static final long	serialVersionUID	= 1L;

	public static void adicionarMensagemSucesso(final String mensagem) {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem));
	}

	public static void adicionarMensagemAlerta(final String mensagem) {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, mensagem));
	}


	public static void adicionarMensagemErro(final String mensagem) {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem));
	}
}
