package model;

import java.util.Scanner;

public class TesteAluno {

	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		
		Scanner leitor = new Scanner(System.in);
		
		String nomeAluno = leitor.nextLine();
		aluno.setNome(nomeAluno);
		System.out.println(aluno.nome);
		
		int idadeAluno = leitor.nextInt();
		aluno.setIdade(idadeAluno);
		System.out.println(aluno.idade);
		
		System.out.printf("%.3f", aluno.getMedia());
		
		
		
	}
	
}
