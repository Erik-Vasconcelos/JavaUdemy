package estruturas_de_controle;

import java.util.Scanner;

public class ExercicioRepeticao {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite algo: ");
		
		String op = leitor.nextLine();
		while(! op.equalsIgnoreCase("sair")) {
			System.out.println("Digite algo novamente: ");
			op = leitor.nextLine();
			
		}
		leitor.close();
	}
}
