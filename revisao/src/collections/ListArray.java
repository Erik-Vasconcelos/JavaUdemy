package collections;

import java.util.ArrayList;

public class ListArray {
	public static void main(String[] args) {
		//Sistema heterogeneo(Aceita qualquer valor)
		ArrayList array = new ArrayList();
		array.add(5);
		array.add(5.97);
		array.add("Valor");
		array.add(true);
		array.add(45787L);
		
		array.forEach(e -> System.out.println(e));
		//limpa todos os elementos da arrayList
		//array.clear();
		
		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("Erik");
		nomes.add("João");
		nomes.add("Carlos");
		nomes.add("José");
		nomes.add("Carlos");
		
		//retorna o indice do primeiro elemento encontrado com o valor especificado
		System.out.println(nomes.indexOf("Carlos"));
		
		//retorna o elemento no indice passado
		System.out.println(nomes.get(3));
		
		//remove o primeiro elemento com o valor passado
		System.out.println(nomes.remove("Carlos"));
		System.out.println();
		//method reference
		nomes.forEach(System.out::println);
		
		System.out.println(nomes.size());
		System.out.println();
		
		
	}
}
