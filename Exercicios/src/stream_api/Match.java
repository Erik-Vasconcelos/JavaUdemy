package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Match {
	public static void main(String[] args) {
		Aluno a1= new Aluno("Zezinho", 8.9);
		Aluno a2= new Aluno("Flavio", 4.6);
		Aluno a3= new Aluno("Carlos", 3.4);
		Aluno a4= new Aluno("Iury", 5.1);
		Aluno a5= new Aluno("Daniel", 9.4);
		Aluno a6= new Aluno("Erik", 6.5);
		Aluno a7= new Aluno("Isaac", 9.0);
		List<Aluno> alunos = Arrays.asList(a1,a2,a3,a4,a5,a6,a7);
		
		Predicate<Aluno> aprovado = a-> a.nota>7;
		
		//Se todos os alunos foram aprovados...
		System.out.println(alunos.stream().allMatch(aprovado));
		
		//Se ao menos um aluno foi aprovado...
		System.out.println(alunos.stream().anyMatch(aprovado));
		
		Predicate<Aluno> reprovado = aprovado.negate();
		
		//Se nenhum aluno foi reprovado...
		System.out.println(alunos.stream().noneMatch(reprovado));
	}
}
