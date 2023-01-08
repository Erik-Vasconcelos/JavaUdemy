package lambdas;

import java.util.function.Predicate;

public class Predicado02 {
	public static void main(String[] args) {
		
		Predicate<Integer> isPar = n -> n%2==0; 
		Predicate<Integer> isTresDigitos= v -> v>=100 && v<=999;
		
		//é par e tem tres digitos.negado
		System.out.println(isPar.and(isTresDigitos).negate().test(108));
		System.out.println(isTresDigitos.negate().or(isPar).test(108));
		
		//é par ou tem tês digitos
		System.out.println(isPar.or(isTresDigitos).test(101));
		
		//O predicate usa os operadores lógicos porque retona um boolean
		
	}
}
