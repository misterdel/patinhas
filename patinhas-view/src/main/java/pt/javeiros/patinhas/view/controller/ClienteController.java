package pt.javeiros.patinhas.view.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pt.javeiros.patinhas.modelo.Utilizador;

@ManagedBean
@ViewScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 4209347987845624148L;

	private Utilizador cliente;

	public void salvar() {
		
		System.out.println(cliente.getNome());
		
	}
	
	
	public Utilizador getCliente() {
		
		if(cliente == null) {
			
			cliente = new Utilizador();
		}
		
		return cliente;
	}

	public void setCliente(Utilizador cliente) {
		this.cliente = cliente;
	}

}
