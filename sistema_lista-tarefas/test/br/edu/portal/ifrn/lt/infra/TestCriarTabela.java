package br.edu.portal.ifrn.lt.infra;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

import br.edu.ifrn.portal.lt.infra.FabricaConexao;

class TestCriarTabela {

	@Test
	void test() throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		String sql= "CREATE TABLE evento("
				+ "id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,"
				+ "titulo VARCHAR(50) NOT NULL,"
				+ "descricao VARCHAR(200),"
				+ "data_criacao varchar(10) not null,"
				+ "data_entrega varchar(10) not null,"
				+ "concluido enum('true', 'false')"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
	}

}
