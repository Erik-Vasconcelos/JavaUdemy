package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Supridor {
	public static void main(String[] args) {
		/*O supplier recebe no generics um tipo de retorno, mas não recebe
		 *  nunhum argumento de entrada para poder funcionar. Ele é um fornecedor
		 *  de alguma coisa*/
		
		Supplier<List<Integer>> listaNumeros = () -> Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		System.out.println(listaNumeros.get());
		
	}
}
