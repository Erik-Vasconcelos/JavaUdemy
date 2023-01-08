package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Revisao_f");
		EntityManager em = emf.createEntityManager();
		
		Produto produto = new Produto("Celular");
		
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

}
