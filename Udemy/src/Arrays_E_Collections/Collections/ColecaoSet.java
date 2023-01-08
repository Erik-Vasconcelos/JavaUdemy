package Arrays_E_Collections.Collections;

import java.util.HashSet;
import java.util.Set;

public class ColecaoSet {
	public static void main(String[] args) {
		HashSet conjunto  =new HashSet();
		//Adiciona elemento
		conjunto.add(1);
		conjunto.add(4.5);
		conjunto.add(4);
		conjunto.add(true);
		//mostra o tamanho
		System.out.println(conjunto.size());
		//verifica se contem o elemento
		System.out.println(conjunto.contains(1));
		//remove o elemento
		conjunto.remove(4);
		//imprime o conjunto
		System.out.println(conjunto);

		System.out.println();
		Set nums = new HashSet();
		nums.add(1);
		nums.add(5);
		nums.add(4.5);
		System.out.println(nums);
		
		// adicion ao conjunto todos os elementos de nums(Uniao)
		//conjunto.addAll(nums);
		//System.out.println(conjunto);
		
		//Deixa apenas os valores comuns ao conjunto e a nums
		//Retorna uma valor booleano
		conjunto.retainAll(nums);
		System.out.println("Intercessão dos conjuntos: ");
		System.out.println(conjunto);
		
		conjunto.clear();
		System.out.println(conjunto);
		
		}
		
	}
	
	
