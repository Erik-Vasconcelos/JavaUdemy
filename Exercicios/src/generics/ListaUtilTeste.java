package generics;

import java.util.Arrays;
import java.util.List;

public class ListaUtilTeste {
	public static void main(String[] args) {
		
		List<String> langs = Arrays.asList("Java", "Python", "Ruby", "Lisp");
		List<Integer> nums = Arrays.asList(1,2,3,4,9);
		
		String lang = (String) ListaUtil.getUltimo1(langs);
		System.out.println(lang);
		
		Integer num = (Integer) ListaUtil.getUltimo1(nums);
		System.out.println(num);
		
	
		//Usando o metodo generico
		
		String lang2 = ListaUtil.getUltimo2(langs);
		System.out.println(lang2);
		
		Integer nume = ListaUtil.getUltimo2(nums);
		System.out.println(nume);
		
		
	}
}
