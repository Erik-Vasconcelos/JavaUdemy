package lamdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Teste {

	public static void main(String[] args) {
		
		/*Function<Integer, String> parOuImpar = n -> n % 2 == 0 ? "Par" : "Impar";
		
		System.out.println(parOuImpar.andThen(s -> s.equals("Par") ? s+"!!!": s).apply(33));
		
		TerciOperator<Integer, Double, String> multiply = (x, y) -> "Result: " + x * y  ;
		
		System.out.println(multiply.apply(4, 5.5));
		
		Predicate<String> isErik = s -> "Erik".equalsIgnoreCase(s); 
		System.out.println(isErik.or(n -> "Carlos".equals(n)).test("Carlos"));
		
		
		Consumer<Object> print = System.out::print;
		
		//print.accept("Tirineu");
		
		//python.print(23, "Erik", true);*/

		Python python = System.out::print;
		
		python.print(23, "Erik", true, false, 'f', 34.50, 20L);
		
		System.out.println("Erik "+ true + " " + false + " " + 'f' + " " + 34.50);
		
		Function<Double, String> format  = v -> String.format("R$%,.2f", v);
		System.out.println(format.apply(2342441.0));
		
		Predicate<String> isBig = s -> s.length() > 10;
		
		python.print(isBig.test(format.apply(458.0)));
		
		//-------------------
		Supplier<Integer[]> umaLista = () -> {
			
			Integer[] array = new Integer[10];
			Arrays.fill(array, 20);
			return array;
		};
		
		Consumer<Integer[]> imprimir = v -> System.out.println(Arrays.toString(v));
		
		imprimir.accept(umaLista.get());
		
		
		UnaryOperator<String> reverse = s -> new StringBuilder(s).reverse().toString();
		
		BinaryOperator<String> concat = (x, y) -> x.concat(y);
		
		System.out.println(concat.apply(reverse.apply("Gustavo"), "!!!"));
		
		
		Predicate<Double> isAprovado = v -> v >= 6.0;
		
		BiFunction<Double, Double, String> aprovado = (n1, n2) -> {
			double media = (n1 + n2) / 2; 
			return isAprovado.test(media) ? "Aprovado " + media : media < 2.0 ? "Reprovado " + media : "Recuperação " + media;
		};
		
		python.print(aprovado.apply(6.2,  6.2));
		
		
	}
}
