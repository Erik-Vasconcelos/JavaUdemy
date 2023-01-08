package multiplos;

import java.util.Scanner;

public class Certificar {
	public static void main(String[] args) {
		
		
		// erikv 28 de jun. de 2022
		/*Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o numero: ");
		int delta = leitor.nextInt();
		
		int i = delta;
		int cont =0;
		
		for(;i<=100; i+=delta) {
			
			cont++;
			System.out.println(i);
		}
		System.out.println("\nQuant: "+cont);
		
		leitor.close();*/
		
		
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o numero1: ");
		int valor1 = leitor.nextInt();
		System.out.println("Digite o numero2: ");
		int valor2 = leitor.nextInt();
		
		
		int i = valor1*valor2;
		int cont =0;
		
		for(;i<=100; i+=valor1*valor2) {
			
			cont++;
			System.out.println(i);
		}
		System.out.println("\nQuant: "+cont);
		
		leitor.close();
	}
}
