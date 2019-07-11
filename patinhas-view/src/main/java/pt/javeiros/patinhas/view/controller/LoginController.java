/**
 * 
 */
package pt.javeiros.patinhas.view.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

import pt.javeiros.patinhas.modelo.Utilizador;
import pt.javeiros.patinhas.sessao.SessionUtils;
import pt.javeiros.patinhas.util.UtilObjeto;
import pt.javeiros.patinhas.view.util.UtilConverter;
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

	public String doLogin() {

		if (nif != null && password != null) {

			if (UtilObjeto.isNotNull(utilizadorController.validarNif(nif))) {
				/**
				 * String passIncriptada = UtilConverter.convertStringToMd5(this.password);
				 * Utilizador util = utilizadorController.login(this.nif, passIncriptada);
				 */
				Utilizador utilizador = utilizadorController.login(this.nif, this.password);

				if (UtilObjeto.isNotNull(utilizador)) {
					SessionUtils.SetUtilizadorSessao(utilizador);
					UtilMensagem.adicionarMensagemSucesso("Utilizador logado com sucesso!");
					// return "/index.jsf";
					// return "login/index.xhtml";
					return "/paginas/index.xhtml?faces-redirect=true";
				} else {
					UtilMensagem.adicionarMensagemErro("O utilizador não foi autenticado!");
					return "/login.xhtml?faces-redirect=true";
				}
			} else {
				UtilMensagem.adicionarMensagemErro("O nif não é válido");
				return "/login.xhtml?faces-redirect=true";
			}

		} else {
			UtilMensagem.adicionarMensagemErro("nif ou password invalido!");
			return "/login.xhtml?faces-redirect=true";
		}
	}

	public String doLogout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "/login/login.xhtml?faces-redirect=true";
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
		return UtilObjeto.isNotNull(nif) ? nif : null;
	}

	public void setNif(Long nif) {
		this.nif = nif;
	}

	public String getPassword() {
		// UtilObjeto.isNotNull(passIncriptada) ? passIncriptada : null;
		return UtilObjeto.isNotNull(password) ? password : null;
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

}
