package Lambdas;

import java.util.function.Function;

public class Funcao {
	public static void main(String[] args) {
		
		Function<Integer, String> parOuImpar= numero -> numero %2 == 0? "Par" : "Impar"; 
		
		System.out.println(parOuImpar.apply(33));
		
		Function<String, String> oResultadoE = valor -> "O resultado �: "+valor;
		
		
		
		// usando as duas Fun��es criadas
		String res = parOuImpar.apply(67);
		System.out.println(oResultadoE.apply(res));
		
		
		/*usando as duas Fun��es criadas em uma mesma linha de c�digo
		Usando o endThen > e ent�o . ele vai chamar o parOuImpar e depois
		 o resultado e passado para oResultadoE*/
		System.out.println(parOuImpar.andThen(oResultadoE).apply(56));
		
		
		
		Function<String, String> empolgado = valor-> valor +"!!!";
		String resFinal =parOuImpar.andThen(oResultadoE).andThen(empolgado).apply(34);
		System.out.println(resFinal);
		
		
		Function<String , String> adcFrase= valor -> "n�mero = a ".toUpperCase()+valor ;
		String resFinal1 =parOuImpar.andThen(adcFrase).andThen(oResultadoE).andThen(empolgado).apply(34);
		System.out.println(resFinal1);
		
		
		
		Function<Integer, Integer> numMaisDez = num -> num+10;
		
		System.out.println(numMaisDez.apply(20));
		
		Function<Integer, String> isPrimo = num -> num%2 == 1 || num==2?"� primo!":"N�o � primo!";
		
		System.out.println(isPrimo.andThen(oResultadoE).apply(5));
	}
}
