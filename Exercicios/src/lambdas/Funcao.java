package lambdas;

import java.util.function.Function;

public class Funcao {
	public static void main(String[] args) {
		//recebe um tipo de entrada e um tipo de saida
		
		Function<Integer, String> parImpar  = n -> n%2==0?"Par":"Impar";
		System.out.println(parImpar.apply(56));
		
		Function<String, String> descr = v -> "O resultado é: "+v;
		
		Function<String , String> alegria = v-> v +"!!!";
		
		
		//composicaio de Funções, é emcadeamento de funcoes que modicando/ testando para
		//obter um resultado final
		String resultado = parImpar.andThen(descr).andThen(alegria).apply(90);
		System.out.println(resultado);
		
		
		
	}
}
