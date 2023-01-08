package Arrays_E_Collections.Collections;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetHomogenio {
	public static void main(String[] args) {
		
		//Set que não é homogenio e nao preserva a ordem de inserção
		Set listaDes  =new HashSet();	
		listaDes.add(1);
		listaDes.add(3.4);
		listaDes.add("Ursola");
		listaDes.add(true);
		System.out.println(listaDes+"\n");
		
		
		
		//set homogenia e que preserva a ordem de inserção
		//<String> define que so recebera um elemento do tipo String
		SortedSet<String> nome  = new TreeSet<String>();
		nome.add("Erik");
		nome.add("Joao");
		nome.add("Caio");
		nome.add("Junior");
		
		System.out.println(nome);
		
	}
}
