package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class Reduce {
	public static void main(String[] args) {
		Consumer<Object> print = System.out::println;
		
		List<Double> notas = Arrays.asList(9.7, 6.7, 3.4, 7.1);
		BinaryOperator<Double> total = (acm, n) -> acm + n;
		
		print.accept(notas.stream().reduce(total).get());
		print.accept(notas.stream().reduce(8.0, total));
		
	}
}
