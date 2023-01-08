package strem_api;

import java.util.Arrays;
import java.util.List;

public class OutrosMetodos {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("Bia", 7.8);
		Aluno a2 = new Aluno("Zé", 4.8);
		Aluno a3 = new Aluno("Luca", 6.9);
		Aluno a4 = new Aluno("Gui", 9.4);
		Aluno a5 = new Aluno("Bia", 7.8);
		Aluno a6 = new Aluno("Zé", 4.8);
		Aluno a7 = new Aluno("Luca", 6.9);
		Aluno a8 = new Aluno("Gui", 9.4);
		List<Aluno> alunos = Arrays.asList(a1,a2,a3,a4,a5,a6,a7,a8);
		
		System.out.println("distinct...");
		alunos.stream().distinct().forEach(System.out::println);
		//pega os elementos distintos/ sem repetição
		
		System.out.println("\nskip/limit..");
		alunos.stream().distinct().skip(2).limit(2).forEach(System.out::print);
		//skip(2) > pule dois elementos limit(2) > tem o limite de elementos a 2 
		
		System.out.println("\n\ntakeWhile..");
		alunos.stream().distinct().takeWhile(a ->a.nota >7).forEach(System.out::println);
		//pegue o elemento enquanto a condicao for verdadeira
	}
}
