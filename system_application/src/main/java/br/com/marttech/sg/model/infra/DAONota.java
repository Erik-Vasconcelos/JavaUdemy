package br.com.marttech.sg.model.infra;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.marttech.sg.model.dados.concreto.Nota;
import br.com.marttech.sg.model.memoria.ServidorMemory;

public class DAONota extends DAO<Nota>{
	
	public DAONota() {
		super(Nota.class);
	}
	
	public List<Nota> getAll(int qtd, int desl) {
		em = emf.createEntityManager();
		if (classe == null) {
			throw new UnsupportedOperationException();
		}
		String jpql = "SELECT n FROM " + classe.getSimpleName() + " n"
			+ " where servidor_id = " + ServidorMemory.getInstance().getId();
		
		TypedQuery query = em.createQuery(jpql, classe);
		
		query.setMaxResults(qtd);
		query.setFirstResult(desl);
		
		return query.getResultList();
	}
	
	public boolean excluirPorId(Long id) {
		String sql = "DELETE FROM nota WHERE id = ?";
		
		Query query = em.createNativeQuery(sql);
		query.setParameter(1, id);
		int result = query.executeUpdate();
		
		if(result != 0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean limiteAtingido() {
		Long idUsuario = ServidorMemory.getInstance().getId();
		
		TypedQuery query = em.createNamedQuery("consultarLimiteNotas", Long.class);
		query.setParameter("id", idUsuario);
		Long result = (Long) query.getSingleResult();
		
		System.out.println(result);
		return result < 10 ? false : true;
	}

}
