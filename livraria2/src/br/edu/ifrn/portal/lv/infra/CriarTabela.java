package br.edu.ifrn.portal.lv.infra;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela {
	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		
		String sqlDrop = "DROP DATABASE IF EXISTS livraria";
		String sqlCriar = "CREATE DATABASE IF NOT EXISTS livraria";
		 
		String sqlEstante = "CREATE TABLE IF NOT EXISTS estante("
				+ "id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,"
				+ "capacidade INT NOT NULL"
				+ ")";
			
		String sqlLivro = "CREATE TABLE IF NOT EXISTS livro("
				+ "id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,"
				+ "isbn BIGINT NOT NULL,"
				+ "titulo VARCHAR(55) NOT NULL,"
				+ "autor VARCHAR(55) NOT NULL,"
				+ "valor DECIMAL(6, 2) NOT NULL,"
				+ "ano_publicacao INT(4) NOT NULL,"
				+ "id_estante INT UNSIGNED NOT NULL,"
				+ "FOREIGN KEY(id_estante) REFERENCES estante(id)"
				+ ")";
		Statement stmt = conexao.createStatement();
		//stmt.execute(sqlDrop);
		stmt.execute(sqlCriar);
		stmt.execute(sqlEstante);
		stmt.execute(sqlLivro);
		
		System.out.println("Operações concluidas com sucesso!");
		conexao.close();
		
	}
}
