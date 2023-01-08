package br.edu.ifrn.portal.lv.modelo;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

import br.edu.ifrn.portal.lv.infra.InfraLivro;
import br.edu.ifrn.portal.lv.model.Livro;

class TesteLivro {

	/*@Test
	void inserirNoBanco() {
		LivroInformatica livro = new LivroInformatica(5668L, "Java como programar", "Paul deitel",360.2, 2017);
		try {
			InfraLivro.inserir(livro, 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	@Test
	void listaLivros() {
		try {
			List<Livro> livros = InfraLivro.getLivros();
			
			Consumer<Object> print = System.out::println;
			
			livros.stream().forEach(print);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*@Test
	void getSelecaoLivros() throws SQLException {
		
		String titulo = JOptionPane.showInputDialog("Digite o titulo: ");
		
		List<Livro> livros = InfraLivro.getSelecaoLivros(titulo);
		
		Consumer<String> painel = s -> JOptionPane.showMessageDialog(null, s);
		
		for (Livro livro : livros) {
			painel.accept(livro.toString());
		}
	}
	
	@Test
	void inserirLivros() throws SQLException {
		//InfraLivro.inserirLivros();
			
	}
	
	@Test
	void testeAtualizar() throws SQLException {
		InfraLivro.atualizarRegistro(6787L);
	}*/
	
//	@Test
//	void excluirLivro() {
//		try {
//			InfraLivro.excluirLivro(6569L);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}