package Lambdas;

import java.util.function.UnaryOperator;

public class OperadorUnarioInterface {
	public static void main(String[] args) {
		
		UnaryOperator<Integer> maisDois = n -> n+2;
		UnaryOperator<Integer> vezesDois = n -> n*2;
		UnaryOperator<Integer> aoQuadrado = n -> n*n;
		
		int res =maisDois.andThen(vezesDois).andThen(aoQuadrado).apply(0);
		System.out.println(res);
		
		
		//Usando o .compose() que a ordem de execução começa do ultimo para o primeiro <- 
		int res2= aoQuadrado.compose(vezesDois).compose(maisDois).apply(0);
		System.out.println(res2);
	}
}
