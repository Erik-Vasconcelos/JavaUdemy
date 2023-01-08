package collections.projetinho.view;

import collections.projetinho.model.Livro;
import collections.projetinho.model.BancoLivro;
import collections.projetinho.model.Estante;

public class SistemaLivraria {
	public static void main(String[] args) {
		
		Estante estante1 = new Estante(30, 1L);
		Livro livro1 = new Livro("Java como programar", "Paul deitel",360.45, 5668L);
		Livro livro2 = new Livro("Codigo Limpo", "Robert c.", 71.56, 8792L);
		
		Estante estante2 = new Estante(10, 2L);
		Livro livro3 = new Livro("Uml", "Grady Booch",124.09, 2575L);
		Livro livro4 = new Livro("Design Patterns", "Gang of four", 92.65, 4582L);
		
		Estante estante3 = new Estante(2, 3L);
		Livro livro5 = new Livro("Domain Drive design", "Eric Evans",82.14, 6787L);
		Livro livro6 = new Livro("Refatoração", "Martin Fowler", 95.55, 6569L);
		
		Estante estante4 = new Estante(15, 4L);
		Livro livro7 = new Livro("Algoritmo", "Ronald L.",308.85, 5715L);
		Livro livro8 = new Livro("Ajax", "Rebecca M.", 80.56, 6482L);
		
		
		
		estante1.inserirLivro(livro1);
		estante1.inserirLivro(livro2);
		estante2.inserirLivro(livro3);
		estante2.inserirLivro(livro4);
		estante3.inserirLivro(livro5);
		estante3.inserirLivro(livro6);
		estante4.inserirLivro(livro7);
		estante4.inserirLivro(livro8);
		BancoLivro.inserirEstante(estante1);
		BancoLivro.inserirEstante(estante2);
		BancoLivro.inserirEstante(estante3);
		BancoLivro.inserirEstante(estante4);
		
		
		//System.out.println(BancoLivro.buscarLivro(5795L));
		
		/*System.out.println(BancoLivro.getLivrosEstante(1L));
		System.out.println(BancoLivro.listarTodosLivros().toString());
		
		System.out.println(BancoLivro.buscarLivro(5668L));
		System.out.println(BancoLivro.venderLivro(5668L));
		
		System.out.println(estante1.getLivro(5668L));*/
		
		System.out.println(BancoLivro.verificarDuplicata(6787L));
		System.out.println(BancoLivro.listarTodosLivros());
		
		Livro livro9 = new Livro("Html e css", "Use a cabeça", 124.78, 3545L);
		estante4.inserirLivro(livro9);
		
		Livro livro10 = new Livro("Jpa", "Hebert coelho", 154.87, 6445L);
		try {
			estante3.inserirLivro(livro10);
		}catch (Exception e) {
			System.err.println(e);
		}
		System.out.println(BancoLivro.listarTodosLivros());
		
		System.out.println(BancoLivro.getQtdLivros());
		
		System.out.println(BancoLivro.maiorPreco());
		System.out.println(BancoLivro.localizarLocalLivro(3545L));
	}
}
