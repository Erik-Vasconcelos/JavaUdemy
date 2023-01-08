package lambdas;

import java.util.function.Function;
import java.util.function.Predicate;

public class Predicado2 {
	public static void main(String[] args) {
		
		Predicate<Integer> isPar = v -> v % 2 == 0;
		Predicate<Integer> isTresDigitos = n -> n >= 100 && n <= 999;
		
		Function<Integer, String> msg = n -> n + "-> é par e trem três digitos";
		
		System.out.println(isPar.and(isTresDigitos).test(837));
		
		System.out.println(isPar.or(isTresDigitos).negate().test(837));
		
	}
}
