import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;

import modelo.basico.Usuario;

class TesteUsuario {

	/*@Test
	void testNovoUsuario() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("revisao-jpa");
		EntityManager em= emf.createEntityManager();
		
		Usuario novo = new Usuario("Teste", "teste@lanche.com.br");
		
		em.getTransaction().begin();
		em.persist(novo); //para poder funcionar o persist precia estar em um contexto de transacao
		em.getTransaction().commit();
		System.out.println("O id gerado foi o: " + novo.getId());
		
		em.close();
		emf.close();
	}
	
	@Test
	void obterUsuario() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("revisao-jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, 3L);
		System.out.println(usuario.toString());
		
		em.close();
		emf.close();
	}
*/
	
	/*@Test
	void obterUsuarios() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("revisao-jpa");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select u from Usuario u";
		
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		query.setMaxResults(5);
		
		List<Usuario> usuarios = query.getResultList();
		
		for(Usuario usuario : usuarios) {
			System.out.println("ID: "+usuario.getId()
			+", Nome: " + usuario.getNome());
		}
		  
		em.close();
		emf.close();
	}

	@Test
	void alterarUsuario() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("revisao-jpa");
		EntityManager em = emf.createEntityManager();
		 
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 7L);
		usuario.setNome("Leonardo");
		usuario.setEmail("leonardo@lanche.com");
		
		em.merge(usuario);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}*/
	
	/*
	@Test
	void alterarUsuario2() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("revisao-jpa");
		EntityManager em = emf.createEntityManager();
		 
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 7L);
		usuario.setNome("Leonardo Alterado");
		
//		Quando voce faz uma consulta dentro de um conxteto transacional,
//		 *  a entidade vai ficar em um estado gerenciado, ou seja,
//		 *   qualquer mudanca que voce faca, essa alteracao será sincronizada
//		 *    com o banco de dados mesmo que voce nao chame o método merge()
//		
		em.merge(usuario);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

	@Test
	void alterarUsuario3() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("revisao-jpa");
		EntityManager em = emf.createEntityManager();
		 
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 7L);
		em.detach(usuario);
		
		usuario.setNome("Leonardo");
		
		em.merge(usuario);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}*/
	
	@Test
	void removerUsuario() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("revisao-jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, 8L);
		
		if(usuario != null) {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
		}
		
		em.close();
		emf.close();
		
	}
}

