package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class ObterUsusario {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario user = em.find(Usuario.class, 2L);
		//find -> recebe dois parametro 1-tipo da classe que voce quer mapear. 2- identificador do usuario 
		
		System.out.println(user.getNome());
		 
		em.close();
		emf.close();
	}
}
