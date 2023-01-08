package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Predicado {
	public static void main(String[] args) {
		/*O predicado recebe um tipo e retorna um valor booleano*/
		
		Aluno a1 = new Aluno("Tirineu", 9.7);
		Aluno a2 = new Aluno("Paulo", 4.7);
		Aluno a3 = new Aluno("Flavio", 8.2);
		Aluno a4 = new Aluno("Bia", 6.4);
		Aluno a5 = new Aluno("Lia", 7.9);
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5);
		
		Predicate<Aluno> isAprovado = a -> a.getNota() > 7.0; 
		
		
		/*O consumidor recebe um tipo e não retorna nada - void*/
		Consumer<Aluno> mudarNome = a -> a.setNome(a.getNome()+"zinho");
		
		Consumer<Aluno> mensagem = a -> System.out.printf("Parabens %s, você trou %.2f pontos!!!%n", a.getNome(), a.getNota());
		System.out.println(isAprovado.test(a5));
		
		
		Consumer<Object> print = System.out::println;
		
		alunos.stream().filter(isAprovado).forEach(mensagem);
		
		Consumer<Aluno> mudarNome2 = a -> a.setNome(a.getNome() + (a.getNome().endsWith("a")? "zinha": "zinho"));
		
		
		System.out.println();
		alunos.forEach(mudarNome2);
		alunos.forEach(print);
		
		print.accept("Receba");
		
		
	}
}
