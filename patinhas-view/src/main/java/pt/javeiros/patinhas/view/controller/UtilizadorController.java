package pt.javeiros.patinhas.view.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.UploadedFile;

import pt.javeiros.patinhas.modelo.Utilizador;
import pt.javeiros.patinhas.service.UtilizadorService;
import pt.javeiros.patinhas.util.UtilObjeto;

@ManagedBean
@ViewScoped
public class UtilizadorController implements Serializable {

	private static final long serialVersionUID = 1L;

	private UtilizadorService utilizadorService;
	private Utilizador utilizador;
	private UploadedFile fileUpload;

	private List<Utilizador> utilizadores;
	private boolean consulta;

	@PostConstruct
	public void iniciar() {
		consulta = true;
		
		//TODO (mudar para o lazy do primeifaces)
		utilizadores= getUtilizadorService().findAllUtilizadors();
		
		for(Utilizador utilizador : utilizadores) {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);			
			session.setAttribute("foto_"+utilizador.getNome(), utilizador.getFoto());
		}
		
	}

	
	public UtilizadorService getUtilizadorService() {
		return UtilObjeto.isNull(utilizadorService) ? utilizadorService = new UtilizadorService() : utilizadorService;
	}
	
	public void setUtilizadorService(UtilizadorService utilizadorService) {
		this.utilizadorService = utilizadorService;
	}
	
	
	public Utilizador getUtilizador() {
		return UtilObjeto.isNull(utilizador) ? utilizador = new Utilizador() : utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}

	public boolean isConsulta() {
		return consulta;
	}

	public void setConsulta(boolean consulta) {
		this.consulta = consulta;
	}

	public UploadedFile getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(UploadedFile fileUpload) {
		this.fileUpload = fileUpload;
	}
	
	public void voltar() {
		consulta = false;
	}

	public void novo() {
		utilizador = new Utilizador();
		consulta = true;
	}
	
	
	
	public List<Utilizador> getUtilizadores() {
		
		return utilizadores;
	}


	public void setUtilizadores(List<Utilizador> utilizadores) {
		this.utilizadores = utilizadores;
	}


	public void salvar() {
		
		if(!UtilObjeto.isNull(utilizador)) {
			if(!UtilObjeto.isNull(fileUpload))
				utilizador.setFoto(fileUpload.getContents());
			getUtilizadorService().salvar(utilizador);
		}
	}
	
	public List<Utilizador> findAllUtilizadors() {
		consulta = true;
		return getUtilizadorService().findAllUtilizadors();
	}
	
	
	
	public void findFotoUtilizadors() {
		if(!UtilObjeto.isNull(utilizador)) {
			 getUtilizadorService().findFoto(utilizador.getId());
		}
	}
}
