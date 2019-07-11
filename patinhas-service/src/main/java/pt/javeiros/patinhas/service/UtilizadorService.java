package pt.javeiros.patinhas.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

import pt.javeiros.patinhas.dao.interfaces.DAO;
import pt.javeiros.patinhas.interceptors.Transactional;
import pt.javeiros.patinhas.modelo.Utilizador;
import pt.javeiros.patinhas.util.UtilObjeto;

@Named(value = "utilService")
@RequestScoped
public class UtilizadorService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DAO<Utilizador> daoUtilizador;

	@Transactional
	public void save(Utilizador u) {
		daoUtilizador.save(u);
	}

	@Transactional
	public Utilizador update(Utilizador u) {
		Utilizador ux = daoUtilizador.update(u);
		return UtilObjeto.isNotNull(ux) ? ux : null;
	}

	@Transactional
	public Utilizador findById(Serializable id) {
		Utilizador ux = daoUtilizador.finById(id);
		return UtilObjeto.isNotNull(ux) ? ux : null;
	}

	@Transactional
	public Utilizador findByNif(Long nif) {
		Utilizador ux = daoUtilizador.findByNif(nif);
		return UtilObjeto.isNotNull(ux) ? ux : null;
	}

	@Transactional
	public void remover(Utilizador u) {
		if (UtilObjeto.isNotNull(daoUtilizador.finById(u.getId()))) {
			daoUtilizador.remove(u);
		}

	}

	@Transactional
	public List<Utilizador> getAll() {
		return daoUtilizador.getAll();

	}

	public DAO<Utilizador> getDaoService() {
		return daoUtilizador;
	}

	public void setDaoService(DAO<Utilizador> daoService) {
		this.daoUtilizador = daoService;
	}

	
	@Transactional
	public Utilizador login(Utilizador u) {
		Utilizador ux = daoUtilizador.login(u);
		return UtilObjeto.isNotNull(ux) ? ux : null;
	}
	
	
	
	/**  public Utilizador getUtilizador(String nomeUsuario, String senhaUsuario) {

	        try {
	        	Utilizador pessoa = (Utilizador) em
	                         .createQuery(
	                                     "SELECT u from Pessoa u where u.nomeUsuario = :name and u.senhaUsuario = :senha")
	                         .setParameter("name", nomeUsuario)
	                         .setParameter("senha", senhaUsuario).getSingleResult();

	              return pessoa;
	        } catch (NoResultException e) {
	              return null;
	        }
	  }*/
	
	
}
