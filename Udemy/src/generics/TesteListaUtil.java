package generics;

import java.util.Arrays;
import java.util.List;

public class TesteListaUtil {
	public static void main(String[] args) {
		List<String> lang = Arrays.asList("Js", "C++", "Ruby", "Java");
		List<Integer> nums= Arrays.asList(1,2,3,4,5,6);
		
		String ling =(String)ListaUtil.getUltimo1(lang);
		Integer nume =(Integer)ListaUtil.getUltimo1(nums);
		
		System.out.println(ling);
		System.out.println(nume);
		
		//Usando o metodo 2
		System.out.println();
		String ling2 =ListaUtil.getUltimo2(lang);
		Integer nume2 =ListaUtil.<Integer>getUltimo2(nums);
		
		System.out.println(ling2);
		System.out.println(nume2);
		
		
	
	}
	
}


