package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Aluno;

public class DAO<T> {

	private static EntityManagerFactory emf;
	protected EntityManager em;
	private Class<T> classe;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("cadastro_aluno2.0-jpa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<T> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	public DAO<T> abrirT(){
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<T> fecharT(){
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<T> inserir(T entidade){
		em.persist(entidade);
		return this;
	}
	
	public DAO<T> obterEntidade(T entidade ) {
		em.find(classe, entidade);
		return this;
	}
	
	public T obterPorId(Long id) {
		return em.find(classe, id);
		
	}
	
	public DAO<T> remover(T entidade){
		em.remove(entidade);
		return this;
	}
	
	public DAO<T> atualizar(T entidade){
		em.merge(entidade);
		return this;
	}
	public void deletar(T entidade) {
		em.remove(entidade);
	}
	public void desassociarEntidade(T entidade) {
		//em.detach(entidade);
	}
	
	public DAO<T> removerEntidade(T entidade){
		abrirT().remover(entidade).fecharT().fechar();
		return this;
	}
	public DAO<T> incluirAtomico(T entidade){
		return this.abrirT().inserir(entidade).fecharT();
	}
	
	public List<T> obterTodos(int quat, int deslocamento){
		if(classe !=null) {
			throw new UnsupportedOperationException();
		}
		
		String jpql = "SELECT a FROM ALUNO a";
		TypedQuery<T> query = em.createQuery(jpql, classe);
		query.setMaxResults(quat);
		query.setFirstResult(deslocamento);
		
		return query.getResultList();
	}
	
	public void fechar() {
		em.close();
	}
}