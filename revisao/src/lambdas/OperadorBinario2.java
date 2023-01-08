package lambdas;

import java.util.function.BinaryOperator;

public class OperadorBinario2 {
	public static void main(String[] args) {
		
		BinaryOperator<Integer> mutiplicar = (n1, n2) -> {return n1 * n2;};
		BinaryOperator<Double> media = (n1, n2) -> {return (n1 + n2) / 2;};
		
		System.out.println(mutiplicar.apply(7,  4));
		System.out.println(media.apply(6.5,  9.7));
	}
}
