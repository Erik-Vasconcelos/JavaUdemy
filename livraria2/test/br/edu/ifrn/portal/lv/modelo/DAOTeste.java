package br.edu.ifrn.portal.lv.modelo;

import org.junit.jupiter.api.Test;

import br.edu.ifrn.portal.lv.infra.DAO;

class DAOTeste {

	@Test
	void inserir() {
		DAO dao = new DAO();
		String sql = "INSERT INTO livro(isbn, titulo, autor, valor, ano_publicacao, id_estante)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		dao.incluir(sql, 5845L, "O Poder da Ação", "Paulo Vieira", 45.24, 2016, 2);
		dao.incluir(sql, 4856L, "Fator de Enrequicimento", "Paulo Vieira", 14.24, 2011, 1);
		dao.incluir(sql, 7842L, "Mindset", "Albert Paul", 78.26, 2013, 2);
		 
		dao.close();
	}

}
