package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Map {
	public static void main(String[] args) {
		
		Consumer<Object> print = System.out::println;
		List<Integer> numeros = Arrays.asList(15, 52 ,63, 14, 75, 89);
		
		UnaryOperator<Integer> maisDois = a -> a + 2;
		numeros.stream().map(maisDois).forEach(print);
		
		
		UnaryOperator<Integer> vezesDois= n -> n*2;
		Function<Integer, String> paraString = n -> "N= "+n;
		System.out.println();
		
		/*Usando composição no stream*/
		numeros.stream().map(vezesDois).map(maisDois).map(paraString).forEach(print);
	}
}
