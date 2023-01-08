package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class OperadorBinario {
	public static void main(String[] args) {
		/*O Operador binario recebe dois argumentos, de mesmo tipo e retorna um do tipo informado*/
		BinaryOperator<Integer> multiplicacao = (x, y) -> x*y;
		
		System.out.println(multiplicacao.apply(56, 6));
		
		List<String> aprovados = Arrays.asList("Erik", "João", "Carlos", "Riam");
		
		aprovados.stream()
			.map(n -> String.format("Parabens %s, você foi aporvado!!!", n))
			.forEach(System.out::println);;
			
			aprovados.forEach(n -> System.out.println(n));
	}
}
