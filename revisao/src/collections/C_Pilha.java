package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Function;

public class C_Pilha {
	private Deque<Livro> livros = new ArrayDeque<>();
	
	
	public void adicionarLivro(Livro livro) {
		livros.push(livro);
	}
	
	public Livro getLivro() {
		return livros.poll();
	}
	
	public void removerLivro() {
		livros.pop();
	}

	public Deque<Livro> getLivros() {
		return livros;
	}
	
	public String listaLivros() {
		String result = "";
		Deque<Livro> livros =  getLivros();
		
		for (Livro livro : livros) {
			result += livro.getNome() +" "+livro.getAutor() +"\n";
		}
		return result;
	}
	
	
	
	
}
