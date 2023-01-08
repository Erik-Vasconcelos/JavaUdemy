package lamdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;

public class Stream {
	public static void main(String[] args) {
		
		List<String> aprovados = Arrays.asList("Gui", "Lu", "Bia");
		
		for(String aprovado : aprovados) {
			System.out.println(aprovado);
		}
		
		System.out.println("\nIterator");
		Iterator<String> iterator = aprovados.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("\nStream");
		aprovados.stream().forEach(System.out::println);
		
		java.util.stream.Stream<Integer> stream = java.util.stream.Stream.of(new Integer[] {1, 2, 3, 4});
	
		stream.filter(n -> n > 2).forEach(System.out::println);
		
		//java.util.stream.Stream.iterate(0, n -> n + 1).forEach(System.out::println);;
		
		List<Integer> numeros = Arrays.asList(1, 2,3, 4, 5, 6,6 );
		
		BinaryOperator<Integer> soma = (acm, n) -> acm + n;
		
		 Integer total = numeros.stream().reduce(0, soma);
		 System.out.println(total);
		 
		 
		BinaryOperator<String> concat = (t, s) -> t + s;
		
		aprovados.parallelStream().reduce(concat)
				.ifPresentOrElse(
						System.out::println,
						() -> System.out.println("Em Branco ")
				);
		
		numeros.stream().takeWhile(n -> n <= 5).forEach(System.out::println);
		
		
		
	}
}
