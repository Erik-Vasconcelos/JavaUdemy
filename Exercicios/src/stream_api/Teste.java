package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Teste {
	public static void main(String[] args) {
		Consumer<String> print = System.out::println;
		//Print de inteiros
		Consumer<Integer> println = System.out::println;
		
		List<String> lista = Arrays.asList("Erik","Joao", "Gui", "Zé" );
		
//		Iterator<String> iterator =lista.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		};
		
		lista.stream().map(e -> e+"!!!").forEach(print);
		System.out.println();
		lista.stream().map(e -> e+"!!!").filter(e -> e.length() > 6).forEach(print);
//		
//		Function<Integer, String> converte = e -> e+10+" ";
//		System.out.println(converte.apply(3));
		
		
		//Criando Strems
		System.out.println("A partir da própria interface...");
		Stream<String> langs = Stream.of("Go", "TypeScipt","Kotlin");
		langs.forEach(print);
		
		System.out.println("\nA partir de um array...");
		String[] maisLangs = {"Java", "Python", "Ruby", "JavaScript"};
		//imprime do indice 1 ao 4
		Arrays.stream(maisLangs, 1, 4).forEach(print);
		Stream.of(maisLangs).forEach(print);
		
		System.out.println("\nA partir de uma collection...");
		List<String> outrasLangs = Arrays.asList("C", "Php", "Lisp");
		
		outrasLangs.forEach(print);
		//Processamento paralelo
		outrasLangs.parallelStream().forEach(print);
		
		System.out.println("\nGerando stream infinita...");
		//Stream.generate(() -> "a").forEach(print);
		
		Stream.iterate(0, e -> e+1).forEach(println);
		
		
		
	}
}
