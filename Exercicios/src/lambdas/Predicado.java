package lambdas;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Predicado {
	public static void main(String[] args) {
		//Recebe um tipo de entrada e retorna um valor boolean...
		
		Predicate<Double> aprovado = m -> m >=7;
		System.out.println("Está aprovado? "+aprovado.test(8.9));
		
		Predicate<Produto> isCaro = p -> p.preco * (1-p.deconto) > 1000;
		
		Produto produto = new Produto("S22", 5689.4, 0.56);
		System.out.println(isCaro.test(produto));
		
		Produto produto2 = new Produto("Epson-1030", 1256.9, 0.26);
		System.out.println(isCaro.test(produto2));

		Predicate<Integer> maiorIdade = i -> i >=18;
		
	}
}
