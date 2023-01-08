package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
		String usuario = "root";
		String senha  = "java2022";
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		System.out.println("conexao efetuada");
		
		conexao.close();
	}
}
