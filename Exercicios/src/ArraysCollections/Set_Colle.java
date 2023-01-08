package ArraysCollections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Set_Colle {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		/* •Nao ordenado(Por padrão)
		 * •Nao indexado
		 * •Não aceita repetição
		 * • Pode ser Heterogenio / homogenio
		 */
		
		//Heterogenio (Aceita qualquer tipo)
		
		
		//HashSet > desordenado
		HashSet conjunto = new HashSet();
		
		System.out.println(conjunto.add("Erik"));//Retorna true caso adicionou
		conjunto.add(5.6);
		conjunto.add(100);
		conjunto.add(100);
		
		//OBS: A QUANTIDADE DE ELEMENTOS DA COLLECTION É FORNECIDO PELO 
		//O MÉTODO SIZE()
		System.out.println(conjunto.size());
		
		conjunto.remove("Erik");
		
		//intercessao entre dois conjuntos
		
		
		//limpa o conjunto
		//conjunto.clear();

		conjunto.forEach(System.out::println);
		
		//Set listaOrdenada = TreeSet<E>
		
		
		System.out.println();
		
		//HOMOGENIO e preserva a ordem de inserção
		
		Set<String> conjuntoOrdenado = new LinkedHashSet<>();
		//<String> > diz que só recebe dados Strings
		
		conjuntoOrdenado.add("Erik");
		conjuntoOrdenado.add("Joao");
		conjuntoOrdenado.add("Raul");
		conjuntoOrdenado.add("Gui");
		conjuntoOrdenado.add("Rafael");
		
		
		conjuntoOrdenado.forEach(System.out::println);
		
		System.out.println(conjuntoOrdenado.contains("erik"));
		
		System.out.println(conjuntoOrdenado);
		
		System.out.println();
		//intercessao entre dois cojuntos(valores em comun)
		conjunto.retainAll(conjuntoOrdenado);
		//Uniao entre dois conjuntos
		conjunto.addAll(conjuntoOrdenado);
		
		
		System.out.println(conjunto);
		
		// Set > mais generico  e precisa de um tipo associado
		// HashSet > desordenado
		// TreeSet > ordenado mas precisa de um Comparable
		// LinkedHashSet > ordenado
		// add > adiciona
		// remove > remove'
		// contains() >  verifica se o elemento está contido no set
		// addAll() > adiciona outra collection
		// retainAll() > Intercessao entre duas collecion
		// clear()  >Limpa o conjunto
		// syso(conjunto) > imprime a collection [Erik, Joao, Raul]
		
	
	}
}
