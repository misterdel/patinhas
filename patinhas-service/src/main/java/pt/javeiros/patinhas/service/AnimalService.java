/**
 * 
 */
package pt.javeiros.patinhas.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pt.javeiros.patinhas.dao.interfaces.DAO;
import pt.javeiros.patinhas.interceptors.Transactional;
import pt.javeiros.patinhas.modelo.Animal;
import pt.javeiros.patinhas.util.UtilObjeto;

/**
 * @author cahangoa
 *
 */
public class AnimalService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private DAO<Animal> daoAnimal;

	@Transactional
	public void save(Animal u) {

		if (UtilObjeto.isNull(u.getId())) {
			daoAnimal.save(u);
		} else {
			daoAnimal.update(u);
		}
	}

	public Animal findById(Serializable id) {
		Animal ux = daoAnimal.finById(id);
		System.out.println(ux.toString());
		return ux;
	}

	@Transactional
	public void remover(Animal u) {
		if (UtilObjeto.isNotNull(daoAnimal.finById(u.getId()))) {
			daoAnimal.remove(u);
		}

	}

	@Transactional
	public List<Animal> getAll() {
		return daoAnimal.getAll();

	}

}
