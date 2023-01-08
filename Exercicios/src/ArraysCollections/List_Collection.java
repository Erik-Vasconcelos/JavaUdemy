package ArraysCollections;

import java.util.ArrayList;
import java.util.List;

public class List_Collection {


public static void main(String[] args) {
	//List
	// • Homogenio / Heterogenio
	// • Aceita Duplicação
	// • É ordenado > preserva a ordem de inserção
	// • É indexada
	
	List<String> listaCompras = new ArrayList<>();
	listaCompras.add("Macarrão");
	listaCompras.add("Feijão");
	listaCompras.add("Arroz");
	listaCompras.add("Leite");
	listaCompras.add("Suco");
	
	System.out.println(listaCompras);
	
	System.out.println(listaCompras.contains("Suco"));
	
	// remove tanto pelo valor quanto pelo o indice
	listaCompras.remove("Arroz");
	listaCompras.remove(0);
	System.out.println(listaCompras);
	//Pega o elemento da lista através do indice
	System.out.println(listaCompras.get(2));
	
	//retorna o indice do elemento passado
	System.out.println(listaCompras.indexOf("Feijão"));
	//verifica se a collection está vazia
	System.out.println(listaCompras.isEmpty());
	
	//recebe um predicado e remove se a comndicao for satisfeita
	System.out.println(listaCompras.removeIf(e -> e.equals("Suco")));
	System.out.println(listaCompras);
	
	//Method Refernce..
	listaCompras.forEach(System.out::println);
	
	listaCompras.clear();//limpa a collection
	System.out.println(listaCompras);
}
}