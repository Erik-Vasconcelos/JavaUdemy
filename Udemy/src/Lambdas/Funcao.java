package Lambdas;

import java.util.function.Function;

public class Funcao {
	public static void main(String[] args) {
		
		Function<Integer, String> parOuImpar= numero -> numero %2 == 0? "Par" : "Impar"; 
		
		System.out.println(parOuImpar.apply(33));
		
		Function<String, String> oResultadoE = valor -> "O resultado é: "+valor;
		
		
		
		// usando as duas Funções criadas
		String res = parOuImpar.apply(67);
		System.out.println(oResultadoE.apply(res));
		
		
		/*usando as duas Funções criadas em uma mesma linha de código
		Usando o endThen > e então . ele vai chamar o parOuImpar e depois
		 o resultado e passado para oResultadoE*/
		System.out.println(parOuImpar.andThen(oResultadoE).apply(56));
		
		
		
		Function<String, String> empolgado = valor-> valor +"!!!";
		String resFinal =parOuImpar.andThen(oResultadoE).andThen(empolgado).apply(34);
		System.out.println(resFinal);
		
		
		Function<String , String> adcFrase= valor -> "número = a ".toUpperCase()+valor ;
		String resFinal1 =parOuImpar.andThen(adcFrase).andThen(oResultadoE).andThen(empolgado).apply(34);
		System.out.println(resFinal1);
		
		
		
		Function<Integer, Integer> numMaisDez = num -> num+10;
		
		System.out.println(numMaisDez.apply(20));
		
		Function<Integer, String> isPrimo = num -> num%2 == 1 || num==2?"É primo!":"Não é primo!";
		
		System.out.println(isPrimo.andThen(oResultadoE).apply(5));
	}
}
