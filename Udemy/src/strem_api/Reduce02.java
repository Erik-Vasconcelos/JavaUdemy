package strem_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Reduce02 {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("Bia", 7.8);
		Aluno a2 = new Aluno("Zé", 4.8);
		Aluno a3 = new Aluno("Luca", 6.9);
		Aluno a4 = new Aluno("Gui", 9.4);
		
		List<Aluno> alunos = Arrays.asList(a1,a2,a3,a4);
		
		Predicate<Aluno> aprovado = a -> a.nota >=7.0;
		Function<Aluno, Double> nota = a -> a.nota;
		BinaryOperator<Double> somatorio = (acum, n) -> acum +n ;
		
		alunos.stream().filter(aprovado)
		.map(nota)
		.reduce(somatorio)
		.ifPresent(System.out::print);;
		
	}
}
