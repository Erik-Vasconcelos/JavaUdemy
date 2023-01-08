package stream_api;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Filtro {
	
	public static void main(String[] args) {
		
		Consumer<Pessoa> print = System.out::println;
		
		Pessoa p1 = new Pessoa("Joao", 16);
		Pessoa p2 = new Pessoa("Davi", 60);
		Pessoa p3 = new Pessoa("Erik", 17);
		Pessoa p4 = new Pessoa("Raul", 78);
		
		
		List<Pessoa> pessoas = Arrays.asList(p1,p2,p3,p4);
		
		//pessoas.stream().filter(p-> p.idade>=18).forEach(print);
		pessoas.stream().filter(p-> p.idade>=18).map(p -> p).forEach(print);
		
		
		System.out.println();
		
		Aluno a1= new Aluno("Zezinho", 8.9);
		Aluno a2= new Aluno("Flavio", 4.6);
		Aluno a3= new Aluno("Carlos", 3.4);
		Aluno a4= new Aluno("Iury", 5.1);
		Aluno a5= new Aluno("Daniel", 9.4);
		Aluno a6= new Aluno("Erik", 6.5);
		Aluno a7= new Aluno("Isaac", 9.0);
		
		List<Aluno> alunos = Arrays.asList(a1,a2,a3,a4,a5,a6,a7);
		
		Predicate<Aluno>  aprovado = a-> a.nota >=7.0;
		Function<Aluno, String> saudacao = a-> a.nome+" Parabens!!!";
		
		
		alunos.stream().filter(aprovado).map(saudacao).forEach(System.out::println);
		Filtro f = new Filtro();
		
		

	}
	
	
	
	
	
}
