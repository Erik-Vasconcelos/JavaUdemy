package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Fornecedor_Supplier {
	public static void main(String[] args) {
		//N�o recebe nada mas retorna algo
		
		Supplier<List<String>> umaLista = ()-> Arrays.asList("Bia", "Raul", "Rebeca", "Henrique");
		//n�o tem os m�todos logicos e o andThen() so o get();
		System.out.println(umaLista.get());
		
		
		
	}
}
