package Lambdas;

import java.util.function.Predicate;

public class PredicadoInterface {
	public static void main(String[] args) {
		
		/*Interface funcional do java Predicate que recebe um tipod e parametroe retorna
		um boolean*/
		Predicate<Produto> isCaro = prod -> prod.preco * (1- prod.desconto) >=750;
		
		//caso o preco do produto dseja maior do que 750 ele retorna true 
		Produto produto  =  new Produto("Notebook", 3896.89, 0.15);
		System.out.println(isCaro.test(produto));
		
	}
}
