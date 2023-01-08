package lambdas;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio {
	public static void main(String[] args) {
		
		
		Produto p1 = new Produto("Dell G15", 6578.23, 0.23);
		Produto p2 = new Produto("I-Pad", 3235.89, 0.13);
		/*1 - A partir do Produto calcular o preco real (Com deconto)
		 *2 - Imposto Municipal: >= 2500 (8.5%) / <2500 (Insento)
		 *3 - Frete: > 3000 (100) / < 3000 (50)
		 *4 - Arredondar: deixar duas casas decimais
		 *5 - Formatar R$1234.56*/
		
		
		Function<Produto, Double> calcPreco = p -> p.preco* (1-p.deconto);
		UnaryOperator<Double> imposto = v-> v >=2500? v+(v*0.085): v;
		UnaryOperator<Double> frete = v -> v>3000? v+100: v+50;
		UnaryOperator<Double> arredondar = v -> Math.round(v*100.0)/100.0;
		
		//Function<Double, String> arredondar2 = v -> String.format("%.2f", v);
		//UnaryOperator<String> formatar = s -> String.format("R$%s".replace(".", ","), s);
		
		Function<Double, String> formatar2 = s -> String.format("R$%s".replace(".", ","), s);
		
		String result = calcPreco.andThen(imposto).andThen(frete)
				.andThen(arredondar).andThen(formatar2).apply(p2);
		
		System.out.println(result);
		
	}
}
