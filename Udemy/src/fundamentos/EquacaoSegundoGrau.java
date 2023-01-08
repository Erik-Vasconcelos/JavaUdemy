package fundamentos;

import java.util.Scanner;

public class EquacaoSegundoGrau {
	public static void main(TipoStrinng[] args) {
		Scanner leitor = new Scanner (System.in);
		
		System.out.println("Digite o valor de a : ");
		int a = leitor.nextInt();
		
		System.out.println("Digite o valor de b : ");
		double b = leitor.nextInt();
		
		System.out.println("Digite o valor de c : ");
		int c = leitor.nextInt();
		
		double delta = Math.pow(b,2) - (4*a*c);
		
		System.out.printf("O delta é %.0f",delta);
		}
}
