package strem_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Match {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("Bia", 7.8);
		Aluno a2 = new Aluno("Zé", 4.8);
		Aluno a3 = new Aluno("Luca", 6.9);
		Aluno a4 = new Aluno("Gui", 9.4);
		List<Aluno> alunos = Arrays.asList(a1,a2,a3,a4);
		Predicate<Aluno> aprovado = a -> a.nota >=7.0;
		Predicate<Aluno> reprovado = aprovado.negate();
		
		System.out.println(alunos.stream().allMatch(aprovado));
		//se todos forem
		System.out.println(alunos.stream().anyMatch(aprovado));
		//se ao menos um foi
		System.out.println(alunos.stream().noneMatch(reprovado));
		// se nenhum foi
	}
}
