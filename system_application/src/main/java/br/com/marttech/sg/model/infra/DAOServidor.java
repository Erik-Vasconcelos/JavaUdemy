package br.com.marttech.sg.model.infra;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.marttech.sg.model.dto.ServidorDTO;
import br.com.marttech.sg.model.memoria.ServidorMemory;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;
import br.com.marttech.sg.model.perfis.abstracts.Usuario;

public class DAOServidor extends DAOUsuario<Servidor>{
	
	public DAOServidor() {
		super(Servidor.class);
	}
	
	@Override
	public Servidor obterPorMatricula(Long matricula) {
		@SuppressWarnings("rawtypes")
		TypedQuery query = em.createNamedQuery("consultarMatriculaServidor", classe);
		query.setParameter("valor", matricula);
		Servidor user = null;
		
		if(!query.getResultList().isEmpty()) {
			user = (Servidor) query.getResultList().get(0);
		}
		
		return user;
	}
	
	@Override
	public boolean validarAcesso(Long matricula, String senha) {
		em = emf.createEntityManager();
		TypedQuery query = em.createNamedQuery("consultarMatriculaServidor", classe);
		query.setParameter("valor", matricula);

		if (!query.getResultList().isEmpty()) {
			Usuario user = (Usuario) query.getResultList().get(0);
			boolean condicao1 = user.getMatricula().equals(matricula);
			boolean condicao2 = user.getSenha().trim().equals(senha);
			
			return condicao1 && condicao2;
		}
		return false;
	}
	
	public List<ServidorDTO> consultarParteDados(int qtd, int desl) {
		if(classe == null) {
			throw new RuntimeException();
		}
		String matricula = ServidorMemory.getInstance().getMatricula().toString();
		
		Query query = em.createNamedQuery("consultarParteDados");
		query.setParameter("matri", matricula);
		//REFACTOR
		query.setParameter("nivel", ServidorMemory.getInstance().getNivelPermissao());
		query.setMaxResults(qtd);
		query.setFirstResult(desl);
		
		return query.getResultList();
	}
	
	public List<ServidorDTO> consultarParteDadosPorFiltro(String parteNome, int qtd, int desl) {
		if(classe == null) {
			throw new RuntimeException();
		}
		String matricula = ServidorMemory.getInstance().getMatricula().toString();
		
		Query query = em.createNamedQuery("consultarParteDadosPorFiltro");
		query.setParameter("matri", matricula);
		query.setParameter("nivel", ServidorMemory.getInstance().getNivelPermissao());
		query.setParameter("parteNome", "%" + parteNome + "%");
		query.setMaxResults(qtd);
		query.setFirstResult(desl);
		
		return query.getResultList();
	}

}
