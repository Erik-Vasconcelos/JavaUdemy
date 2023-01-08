package classes_e_metodos.Testes;

import java.util.Scanner;

public class CalculoTeste {
	public static void main(String[] args) {
		// Erik Vasconcelos 24 de mar. de 2022
		Scanner leitor = new Scanner(System.in);

		

		System.out.println("Digite o primeiro número: ");
		int n1 = leitor.nextInt();
		System.out.println("Digite o segundo número: ");
		int n2 = leitor.nextInt();
		
		System.out.println(Calculos.soma(n1, n2));
		leitor.close();
	}
}
