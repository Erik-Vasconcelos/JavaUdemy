package strem_api.exercicios;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Teste {
	public static void main(String[] args) {
		Produto p1= new Produto("Notebook", 4578.9, 0.14);
		Produto p2= new Produto("Celular", 2148.7, 0.35);
		Produto p3= new Produto("impressora", 578.9, 0.10);
		Produto p4= new Produto("MacBook", 14598.9, 0.20);
		
		List<Produto> produtos = Arrays.asList(p1,p2,p3,p4);
		Predicate<Produto> valorRelevante = p -> p.getPreco() > 1000;
		
		Function<Produto, Double> calcDesconto = p -> p.getPreco() * (1-p.getDesconto());
		
		BinaryOperator<Double> totalLista = (acm, v) -> acm +v;
		
		Double resul =produtos.stream().filter(valorRelevante).map(calcDesconto).reduce(totalLista).get();
		System.out.println(resul);
		
	}
}
