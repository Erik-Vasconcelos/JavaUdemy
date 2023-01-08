package br.edu.ifrn.portal.lv.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifrn.portal.lv.model.Livro;
import br.edu.ifrn.portal.lv.model.LivroInformatica;

public class InfraLivro {
	private static Connection conexao;
	
	private static Connection getConexao() {
		conexao = FabricaConexao.getConexao();
		return conexao;
	}
	
	public static void inserir(LivroInformatica livro, int nEstante) throws SQLException {
		String sql = "INSERT INTO livro(isbn, titulo, autor, valor, ano_publicacao, id_estante)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = getConexao().prepareStatement(sql);
		stmt.setLong(1, livro.getIsbn());
		stmt.setString(2, livro.getTitulo());
		stmt.setString(3, livro.getNomeAutor());
		stmt.setDouble(4, livro.getPreco());
		stmt.setInt(5, livro.getAnoPublicacao());
		stmt.setInt(6, nEstante);
		stmt.execute();
		stmt.close();
		
	}
	
	public static List<Livro> getLivros() throws SQLException{
		Statement stmt = getConexao().createStatement();
		String sql = "SELECT * FROM LIVRO";
		ResultSet resultado = stmt.executeQuery(sql);
		List<Livro> livros= new ArrayList<>();
		
		while(resultado.next()) {
			Long isbn = resultado.getLong("isbn");
			String titulo = resultado.getString("titulo");
			String autor = resultado.getString("autor");
			Double valor= resultado.getDouble("valor");
			Integer ano = resultado.getInt("ano_publicacao");
			livros.add(new LivroInformatica(isbn, titulo, autor, valor, ano));
		}
		stmt.close();
		return livros;
		
	}
	
	
	public static List<Livro> getSelecaoLivros(String titulo) throws SQLException{
		String sql = "SELECT * FROM livro WHERE titulo LIKE ? ";
		
		PreparedStatement stmt = getConexao().prepareStatement(sql);
		stmt.setString(1, "%"+titulo+"%");
		ResultSet resultado = stmt.executeQuery();
		
		List<Livro> livros = new ArrayList<>();
		while(resultado.next()) {
			Long isbn = resultado.getLong("isbn");
			String title = resultado.getString("titulo");
			String autor = resultado.getString("autor");
			
			Double valor= resultado.getDouble("valor");
			Integer ano = resultado.getInt("ano_publicacao");
			
			livros.add(new LivroInformatica(isbn, title, autor, valor, ano));
			
		}
		stmt.close();

		return livros;
	}
	
	public static void atualizarRegistro(Long isbn) throws SQLException {
		String sqlSe = "Select * from livro where isbn = ?";
		String sqlUp = "UPDATE LIVRO SET titulo = ? WHERE ISBN = ?";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlSe);
		stmt.setLong(1, isbn);
		
		ResultSet r = stmt.executeQuery();
		LivroInformatica livro = null;	
		
		if(r.next()){
			livro = new LivroInformatica(
					r.getLong("isbn"),
					r.getString("titulo"),
					r.getString("autor"),
					r.getDouble("valor"),
					r.getInt("ano_publicacao"));
		}
		
		
		livro.setNome(caixaInput(livro.getTitulo(), "Digite o novo título"));
						
		stmt.close();
		stmt = conexao.prepareStatement(sqlUp);
		stmt.setString(1, livro.getTitulo());
		stmt.setLong(2, livro.getIsbn());
		stmt.execute();
		stmt.close();
	
	}
	
	public static void excluirLivro(Long codigo) throws SQLException {
		String select  = "SELECT * FROM livro WHERE isbn = ?";
		String delete = "DELETE FROM livro WHERE ISBN = ?";
		
		PreparedStatement stmt = getConexao().prepareStatement(select);
		stmt.setLong(1, codigo);
		
		ResultSet r = stmt.executeQuery();
		
		LivroInformatica livro = null;
		if(r.next()) {
			livro = new LivroInformatica(r.getLong("isbn"),
					r.getString("titulo"), 
					r.getString("autor"),
					r.getDouble("valor"),
					r.getInt("ano_publicacao"));
		}
		
		int result = JOptionPane.showConfirmDialog(null, livro.toString() + "\nTem certeza que deseja excluir? ",  "Comfirmacao", JOptionPane.YES_NO_OPTION);
		
		stmt.close();
		if(result == JOptionPane.YES_OPTION) {
			stmt = conexao.prepareStatement(delete);
			stmt.setLong(1, livro.getIsbn());
			stmt.execute();
		}	
		stmt.close();
		
	}
	
	public static String caixaInput(String valorInicial, String pergunta) {
		return  JOptionPane.showInputDialog(pergunta, valorInicial);
	}
	public static String caixaInput(Double valorInicial, String pergunta) {
		return  JOptionPane.showInputDialog(pergunta, valorInicial);
	}
	public static String caixaInput(int valorInicial, String pergunta) {
		return  JOptionPane.showInputDialog(pergunta, valorInicial);
	}
	
	public static void inserirLivros() throws SQLException {
		Livro livro3 = new LivroInformatica(2575L, "Uml", "Grady Booch",124.09, 2018 );
		Livro livro4 = new LivroInformatica(4582L, "Design Patterns", "Gang of four", 92.65, 2000 );
		Livro livro5 = new LivroInformatica(6787L, "Domain Drive design", "Eric Evans",82.14, 2016 );
		Livro livro6 = new LivroInformatica(6569L, "Refatoração", "Martin Fowler", 95.55, 2013);
		Livro livro7 = new LivroInformatica(5715L, "Algoritmo", "Ronald L.",308.85, 2015 );
		Livro livro8 = new LivroInformatica(6482L, "Ajax", "Rebecca M.", 80.56, 2011);
		
		List<Livro> livros = Arrays.asList(livro3, livro4, livro5, livro6, livro7, livro8);
		
		String sql = "INSERT INTO livro(isbn, titulo, autor, valor, ano_publicacao, id_estante)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		for (Livro livro : livros) {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setLong(1, livro.getIsbn());
			stmt.setString(2, livro.getTitulo());
			stmt.setString(3, livro.getNomeAutor());
			stmt.setDouble(4, livro.getPreco());
			stmt.setInt(5, livro.getAnoPublicacao());
			stmt.setInt(6, 2);
			stmt.execute();
		}
	}
	
}
