package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Filtro {
	public static void main(String[] args) {
		
		List<Integer> idade = Arrays.asList(13, 15, 18, 92, 31, 65, 34, 15, 10, 16, 25, 27);
		
		Consumer<Object> print = System.out::println;
		Predicate<Integer> isMaior = i -> i >= 18;
		
		idade.stream().filter(isMaior).forEach(print);
	}
}
