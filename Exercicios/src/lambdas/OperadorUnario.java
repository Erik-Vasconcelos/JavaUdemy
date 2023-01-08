package lambdas;

import java.util.function.UnaryOperator;

public class OperadorUnario {
	public static void main(String[] args) {
		//Recebe um parametro e o tipo de retorno � o mesmo da entrada
		
		UnaryOperator<Integer> vezesDois = v -> v*2;
		UnaryOperator<Integer> aoQuadrado = v -> v*v;
		
		System.out.println(vezesDois.andThen(aoQuadrado).apply(2));
		
		//O m�todo compose() realiza as opera��es ao contr�rio da �ltima para primeira
		System.out.println(vezesDois.compose(aoQuadrado).apply(2));
		
		UnaryOperator<String> maiusc = s -> s.toUpperCase();
		
		UnaryOperator<String> concat = s -> s+"!!!";
		
		System.out.println(maiusc.andThen(concat).apply("frase transformada"));
		
		
		
		
	}
}
