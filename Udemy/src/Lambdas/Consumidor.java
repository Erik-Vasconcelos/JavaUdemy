package Lambdas;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.List;
public class Consumidor {
	public static void main(String[] args) {
		
		Consumer<Produto> imprimeNome = p -> System.out.println(p.nome+"!!!");
		
		
		Produto p1 = new Produto("Notebook", 5687.98, 0.25);
		
		imprimeNome.accept(p1);
		
		Produto p2 = new Produto("Caderno", 45.9, 0.15);
		Produto p3 = new Produto("Mochila", 127.98, 0.10);
		Produto p4 = new Produto("Lapis", 5.8, 0.08);
		Produto p5 = new Produto("Borracha", 4.67, 0.13);
		
		List<Produto> produto = Arrays.asList(p1,p2,p3,p4,p5);
		produto.forEach(imprimeNome);
		System.out.println();
		produto.forEach(p-> System.out.println(p.preco));
		System.out.println();
		produto.forEach(System.out::println);
	}
}
