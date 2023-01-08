package br.com.marttech.sg.model.infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.marttech.sg.model.perfis.abstracts.Usuario;

public class DAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("sistema_aplicacao");
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
		em.getTransaction().commit();;
		return this;
	}
	
	public DAO<E> inserirE(E entidade) {
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade){
		return this.abrirT().inserirE(entidade).fecharT();
		
	}
	
	public E bucarPorId(Long id) {
		return em.find(classe, id);
	}
	
	public DAO<E> atualizar(E entidade){
		em.merge(entidade);
		return this;
	}
	
	public DAO<E> excluir(E Entidade){
		em.remove(Entidade);
		return this;
	}
	
	public List<E> obterTodos(int qtd, int desl) {
		if(classe == null) {
			throw new UnsupportedOperationException();
		}
		String jpql = "SELECT e FROM "+ classe.getName() + " e";
		
		TypedQuery query = em.createQuery(jpql, classe);
		query.setMaxResults(qtd);
		query.setFirstResult(desl);
		return query.getResultList();
	}
	
	public List<E> obterPorAproximacao(String valor){
		TypedQuery query =  em.createNamedQuery("consultaUsuariosAproxima", classe);
		query.setParameter("nome", "%"+ valor +"%");
		return query.getResultList();
	}
	public boolean validarAcesso(Long matricula, String senha) {
		TypedQuery query = em.createNamedQuery("consultarMatricula", classe);
		query.setParameter("valor", matricula);
		
		Usuario user = (Usuario) query.getResultList().get(0);
		if(user != null) {
			boolean condicao1 = user.getMatricula().equals(matricula);
			boolean condicao2 = user.getSenha().equals(senha);
			
			return condicao1 && condicao2;
		}
		return false;
	}
	
	public void fechar() {
		em.close();
	}
	
}
