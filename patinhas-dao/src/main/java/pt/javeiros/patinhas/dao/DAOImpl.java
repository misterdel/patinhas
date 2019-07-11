package pt.javeiros.patinhas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import pt.javeiros.patinhas.dao.interfaces.DAO;
import pt.javeiros.patinhas.modelo.Utilizador;

/**
 * Created by cahangoa on 14/06/2019.
 */

public class DAOImpl<T> implements DAO<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private @Inject EntityManager em;

	private final Class<T> classe;

	public DAOImpl(Class<T> classe, EntityManager em) {
		this.classe = classe;
		this.em = em;
	}

	@Override
	public T save(T entity) {
		em.persist(entity);
		em.flush();
		return entity;
	}

	@Override
	public T update(T entity) {
		entity = em.merge(entity);
		em.flush();
		return entity;
	}

	@Override
	public List<T> getAll() {
		String sql = "Select e from " + this.classe.getSimpleName() + " e";
		TypedQuery<T> query = em.createQuery(sql, this.classe);
		return query.getResultList();
	}

	@Override
	public void remove(T entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
		em.flush();
	}

	@Override
	public T finById(Serializable id) {
		return em.find(this.classe, id);
	}

	@Override
	public T findByNif(Long nif) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> query = cb.createQuery(this.classe);
		Root<T> root = query.from(this.classe);

		query = query.select(root).where(cb.equal(root.get("nif"), nif));

		List<T> list = em.createQuery(query).getResultList();

		if (list == null || list.size() == 0) {
			return null;
		}

		return list.get(0);
	}

	public Class<T> getClasse() {
		return classe;
	}

	@Override
	public Utilizador login(Utilizador u) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> query = cb.createQuery(this.classe);
		Root<T> root = query.from(this.classe);

		query = query.select(root).where(cb.equal(root.get("nif"), u.getNif()),
				cb.equal(root.get("password"), u.getPassword()));

		Utilizador utilizador = (Utilizador) em.createQuery(query).getSingleResult();

		if (utilizador == null) {
			return null;
		}

		return utilizador;
	}

	/**
	 * public Session getSession() { return em.getDelegate(); }
	 */
}
