package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirRegistro {
	public static void main(String[] args) throws SQLException {
		
		// erikv 20 de jun. de 2022
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o id: ");
		int cod = leitor.nextInt();
		
		Connection conexao = FabricaConecao.getConexao();
		String sql = "DELETE FROM PESSOAS WHERE CODIGO = ?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, cod);
		int contador = stmt.executeUpdate();
		
		if(contador > 0) {
			System.out.println("Pessoa excluida com sucesso! ");
		}else {
			System.out.println("Nada Feito!");
		}
		
		System.out.println("Linhas efetadas: "+contador);

		conexao.close();
		stmt.close();
		leitor.close();
	}
}
