package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {
	public static void main(String[] args) throws SQLException{
		
		Connection conexao = FabricaConecao.getConexao();
		// erikv 18 de jun. de 2022
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Informe o valor para pesquisa: ");
		String carac = leitor.next();
		
		String sql = "SELECT * FROM PESSOAS WHERE NOME LIKE ?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, "%"+carac+"%");
		ResultSet resultado = stmt.executeQuery();
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		while(resultado.next()) {
//			int codigo = ;
//			String nome = ;
			pessoas.add(new Pessoa(resultado.getInt("codigo"), resultado.getString("nome")));
		}
		
		for(Pessoa p: pessoas) {
			System.out.println(p.getCodigo()+" ----- "+p.getNome());
		}
		
		stmt.close();
		conexao.close();
		leitor.close();
	}
}
