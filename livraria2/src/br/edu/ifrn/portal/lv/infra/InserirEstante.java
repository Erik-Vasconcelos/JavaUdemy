package br.edu.ifrn.portal.lv.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirEstante {
	Connection conexao = FabricaConexao.getConexao();
	
	public boolean inserir(int capacidade) throws SQLException {
		String sql  = "INSERT INTO estante(capacidade) VALUES(?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, capacidade);
		return stmt.execute();
	}
	
	
	
	public static void main(String[] args) {
		InserirEstante in = new InserirEstante();
		try {
			in.inserir(35);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
