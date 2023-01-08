package Arrays_E_Collections.Collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Exercicios {
	public static void main(String[] args) {
		// 1- crie um set que receba alguns nomes e imprima
		/*HashSet<String> nomes  = new HashSet<String>();
		nomes.add("Erik");
		nomes.add("Jose");
		nomes.add("Flavio");
		nomes.add("Bia");
		System.out.println(nomes.contains("Erik"));
		System.out.println(nomes);*/
		
		
		// 2- Crie um set que receba nomes só que agora conserve a ordem de inserção
		
		/*SortedSet<String> nomes2 = new TreeSet<>();
		
		nomes2.add("Paulo");
		nomes2.add("Ronaldo");
		nomes2.add("Saulo");
		nomes2.add("João");
		
		System.out.println(nomes2);
		*/
		
		
		// 3- Crie uma lista que receba os nomes dos aprovados
		
			// a lista é ordenada ,ou seja, preserva a ordem de inserção e aceita obj duplicados
		/*ArrayList<String> listaAprovados = new ArrayList<>();
		listaAprovados.add("Erik");
		listaAprovados.add("Gustavo");
		listaAprovados.add("Raul");
		listaAprovados.add("Raul");
		System.out.println(listaAprovados);*/
		
		
		// 4- Crie uma fila com tickets para sacar dinheiro
		
		/*Queue<Integer> fila = new LinkedList<>();
		
		fila.add(1);
		fila.add(2);
		fila.add(3);
		fila.add(4);
		//Método offer caso nao consiga adicionar renorna true ou false já o add retorna uma Exeption
		fila.offer(5);
		fila.peek();
		
		//pega o primeiro elemento sem o remover
		System.out.println(fila.peek());//caso a fila estiver vazia retorna null
		System.out.println(fila.element());//retorna uma Exeption
		//System.out.println(fila.isEmpty());
		
		System.out.println(fila.poll());/*pega o primeiro elemento da fila e remove-o, se estiver
		vazia retorna null
		System.out.println(fila.remove());//remove o primeiro elemento, se estiver vazia retorna uma exeption
		System.out.println(fila.contains(3)); // Verifica se contém o elemento 
		*/
		
		
		//Crie uma pilha de livros
		
		Deque<String> livros = new ArrayDeque<>();
		livros.add("O Pequeno Principe");
		livros.add("O Poder da Ação");
		livros.add("Fisica 1"); //Caso não seja possivel adicionar retorna uma exeption
		
		// o forEach pode ser usado
		for(String livro : livros) {
			System.out.println(livro);
		}
		// obtem o proximo item sem remiover
		System.out.println(livros.peek());
		livros.push("O Hobbit");//Toca o ultimo elemento que foi adicionado
		
		
		System.out.println("\nImprime e remove");
		System.out.println(livros.pop());
		System.out.println(livros.pop());
		System.out.println(livros.pop());
		
		//Crie uma estrutura que receba um CPF e um nome associado a ele
		
		Map<Long, String> cadastro = new HashMap<>();
		cadastro.put(706_908_205_14L, null);
		
		
		
	}
}
