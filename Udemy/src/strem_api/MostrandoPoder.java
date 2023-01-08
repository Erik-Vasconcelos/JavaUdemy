package strem_api;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class MostrandoPoder {
	public static void main(String[] args) {
		
		
		List<String> aprovados = Arrays.asList("Lia", "Gui", "Luca", "Bia");
		
		System.out.println("Usando o forEach...");
		for (String nome : aprovados) {
			System.out.println(nome);
		}
		
		System.out.println("\nUsando o Iterator...");
		Iterator<String> iterator = aprovados.iterator();
		while(iterator.hasNext()) {
			//hasNext() > Tem proximo? retorna boolean
			System.out.println(iterator.next());//pegue o elemento
		}
		
		System.out.println("\nUsando o Stream...");
		Stream<String>  stream = aprovados.stream();
		stream.forEach(System.out::println);
		
	}
}
