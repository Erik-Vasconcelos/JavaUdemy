package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	//bloco estatico para a inicializacao do atributo estatico
	static {
		try {
			emf=Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em=emf.createEntityManager();
	}
	
	public DAO<E> abriT(){
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharT(){
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade){
		em.persist(entidade);;
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade){
		return this.abriT().incluir(entidade).fecharT();
	}
	
	public E obter(Object id){
		return em.find(classe, id);
	}
	public List<E> obterTodos(){
		return this.obterTodos(10, 0);
	}
	
	public List<E> obterTodos(int qtd, int deslocamento){
		if(classe==null) {
			throw new UnsupportedOperationException("classe nula");
		}
		
		String jpql = "SELECT e FROM "+classe.getName()+" e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		
		query.setMaxResults(qtd);
		query.setFirstResult(deslocamento);
		return query.getResultList();
	}
	 
	public List<E> consultar(String nomeConsulta, Object... params){
		TypedQuery<E> query  = em.createNamedQuery(nomeConsulta, classe);
		
		for(int i=0; i< params.length; i+=2) {
			query.setParameter(params[i].toString(), params[i+1]);
		}
		
		return query.getResultList();
	}
	
	public E consultarUm(String nomeConsulta, Object... params) {
		List<E> lista = consultar(nomeConsulta, params);
		return lista.isEmpty()? null: lista.get(0);
	}
	
	public void fechar() {
		em.close();
	}
	
	
	
	
}
