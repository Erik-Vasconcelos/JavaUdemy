package infra;

import java.sql.SQLException;

import javax.persistence.TypedQuery;

import modelo.Matricula;

public class DAOMatricula extends DAO<Matricula> {	
	
	public DAOMatricula() {
		super(Matricula.class);
	}
	
	public Matricula obterPorMatricula(Long matri) throws SQLException{
		try {
		String jpql = "SELECT m FROM Matricula m WHERE m.numero ="+matri;
		
		TypedQuery<Matricula> query = em.createQuery(jpql, Matricula.class);
		
		return query.getSingleResult();
		}catch (Exception e) {
			throw new SQLException("Não foi possivel encontrar a matricula");
		}
	}

	
}