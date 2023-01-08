package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOAluno {
	/*Classe responsavel por fazer a manipulação de dados no banco de dados, impedindo a juncao de regra de
	 *negócio com o codigo de infraestrutura de acesso a dados*/
	//CRUD
	
	//Create
	public static void cadatrar(Aluno a) throws SQLException {
		Connection conexao = BancoConexao.getConexao();
		String sql = "INSERT INTO ALUNOS(nome, idade, matricula, endereco) VALUES(?, ?, ?, ?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, a.nome);
		stmt.setInt(2, a.idade);
		stmt.setString(3, a.matricula);
		stmt.setString(4, a.endereco);
		stmt.execute();
		conexao.close();
	}
	
	//Read
	public static Aluno visualizar(String mat) throws  SQLException{
		Connection conexao = BancoConexao.getConexao();
		String sql = "SELECT * FROM ALUNOS WHERE MATRICULA = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, mat);
		ResultSet r = stmt.executeQuery();
		
		String nome ="";
		int idade = 0;
		String matri ="";
		String ende ="";
		
		while(r.next()) {
			nome = r.getString("nome");
			idade = r.getInt("idade");
			matri =r.getString("matricula");
			ende =r.getString("endereco");
		}
		
		return new Aluno(nome, idade, matri,ende);
	}
	
	//Update
	public static int atualizar(String mat, String novoNome) throws SQLException {
		Connection conexao = BancoConexao.getConexao();
		String sql = "UPDATE ALUNOS SET NOME = ? WHERE MATRICULA = ?";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, novoNome);
		stmt.setString(2, mat);
		return stmt.executeUpdate();
		
	}
	
	//Delete
	public static int deletar(String mat) throws SQLException{
		Connection conexao = BancoConexao.getConexao();
		String sql = "DELETE FROM ALUNOS WHERE MATRICULA = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, mat);
		return stmt.executeUpdate();
	}
}
