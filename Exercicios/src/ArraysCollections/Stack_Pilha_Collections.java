package ArraysCollections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Stack_Pilha_Collections {
	public static void main(String[] args) {
		Deque<String> livros =new ArrayDeque<>();
		//Outra interfece pilha
		//Stack<String> l = new Stack<String>();
		
		livros.add("O poder da Ação"); // > retorna boolean
		livros.push("Poder e alta perfomace");
		livros.push("Java"); // > retorna uma exception caso nao conseguiu adicionar
		livros.push("Python");
		livros.offer("Lógica de programação");
		
		livros.forEach(System.out::println);
		System.out.println();
		
		//pega o ultimo elemento a sair
		System.out.println(livros.getLast());
		
		//o peek e o element funcionam na pilha
		System.out.println(livros.peek());
		System.out.println(livros.element());
		
		//metodo da pilha > caso esteja vazia retorna uma exception
		
		System.out.println("Removendo... "+livros.pop());
		
		System.out.println("\npoll e remove...");
		System.out.println(livros.remove());
		System.out.println(livros.remove());
		System.out.println(livros.poll());
		System.out.println(livros.poll());
		
		System.out.println(livros.isEmpty());
		//System.out.println(livros.);
		
		
		//System.out.println(livros);
	}
}
