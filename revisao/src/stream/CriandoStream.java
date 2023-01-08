package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CriandoStream {
	public static void main(String[] args) {
		Consumer<Object> print = System.out::println;
		
		/*A partir de uma Stream*/
		Stream<String> langs = Stream.of("Java","Python", "Lisp\n");
		langs.forEach(print);
		
		/*A partir de um array*/
		String[] maisLangs = {"Perl", "JavaScript", "GO\n"};
		Stream.of(maisLangs).forEach(print);
		
		/*a partir de uma collection*/
		List<String> outrasLang = Arrays.asList("Cobol", "Assemble", "C++", "PHP");
		outrasLang.stream().forEach(print);
		//outrasLang.parallelStream().forEach(print);
	
		/*Gerando Strem infinita
		Stream.generate(() -> "a\n").forEach(print);
		Stream.iterate(1, e -> e+1).forEach(print);
		
		*/
	}
}
