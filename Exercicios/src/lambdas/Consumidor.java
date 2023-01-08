package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumidor {
	public static void main(String[] args) {
		
		//Recebe um tipo de parametro e não retorna nada
		Consumer<Produto> imprimeNome = p -> System.out.println(p.nome);
		
		Produto p1 = new Produto("Redmi 10", 2543.8, 0.14);
		
		imprimeNome.accept(p1);
		
		Produto p2 = new Produto("K40", 1298.89, 0.10);
		Produto p3 = new Produto("Dell G15", 6345.89, 0.34);
		Produto p4 = new Produto("Caderno", 23.90, 0.05);
		Produto p5 = new Produto("Mouse", 34.87, 0.15);
		
		List<Produto> produtos = Arrays.asList(p1, p2, p3, p4, p5);
		
		System.out.println("\nimprime o nome dos produtos da lista");
		produtos.forEach(imprimeNome);
		
		
		
		Consumer<Produto> precoFinal  = prod-> System.out.println(prod.preco * (1-prod.deconto));
		
		System.out.println("\nimprime o preço final dos produtos da lista");
		produtos.forEach(precoFinal);
		
		System.out.println("\nChamando o to String dos produtos");
		produtos.forEach(System.out::println);
	}
}
