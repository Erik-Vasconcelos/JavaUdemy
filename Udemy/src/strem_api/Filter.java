package strem_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class Filter {
	public static void main(String[] args) {
		Consumer<String> print = System.out::print;
		
		Aluno a1= new Aluno("Erik", 9.8);
		Aluno a2= new Aluno("lia", 5.8);
		Aluno a3= new Aluno("Raul", 7.8);
		Aluno a4= new Aluno("Bia", 7.1);
		Aluno a5= new Aluno("Paula", 4.2);
		Aluno a6= new Aluno("José", 7.9);
		
		List<Aluno> alunos = Arrays.asList(a1,a2,a3,a4,a5,a6);
		
		
		
		alunos.stream().filter(a -> a.nota >=7.0).map(v -> "Parabens " + v.nome +
				" Nota: "+v.nota+ "\n" ).forEach(print);;
				
		//2 Forma:
		Predicate<Aluno> aprovado = a -> a.nota >=7;
		Function<Aluno, String> saudacao = a -> "Parabens " + a.nome +
				" Nota: "+a.nota+ "\n";
		//alunos.stream().filter(aprovado).map(saudacao).forEach(print);;
				
				
	}
}
