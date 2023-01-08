package br.com.marttech.sg.matricula;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

import br.com.marttech.sg.matricula.interno.infra.DAO;
import br.com.marttech.sg.matricula.interno.infra.FabricaConexao;
import br.com.marttech.sg.matricula.interno.model.GeradorMatricula;

class TesteCreate {

	@Test
	void criarTabela() throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		String sql = "CREATE TABLE IF NOT EXISTS MATRICULA_SERVIDOR("
				+ "ID INT PRIMARY KEY AUTO_INCREMENT,"
				+ "NUMERO BIGINT UNIQUE NOT NULL"
				+ ")";
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
	}
	
	@Test
	void getUltimaMat() {
		DAO dao = new DAO();
		System.out.println(dao.abrirCon().getUltimaMat());
	}
	
	@Test
	void getCodBase() {
		System.out.println(GeradorMatricula.gerarMatServ());
	}
	
}
