package br.com.marttech.sg.matricula.interno.infra;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.com.marttech.sg.matricula.interno.excecao.MatriculaExistenteException;

public class DAO {
	/**
	 * @author erikv
	 * @date 21:43:30 24 de set. de 2022
	 * @system_unity_description Classe responsavel por separar a regra de negocio com 
	 * codigo de acesso a banco de dados, ou seja, infraestrutura.
	 * @version 1.0 24 de set. de 2022
	 * @version 1.1 22 de dez. de 2022
	 */
	
	private Connection conexao;
	private PreparedStatement stmt;
	
	static {
		try {
			Connection conexao = FabricaConexao.getConexao();
			DatabaseMetaData meta = conexao.getMetaData();
			ResultSet tabelas = meta.getTables(null, null, "matricula_servidor", new String[] {"TABLE"});
			
			if (tabelas.next()) {
				
			}else {
				String sql = "CREATE TABLE IF NOT EXISTS MATRICULA_SERVIDOR("
						+ "ID INT PRIMARY KEY AUTO_INCREMENT,"
						+ "NUMERO BIGINT UNIQUE NOT NULL"
						+ ")";
				PreparedStatement stmt = conexao.prepareStatement(sql);
				
				stmt = conexao.prepareStatement(sql);
				stmt.execute();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public DAO abrirCon() {
		try {
			conexao = FabricaConexao.getConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public Long getUltimaMat() {
		try {
			Long valor = 0L;
			String sql = "SELECT MAX(numero) FROM matricula_servidor";
			abrirCon();
			
			ResultSet result = getStmt(sql).executeQuery();
			
			if(result.next()) {
				valor = result.getLong(1);
			}
			
			fecharStmt();
			return valor;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public boolean matriIsExists(Long numero) {
		try {
			String sql = "SELECT id FROM matricula_servidor"
					+ " where numero = ?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, numero);
			ResultSet r = stmt.executeQuery();
			
			int result = 0;
			if(r.next()) {
				result++;
			}
			return result == 1 ? true : false;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public DAO insertNovaMat(Long matricula) {
		try {
			if(matriIsExists(matricula)) {
				throw new MatriculaExistenteException();
			}
			
			String sql = "INSERT INTO matricula_servidor(numero)"
					+ "values(" + matricula +")";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.execute();
			
			return this;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private DAO insertNovaMat(Class classe, Long matricula) {
		//TODO - Implementar metodo
		return null;
	}
	
	public boolean verifyBankIsEmpty() {
		try {
			abrirCon();
			String sql = "SELECT COUNT(id) AS QUANT FROM matricula_servidor";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet r = stmt.executeQuery();
			int result = 0;
			
			if(r.next()) {
				result = r.getInt(1);
			}
			
			return result > 0 ? false: true; 
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public DAO fecharCon() {
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	private PreparedStatement getStmt(String sql) {
		try {
			stmt = conexao.prepareStatement(sql);
			return stmt;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private DAO fecharStmt() {
		try {
			stmt.close();
			return this;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
