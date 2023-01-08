package br.com.marttech.sg.model.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {

	protected static EntityManagerFactory emf;
	protected EntityManager em;
	protected Class<E> classe;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("system_application");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public DAO() {
		this(null);
	}

	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}

	public DAO<E> abrirT() {
		em.getTransaction().begin();
		return this;
	}

	public DAO<E> fecharT() {
		em.getTransaction().commit();
		return this;
	}

	public DAO<E> inserirE(E entidade) {
		em.persist(entidade);
		return this;
	}
	
	public long startHbernate() {
		TypedQuery<Long>  query = em.createNamedQuery("verificarUsuarios", Long.class);
		return query.getSingleResult();
	}
	
	public long verificarQtdUsuarios() {
		TypedQuery<Long>  query = em.createNamedQuery("verificarUsuarios", Long.class);
		return query.getSingleResult();
	}

	public DAO<E> incluirAtomico(E entidade) {
		return this.abrirT().inserirE(entidade).fecharT();
	}

	public E bucarPorId(Long id) {
		return em.find(classe, id);
	}
	
	public DAO<E> atualizar(E entidade) {
		em.merge(entidade);
		return this;
	}
	
	public boolean atualizarEntity(E entidade) {
		em.merge(entidade);
		return true;
	}
	
	public DAO<E> desassociar(E entidade) {
		em.detach(entidade);
		return this;
	}
	
	public DAO<E> excluir(E Entidade) {
		em.remove(Entidade);
		return this;
	}
	
	public void fechar() {
		em.close();
	}

}
