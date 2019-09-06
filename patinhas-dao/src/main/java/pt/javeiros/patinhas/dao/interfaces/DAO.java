/**
 * 
 */
package pt.javeiros.patinhas.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import pt.javeiros.patinhas.modelo.Utilizador;

/**
 * @author cahangoa
 *
 */
public interface DAO<T> extends Serializable {

	T save(T entity);

	T update(T entity);

	void remove(T entity);

	T finById(Serializable id);

	List<T> getAll();

	T findByNif(Long id);
	
	List<T> findRacaForCategoria(Long id); //analisar bem 
	
	Utilizador login(Utilizador u);
}
