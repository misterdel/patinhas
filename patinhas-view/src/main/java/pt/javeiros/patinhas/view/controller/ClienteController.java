package pt.javeiros.patinhas.view.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pt.javeiros.patinhas.modelo.Cliente;

@ManagedBean
@ViewScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 4209347987845624148L;

	private Cliente cliente;

	public void salvar() {
		
		System.out.println(cliente.getNome());
		
	}
	
	
	public Cliente getCliente() {
		
		if(cliente == null) {
			
			cliente = new Cliente();
		}
		
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
