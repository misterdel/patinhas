/**
 * 
 */
package pt.javeiros.patinhas.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pt.javeiros.patinhas.dao.interfaces.DAO;
import pt.javeiros.patinhas.interceptors.Transactional;
import pt.javeiros.patinhas.modelo.Perfil;

/**
 * @author cahangoa
 *
 */
@Named(value = "perfService")
@RequestScoped
public class PerfilService  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DAO<Perfil> daoPerfil;

	@Transactional
	public void save(Perfil p) {
		daoPerfil.save(p);
	}

	@Transactional
	public List<Perfil> getAll() {
		return daoPerfil.getAll();
	}
}
