package Lambdas;



import java.util.Arrays;
import java.util.List;

public class ForEach {
	public static void main(String[] args) {
		List<String> aprovados = Arrays.asList("Bia", "Leo", "Isa", "Lia");
		
		
		System.out.println("Forma Tradicional");
		for(String nome:aprovados) {
			System.out.println(nome);
		}
		
		System.out.println("\nLambda #01...");
		aprovados.forEach((nome) -> System.out.println(nome+"!!!"));
		
		System.out.println("\nMathod Reference..");
		aprovados.forEach(System.out::println);
		
		/*usando um metodo estatico para poder imprimir de forma personalizada o nome
		e passando para o forEach o metodo como parâmetro*/
		System.out.println("\nMathod Reference #02");
		aprovados.forEach(nome -> meuImprime(nome));
		
		
		
		
	}
	
	static void meuImprime(String nome) {
		System.out.println("Oi! meu nome é "+nome);
	}
}
