package pt.javeiros.patinhas.view.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pt.javeiros.patinhas.modelo.Utilizador;


@ManagedBean
@ViewScoped
public class UtilizadorController implements Serializable {

	private static final long serialVersionUID = 6108674560971132246L;

	private Utilizador utilizador;

	public void salvar() {

		System.out.println("teste");
	}

	public Utilizador getUtilizador() {
		if(utilizador == null) {
			utilizador = new Utilizador();
		}
		return utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}

}
