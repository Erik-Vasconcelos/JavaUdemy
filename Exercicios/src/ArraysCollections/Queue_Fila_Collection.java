package ArraysCollections;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_Fila_Collection {
	public static void main(String[] args) {
		
		// Queue (Fila) 
		//first in first out > primeira a entrar, primeiro a sair
		
		Queue<Integer> ficha  =new LinkedList<>();
		ficha.add(1);
		ficha.add(2);
		ficha.add(3);
		ficha.add(4);
		ficha.add(5);
		ficha.add(6);
		ficha.add(7);
		
		//Caso a fila tenha uma resticao de tamanho o offer nao retornará um erro
		ficha.offer(8);
		ficha.offer(9);
		ficha.offer(10);
		//mostra o tamanho da collection
		System.out.println(ficha.size());
		//mostra os elementos
		System.out.println(ficha);
		
		ficha.forEach(System.out::println);
		
		System.out.println();
		//verifica se contém o elemento
		System.out.println(ficha.contains(5));
		
		//Pega o proximo elemento sem o remove-lo
		System.out.println("\nPegando sem remover...");
		System.out.println(ficha.peek()); //Caso esteja vazia retorna null
		System.out.println(ficha.peek());
		System.out.println(ficha.element());//Caso esteja vazia retorna uma exception
		System.out.println(ficha.element());
		
		System.out.println("\nPegando e removendo...");
		System.out.println(ficha.poll());// Se estiver vazia retorna null
		System.out.println(ficha.poll());
		
		System.out.println(ficha.remove());// Se estiver vazia retorna uma Exception
		System.out.println(ficha.remove());
		System.out.println(ficha.remove());
		System.out.println(ficha.remove());
		System.out.println(ficha.remove());
		System.out.println(ficha.remove());
		System.out.println(ficha.remove());
		System.out.println(ficha.remove()); // > 10
		System.out.println(ficha.poll());// > null
		
		System.out.println(ficha.isEmpty());
		
	}
}
