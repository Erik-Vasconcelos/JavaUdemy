package lambdas.exercicios;

import java.util.function.Function;
import java.util.function.UnaryOperator;

import lambdas.Produto;

public class Desafio {
	public static void main(String[] args) {
		
		Produto p1 =  new Produto("iPad", 3235.89, 0.13);
		
		/*1 - A partir do Produto calcular o preco real (Com deconto)
		 *2 - Imposto Municipal: >= 2500 (8.5%) / <2500 (Insento)
		 *3 - Frete: > 3000 (100) / < 3000 (50)
		 *4 - Arredondar: deixar duas casas decimais
		 *5 - Formatar R$1234.56*/
		
		Function<Produto, Double> calcPreco = p -> p.getPreco() * (1 - p.getDesconto());
		
		UnaryOperator<Double> imposto = v -> v >= 2500.00 ? v + (v * 0.085): v ;
		
		UnaryOperator<Double> frete = v -> v > 3000.0 ? v + 100.0: v + 50.0;
		
		UnaryOperator<Double> arredondar = v -> Math.round(v * 100.0) / 100.0; 
		
		Function<Double, String> formatar  = valor -> String.format("R$%.2f", valor).replace(".", ",");
		
		String result = calcPreco.andThen(imposto)
				.andThen(frete)
				.andThen(arredondar)
				.andThen(formatar)
				.apply(p1);
		
		System.out.println(result);
		
	}
}
