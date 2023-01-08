package classes_e_metodos.projetinho;

import java.util.Scanner;

import classes_e_metodos.Date;

public class HeartRatesTest {
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite o nome da pessoa: ");
		String nome = leitor.next();
		
		System.out.println("Digite o sobrenome da pessoa: ");
		String sobrenome = leitor.next();
		
		System.out.println("Digite o dia do nascimento da pessoa: ");
		int dia = leitor.nextInt();
		System.out.println("Digite o mes do nascimento da pessoa: ");
		int mes = leitor.nextInt();
		System.out.println("Digite o ano do nascimento da pessoa: ");
		int ano = leitor.nextInt();
		
		HeartRates heartRates = new HeartRates(nome, sobrenome, new Date(dia, mes, ano));
		
		System.out.println(heartRates.toString());
		
		
	}
}
