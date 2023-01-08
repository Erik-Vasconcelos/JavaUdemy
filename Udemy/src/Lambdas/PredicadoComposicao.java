package Lambdas;

import java.util.function.Predicate;
public class PredicadoComposicao {
	public static void main(String[] args) {
		Predicate<Integer> isPar = num -> num %2 ==0; 
		
		Predicate<Integer> isTreDigitos = num -> num>= 100 && num <=999;
		
		System.out.println(isPar.and(isTreDigitos).negate().test(29));
		
		System.out.println(isPar.or(isTreDigitos).test(4));
		
		
		
	}
}
