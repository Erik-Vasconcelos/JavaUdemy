package estruturas_de_controle;

import java.util.Scanner;

public class DesafiioIF {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o dia: ");
		String dia = leitor.next();	
		
		
		if(dia.toUpperCase().equals("DOMINGO")) {
			System.out.println("1");
		}
		else if(dia.toUpperCase().equals("SEDUNDA")) {
			System.out.println("2");
		}
		else if(dia.toUpperCase().equals("TERÇA")) {
			System.out.println("3");
		}
		else if(dia.toUpperCase().equals("QUARTA")) {
			System.out.println("4");
		}
		else if(dia.toUpperCase().equals("QUINTA")) {
			System.out.println("5");
		}
		else if(dia.toUpperCase().equals("SEXTA")) {
			System.out.println("6");
		}
		else if(dia.toUpperCase().equals("SABADO")) {
			System.out.println("7");

		}else {
			System.out.println("Dia inválido! ");
		}
		
		// Fecha o Scanner
		leitor.close();
	}
}
