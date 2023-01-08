package collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class C_set {
	public static void main(String[] args) {
		
		/*Set -> n�o ordenado(por padr�o), nao aceita duplicacao*/
		Set<String> nomes = new HashSet<>();
		
		nomes.add("Erik");
		nomes.add("Jo�o");
		nomes.add("Luis");
		nomes.add("Caio");
		nomes.add("Paulo");
		
		nomes.forEach(System.out::println);
		System.out.println(nomes.remove("Caio"));
		System.out.println(nomes.size());
		
		System.out.println(nomes.contains("Caio"));
		System.out.println(nomes);
		
		System.out.println(nomes.addAll(new HashSet<>(Arrays.asList(
				"Riam", "Daniel", "Val�ria","Erik"))));
		
		System.out.println();
		nomes.forEach(System.out::println);
		
		//preserva a ordem de inser��o
		SortedSet<Integer> numeros = new TreeSet<>();
		numeros.addAll(new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
		numeros.forEach(System.out::println);
		
		
	}
}
