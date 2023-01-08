package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class C_Map {
	
	public static void main(String[] args) {
		Map<Integer, Livro> livros = new HashMap<>();
		
		
		Livro livro  = new Livro("Java Como Programar", "Paul Deitel", 5066);
		livros.put(livro.getIsbn(), livro);
		
		Livro livro2  = new Livro("Codigo Limpo", "Robert c", 9895);
		livros.put(livro2.getIsbn(), livro2);
		
		Livro livro3  = new Livro("Refatoração", "Gabriel jonh", 7840);
		livros.put(livro3.getIsbn(), livro3);
		
		//System.out.println(livros.entrySet());
		
		System.out.println(livros.keySet());
		System.out.println(livros.containsKey(7840));
		System.out.println(livros.containsValue("Codigo limpo"));
		
		System.out.println(livros.get(9895));
		
		for(Entry<Integer, Livro> entry: livros.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		for (Livro liv : livros.values()) {
			System.out.println(liv);
		}
		
		
	}
}
