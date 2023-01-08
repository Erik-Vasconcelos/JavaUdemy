package generics;

import java.util.List;

public class ListaUtil {
	
	//Sempre que for usar esse método tenho que fazer um cast porque ele retorna um object
	public static Object getUltimo1(List<? extends Object> lista) {
		//List<?> qualquer coisa
		//? extends Object > Qualquer coisa que herde de Object
		return lista.get(lista.size()-1);
		
	}
	
	
	public static <T> T getUltimo2(List<T> lista) {
		return lista.get(lista.size()-1);
		
	}

	
}
