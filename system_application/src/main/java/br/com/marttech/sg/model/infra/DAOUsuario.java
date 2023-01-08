package br.com.marttech.sg.model.infra;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.marttech.sg.model.memoria.ServidorMemory;
import br.com.marttech.sg.model.perfis.abstracts.Usuario;

public class DAOUsuario<E> extends DAO<E>{
	
	public DAOUsuario(Class<E> classe) {
		super(classe);
	}
	
	//TODO
	public ConfirmacaoCadastro incluirAtomicoComStatus(E entidade) {
		try {
			super.incluirAtomico(entidade);
			
			return new ConfirmacaoCadastro(false, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ConfirmacaoCadastro(false, null);
		}
		
	}
	
	public List<E> obterTodos(int qtd, int desl) {
		if (classe == null) {
			throw new UnsupportedOperationException();
		}
		
		String jpql = "SELECT e FROM " + classe.getName() 
			+ " e where e.matricula != " + ServidorMemory.getInstance().getMatricula();

		TypedQuery query = em.createQuery(jpql, classe);
		query.setMaxResults(qtd);
		query.setFirstResult(desl);
		
		return query.getResultList();
	}
	
	public long obterQtdTotalUsuarios() {
		if (classe == null) {
			throw new UnsupportedOperationException();
		}
		TypedQuery<Long> query = em.createNamedQuery("consultarQtdTotalUsuarios", Long.class);
		query.setParameter("matricula", ServidorMemory.getInstance().getMatricula());
		query.setParameter("nivel", ServidorMemory.getInstance().getNivelPermissao());
		return query.getSingleResult();
	}
	
	public long obterQtdTotalUsuariosPorFiltro(String filtro) {
		if (classe == null) {
			throw new UnsupportedOperationException();
		}
		TypedQuery<Long> query = em.createNamedQuery("consultarQtdDoFiltro", Long.class);
		query.setParameter("matricula", ServidorMemory.getInstance().getMatricula());
		query.setParameter("nivel", ServidorMemory.getInstance().getNivelPermissao());
		query.setParameter("nome", "%" + filtro + "%");
		
		return query.getSingleResult();
	}
	

	public List<E> obterPorAproximacao(String valor, int qtd, int desl) {
		TypedQuery query = em.createNamedQuery("consultaUsuariosAproxima", classe);
		query.setParameter("nome", "%" + valor + "%");
		query.setParameter("matricula", ServidorMemory.getInstance().getMatricula());
		query.setMaxResults(qtd);
		query.setFirstResult(desl);
		
		return query.getResultList();
	}
	
	public List<E> obterPorAproximacao(String valor) {
		TypedQuery query = em.createNamedQuery("consultaUsuariosAproxima", classe);
		query.setParameter("nome", "%" + valor + "%");
		return query.getResultList();
	}
	
	public E obterPorMatricula(Long matricula) {
		TypedQuery query = em.createNamedQuery("consultarMatricula", classe);
		query.setParameter("valor", matricula);
		
		Usuario user = (Usuario) query.getResultList().get(0);
		return (E)user;
	}

	public boolean validarAcesso(Long matricula, String senha) {
		em = emf.createEntityManager();
		TypedQuery query = em.createNamedQuery("consultarMatricula", classe);
		query.setParameter("valor", matricula);

		if (!query.getResultList().isEmpty()) {
			Usuario user = (Usuario) query.getResultList().get(0);
			boolean condicao1 = user.getMatricula().equals(matricula);
			boolean condicao2 = user.getSenha().equals(senha);

			return condicao1 && condicao2;
		}
		return false;
	}
	
	public boolean updateSenha(Long matricula, String novaSenha) {
		return false;
	}
}
