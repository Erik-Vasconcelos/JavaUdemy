package lambdas;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BiFuncao {
	public static void main(String[] args) {
		//Recebe dois tipos de parametro e rotorna outro tipo
		
		BiFunction<Double, Double, String> resultado = (n1, n2)-> 
		(n1+n2)/2 >=7 ?"Aprovado": (n1+n2)/2 >=5?"Recuperação":"Reprovado";
		
		System.out.println(resultado.apply(9.6, 8.0));
		System.out.println(resultado.apply(7.1, 6.0));
		System.out.println(resultado.apply(5.6, 4.0));
	}
}
