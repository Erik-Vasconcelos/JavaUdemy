package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class OperadorBinario {
	public static void main(String[] args) {
		//Recebe dois parametro do mesmo tipo e o tipo de retorno é o mesmo
		
		BinaryOperator<Double> soma = (x, y) -> x+y;
		System.out.println(soma.apply(5.0, 25.0)); // > nao converte automaticamente
		//int > Double
		
		//<Double> Para tipos genéricos o java só permite classes
		
		BinaryOperator<String> concat  = (s1, s2)-> s1+" "+s2;
		System.out.println(concat.apply("Erik","Vasconcelos"));
		
		//FOREACH Funcional
		List<String> aprovados=  Arrays.asList("Erik", "Gui", "Zé", "Raul");
	
		System.out.println("\nLambda #01... ");
		//o for each recebe um Comsumer
		aprovados.forEach(n -> System.out.println(n+" !!!"));
		
		System.out.println("\nMethod Reference...");
		aprovados.forEach(System.out::println);
		
		
		
		BinaryOperator<Integer> divisao = (a, b)-> a/b;
		System.out.println(divisao.apply(10, 5));
	}
}
