package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Reduce02 {
	public static void main(String[] args) {
		Consumer<String> print = System.out::println;
		
		Aluno a1= new Aluno("Zezinho", 8.9);
		Aluno a2= new Aluno("Flavio", 4.6);
		Aluno a3= new Aluno("Carlos", 3.4);
		Aluno a4= new Aluno("Iury", 5.1);
		Aluno a5= new Aluno("Daniel", 9.4);
		Aluno a6= new Aluno("Erik", 6.5);
		Aluno a7= new Aluno("Isaac", 9.0);

		List<Aluno> alunos = Arrays.asList(a1,a2,a3,a4,a5,a6,a7);
		
		Predicate<Aluno> aprovado= a-> a.nota> 7;
		Function<Aluno, Double> nota = a -> a.nota;
		BinaryOperator<Double> soma = (acm, n)-> acm + n;
		
		
		Double so = alunos.stream().filter(aprovado).map(nota).reduce(0.0,soma);
		System.out.println(" media da turma é: "+so/alunos.size());
		
		
		
		
		/*Function<Aluno, String> res = a-> String.format("Parabens %s !!!, você foi aprovado e teve a nota de %.1f",a.nome, a.nota);
		Function<Double, String> msg = n -> "Parabens, você foi aprovado e teve a nota de "+n;
		
		
		alunos.stream().filter(aprovado).map(nota).map(msg).forEach(print);
		
		System.out.println("\n2 Function");
		alunos.stream().filter(aprovado).map(res).forEach(print);*/
	}
}
