package br.com.ifrn.portal.sm.models.infrastructure;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * The Class DAOGeneric.
 *
 * @author erikv
 * @version 1.0
 * @param <T> the generic type to persistence
 * @system DAOGeneric.java
 * @date 11:42:21 8 de jan. de 2023 2023
 */

public class DAOGeneric<T> {
	
	/** The emf. */
	private static EntityManagerFactory emf;
	
	/** The em. */
	private EntityManager em;
	
	/** The classe. */
	private Class<T> classe;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("sistema_mercado");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Instantiates a new DAO generic.
	 */
	public DAOGeneric() {
		this(null);
	}
	
	/**
	 * Instantiates a new DAO generic.
	 *
	 * @param classe the classe
	 */
	public DAOGeneric(Class<T> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}

	/**
	 * Open transaction.
	 *
	 * @return the DAO generic
	 */
	public DAOGeneric<T> openTransaction(){
		em.getTransaction().begin();
		return this;
	}
	
	/**
	 * Close transaction.
	 *
	 * @return the DAO generic
	 */
	public DAOGeneric<T> closeTransaction(){
		em.getTransaction().commit();
		return this;
	}
	
	/**
	 * Insert.
	 *
	 * @param entity the entity
	 * @return the DAO generic
	 */
	public DAOGeneric<T> insert(T entity) {
		em.persist(entity);
		return this;
	}
	
	/**
	 * Insert atomic.
	 *
	 * @param entity the entity
	 * @return the DAO generic
	 */
	public DAOGeneric<T> insertAtomic(T entity) {
		return openTransaction().insert(entity).closeTransaction();
	}
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the t
	 */
	public T findById(Long id){
		return em.find(classe, id);
	}
	
	/**
	 * Find all.
	 *
	 * @param limit the limit
	 * @param skip the skip
	 * @return the list
	 */
	public List<T> findAll(int limit, int skip){
		//TODO implement this method
		return null;
	}
	
	/**
	 * Update.
	 *
	 * @param entity the entity
	 * @return the DAO generic
	 */
	public DAOGeneric<T> update(T entity){
		em.merge(entity);
		return this;
	}
	
	/**
	 * Delete.
	 *
	 * @param entity the entity
	 * @return the DAO generic
	 */
	public DAOGeneric<T> delete(T entity){
		em.remove(entity);
		return this;
	}
	
}
