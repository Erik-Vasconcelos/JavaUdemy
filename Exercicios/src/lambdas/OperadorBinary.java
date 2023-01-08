package lambdas;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class OperadorBinary {
	public static void main(String[] args) {
		//recebe dois parametros do mesmo tipo e retorna o mesmo tipo de entrada
		
		BinaryOperator<Double> media = (n1, n2) -> (n1+n2)/2;
		System.out.println(media.apply(8.9, 6.4));
	}
}
