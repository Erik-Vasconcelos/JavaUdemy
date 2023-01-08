package strem_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesarioFilter {
	public static void main(String[] args) {
		/*Crie seu proprio desafio em que você tenha que usar 2 filters e 1 map*/
		
		Produto p1 = new Produto("Iphone 12", "Apple", 30);
		Produto p2 = new Produto("Alienware", "Dell", 100);
		Produto p3 = new Produto("Motorola-Moto G8", "Motorola", 400);
		Produto p4 = new Produto("Mac'os", "Apple", 50);
		
		List<Produto> produto = Arrays.asList(p1,p2,p3,p4);
		
		Predicate<Produto> isApple = p-> p.marca.equals("Apple");
		Predicate<Produto> isNovo = p -> p.tempodeLancamentoDias <=100;
		
		Function<Produto, String>  discurso = p -> "Comprei um: "+p.nome+"!!!";
		
		produto.stream().filter(isApple).filter(isNovo).map(discurso).forEach(System.out::println);;
	}
}
