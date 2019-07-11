/**
 * 
 */
package pt.javeiros.patinhas.view.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import pt.javeiros.patinhas.modelo.Utilizador;
import pt.javeiros.patinhas.sessao.SessionUtils;
import pt.javeiros.patinhas.util.UtilObjeto;
import pt.javeiros.patinhas.view.util.UtilMensagem;

/**
 * @author cahangoa
 *
 */
@SessionScoped
@ManagedBean(name = "loginBean")
public class LoginController {

	private Long nif;
	private String password;
	private boolean remember;
	private @Inject UtilizadorController utilizadorController;
	private Utilizador utilizador;

	public void doLogin() {

		if (nif != null && password != null) {

			if (UtilObjeto.isNotNull(utilizadorController.validarNif(nif))) {
				/**
				 * String passIncriptada = UtilConverter.convertStringToMd5(this.password);
				 * Utilizador util = utilizadorController.login(this.nif, passIncriptada);
				 */
				 utilizador = utilizadorController.login(this.nif, this.password);

				if (UtilObjeto.isNotNull(utilizador)) {
					SessionUtils.getContext().getExternalContext().getSessionMap().put("utilizador", utilizador);
					UtilMensagem.adicionarMensagemSucesso("Utilizador logado com sucesso!");

					try {
						SessionUtils.getContext().getExternalContext().redirect("/patinhas/paginas/index.jsf");
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					UtilMensagem.adicionarMensagemErro("O utilizador não foi autenticado!");
				}
			} else {
				UtilMensagem.adicionarMensagemErro("O nif não é válido");
			}

		} else {
			UtilMensagem.adicionarMensagemErro("nif ou password invalido!");
		}
	}

	public void doLogout() {
		//FacesContext context = FacesContext.getCurrentInstance();
		SessionUtils.getContext().getExternalContext().invalidateSession();
		try {
			SessionUtils.getContext().getExternalContext().redirect("/login.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * HttpSession session = SessionUtils.getSession(); session.invalidate(); return
		 * "/login/login.xhtml?faces-redirect=true";
		 */
	}

	/**
	 * @return the utilizadorController
	 */
	public UtilizadorController getUtilizadorController() {
		return utilizadorController;
	}

	/**
	 * @param utilizadorController
	 *            the utilizadorController to set
	 */
	public void setUtilizadorController(UtilizadorController utilizadorController) {
		this.utilizadorController = utilizadorController;
	}

	public Long getNif() {
		return nif;
	}

	public void setNif(Long nif) {
		this.nif = nif;
	}

	public String getPassword() {
		// UtilObjeto.isNotNull(passIncriptada) ? passIncriptada : null;
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

	public Utilizador getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}
}
