package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Fornecedor_Supplier {
	public static void main(String[] args) {
		//Não recebe nada mas retorna algo
		
		Supplier<List<String>> umaLista = ()-> Arrays.asList("Bia", "Raul", "Rebeca", "Henrique");
		//não tem os métodos logicos e o andThen() so o get();
		System.out.println(umaLista.get());
		
		
		
	}
}
