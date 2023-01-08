package ArraysCollections;

import classes.Produto;

public class Equals {
	public static void main(String[] args) {
		Produto p1 = new Produto();
		p1.nome = "Caneta";
		
		Produto p2 = new Produto();
		p2.nome = "Caneta";
		
		//os dois comparam os endereços de memória,
		/*System.out.println(p1==p2); > false
		System.out.println(p1.equals(p2)); > false*/
		//Por padrão o comportamento do equals é o mesmo que o ==
		
		//com o equals implementado...
		System.out.println(p1.equals(p2));
		
		
	}
}
