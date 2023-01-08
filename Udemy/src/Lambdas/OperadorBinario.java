package Lambdas;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.BiFunction;
public class OperadorBinario {
	
	public static void main(String[] args) {
		
		BinaryOperator<Double> calcMedia= (n1,n2) -> (n1+n2) / 2;
		
		System.out.println(calcMedia.apply(8.9, 5.6));
		
		
		BiFunction<Double, Double, String> resultado = (n1, n2) -> {double notaFinal =(n1+n2)/2; 
		return notaFinal>=7? "Aprovado":"Reprovado";
		};
		
		System.out.println(resultado.apply(9.5, 4.1));
		
		
		Function<Double, String> conceito= (m) -> m>=7?"Aprovado": "Reprovado";
		
		//Funcao que recebe duas nortas e calcula a media depois executa o conceito e 
		System.out.println(calcMedia.andThen(conceito).apply(9.3, 5.3));
		
	}
}
