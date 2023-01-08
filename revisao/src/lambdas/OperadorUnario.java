package lambdas;

import java.util.function.UnaryOperator;

public class OperadorUnario {
	public static void main(String[] args) {
		/*O UnaryOperator recebe um �nico tipo no generic que vai ser o tipo de entrae de sa�da*/
		
		UnaryOperator<Integer> vezesDois = n -> n * 2 ;
		UnaryOperator<Integer> maisDez = n -> n + 10;
		
		System.out.println(vezesDois.andThen(maisDez).apply(3));
		System.out.println(maisDez.compose(vezesDois).apply(3));
		System.out.println(vezesDois.compose(maisDez).apply(3));
		
		
	}
}
