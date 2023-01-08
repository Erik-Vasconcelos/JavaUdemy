package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {
	public static void main(String[] args) throws SQLException {
		
		// erikv 18 de jun. de 2022
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Informe o nome: ");
		String nome = leitor.nextLine();
		
		Connection conexao = FabricaConecao.getConexao();
		
		String sql = "INSERT INTO PESSOAS(NOME) VALUES(?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		
		stmt.execute();
		System.out.println("Pessoa inserida com sucesso!");
		

		leitor.close();
	}
}
