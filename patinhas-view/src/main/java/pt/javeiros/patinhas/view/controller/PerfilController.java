/**
 * 
 */
package pt.javeiros.patinhas.view.controller;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import pt.javeiros.patinhas.modelo.Perfil;
import pt.javeiros.patinhas.service.PerfilService;

/**
 * @author cahangoa
 *
 */
@ViewScoped
@ManagedBean(name = "perfBean")
public class PerfilController implements Serializable {

	private static final long serialVersionUID = 1L;

	private @Inject PerfilService perfilService;
	private Perfil perfil;
	private List<Perfil> perfis;

	
	
	private boolean consulta;

	@PostConstruct
	public void init() {
		consulta = true;
		perfis = new LinkedList<Perfil>();
		perfis = getAllPerfis();
	}
	
	
	public List<Perfil> getAllPerfis() {
		return perfilService.getAll();
	}
	
	/**
	 * @return the perfis
	 */
	public List<Perfil> getPerfis() {
		return perfis;
	}

	/**
	 * @param perfis the perfis to set
	 */
	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}



	/**
	 * @return the perfil
	 */
	public Perfil getPerfil() {
		return perfil;
	}
	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	/**
	 * @return the perfilService
	 */
	public PerfilService getPerfilService() {
		return perfilService;
	}

	/**
	 * @param perfilService the perfilService to set
	 */
	public void setPerfilService(PerfilService perfilService) {
		this.perfilService = perfilService;
	}

	/**
	 * @return the consulta
	 */
	public boolean isConsulta() {
		return consulta;
	}

	/**
	 * @param consulta the consulta to set
	 */
	public void setConsulta(boolean consulta) {
		this.consulta = consulta;
	}

	
	
}
