package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Result;

public class AtualizarRegistro {
	public static void main(String[] args) throws SQLException{
		// erikv 18 de jun. de 2022
		Scanner leitor = new Scanner(System.in);
		System.out.println("digite o codigo da pessoa: ");
		int cod = leitor.nextInt();
		leitor.nextLine();
		
		Connection conexao = FabricaConecao.getConexao();
		
		String sql = "SELECT * FROM PESSOAS WHERE CODIGO =?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, cod);
		ResultSet resultado = stmt.executeQuery();
		
		int codigo =0;
		if(resultado.next()) {
			codigo = resultado.getInt("codigo");
			String no = resultado.getString("nome");
			Pessoa p= new Pessoa(codigo, no);
			System.out.println(p.getCodigo()+"  "+p.getNome());
			
			System.out.println("digite o novo nome da pessoa: ");
			String nome = leitor.nextLine();
			
			sql = "UPDATE PESSOAS SET NOME =? WHERE CODIGO =?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setInt(2, codigo);
			stmt.execute();
			
			System.out.println("Atualizacao realizada com sucesso! ");
		}
		else {
			System.out.println("Pessoa nao encontrada!");
		}
		conexao.close();
		stmt.close();
		leitor.close();
	}
}
