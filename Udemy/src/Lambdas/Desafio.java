package Lambdas;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio {

	public static void main(String[] args) {
		/*Udemy-Java 2022
		Criado por Erik Vasconcelos em 7 de abr. de 2022*/
		
		Produto p1 =  new Produto("iPad", 3235.89, 0.13);
		/*1 - A partir do Produto calcular o preco real (Com deconto)
		 *2 - Imposto Municipal: >= 2500 (8.5%) / <2500 (Insento)
		 *3 - Frete: > 3000 (100) / < 3000 (50)
		 *4 - Arredondar: deixar duas casas decimais
		 *5 - Formatar R$1234.56*/
		
		
		Function<Produto, Double> calculaPreco = n -> n.preco * (1-n.desconto);
		
		UnaryOperator<Double> calcIposto = valor -> valor>=2500? valor* 1.085:valor;
		
		UnaryOperator<Double> frete  = valor -> valor>= 3000? valor+100: valor+50;
		
		UnaryOperator<Double> arrendondar  = valor -> valor = Math.round(valor*100.0)/100.0;
		
		Function<Double, String> formataValor = valor -> "R$"+valor.toString().replace(".", ",");
		
		//Outras formas de realizar as operações:
		UnaryOperator<Double> arrendondar2  = valor -> valor = 
				Double.parseDouble(String.format("R$%.2f", valor));
		
		Function<Double, String> formataValor2 =
				valor -> valor.toString().replace(".", ",").format("R$%.2f", valor);
		
		
		
		String precofinal = calculaPreco.andThen(calcIposto).andThen(frete)
				.andThen(arrendondar).andThen(formataValor).apply(p1);
		
		System.out.println(precofinal);
	}
	

}
