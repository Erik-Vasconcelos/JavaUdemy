package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Funcao {
	public static void main(String[] args) {
		
		/*A funcao recebe dois parâmetros no generics, um tipo de entrada e um tipo de saída*/
		Function<Integer, String> parOuImpar = n -> n %2 == 0? "Par" : "Impar";
		Consumer<String> print = System.out::println;
		
		print.accept(parOuImpar.apply(6));
		
		Pessoa p1 = new Pessoa("Riam", 56);
		Pessoa p2 = new Pessoa("Carlos", 14);
		Pessoa p3 = new Pessoa("Paulo", 19);
		Pessoa p4 = new Pessoa("Flavio", 15);
		Pessoa p5 = new Pessoa("Daniel", 18);
		
		List<Pessoa> pessoas = Arrays.asList(p1, p2, p3, p4, p5);
		
		Predicate<Pessoa> isMaior = p -> p.getIdade() >= 18;
		
		Function<Pessoa, String> mensagem  = p -> "Parabens Você foi selecionado "+p.getNome();
		Function<String, String> empolgar = s -> s + "!!!";
		
		//pessoas.stream().filter(isMaior).map(mensagem).forEach(print);
		
		print.accept(mensagem.andThen(empolgar).apply(p5));
		
		
		
		
	}
}
