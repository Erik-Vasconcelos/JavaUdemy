package br.edu.ifrn.portal.lt.view;

import java.sql.SQLException;

public class Run {
	public static void main(String[] args) throws SQLException {
		Visao visao  = new Visao();
		
		visao.iniciar();
		
//		String url = "jdbc:mysql://localhost";
//		String usuario = "root";
//		String senha = "java2022";
//		
//		Connection conexao = DriverManager.getConnection(url, usuario, senha);
//		
//		String sql = "CREATE DATABASE sistema_gestao";
//		
//		PreparedStatement stmt = conexao.prepareStatement(sql);
//		
//		stmt.execute();
		
	}
}
