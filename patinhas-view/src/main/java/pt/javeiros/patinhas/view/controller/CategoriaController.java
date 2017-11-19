package pt.javeiros.patinhas.view.controller;

import pt.javeiros.patinhas.execptions.BusinessExecption;
import pt.javeiros.patinhas.modelo.Categoria;
import pt.javeiros.patinhas.service.CategoriaService;
import pt.javeiros.patinhas.util.*;
import pt.javeiros.patinhas.view.util.UtilMensagem;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@ViewScoped
public class CategoriaController implements Serializable {

	private static final long serialVersionUID = 6108674560971132246L;

	private Categoria categoria;

	private CategoriaService service;

	private List<Categoria> categorias;

	private boolean consulta;

    @PostConstruct
	public void iniciar(){
	    consulta = true;
	}
	public void novo() {

	    categoria = new Categoria();

        consulta = false;
	}

	public void salvar(){

		service = new CategoriaService();

		service.salvar(categoria);

		categoria = new Categoria();

		UtilMensagem.adicionarMensagemSucesso("Operação realizada com sucesso!");

	}
	public void alterar(){

		service = new CategoriaService();

		service.alterar(categoria);

		categoria = new Categoria();

		UtilMensagem.adicionarMensagemSucesso("Operação realizada com sucesso!");

        iniciar();
	}

	public void consultar() {

		service = new CategoriaService();

		try {
			categorias =  service.consultar(categoria);
			if(UtilColecao.isEmpty(categorias)){
				UtilMensagem.adicionarMensagemAlerta("Nenhum resultado encontrado!");
			}
		} catch (BusinessExecption businessExecption) {
			UtilMensagem.adicionarMensagemAlerta(businessExecption.getMensagem());
		}
	}

    public void remover(){

        service = new CategoriaService();

        service.remover(categoria.getId());

        categorias.remove(categoria);

        categoria = new Categoria();

        UtilMensagem.adicionarMensagemSucesso("Operação realizada com sucesso!");

    }

	public Categoria getCategoria() {
		if(categoria == null){

			categoria = new Categoria();
		}
		return categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

    public boolean isConsulta() {
        return consulta;
    }

    public void setConsulta(boolean consulta) {
        this.consulta = consulta;
    }

    public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
