package estruturas_de_controle;

import java.util.Scanner;

public class Do_While {
	public static void main(String[] args) {
		// Erik Vasconcelos 20 de mar. de 2022
		Scanner leitor = new Scanner(System.in);
		
		String escol = "";
		
		do { 
			System.out.println("Digite qualquer palavra: ");
			System.out.println("Caso queira sair digite (sair): ");
			System.out.println("Digite: ");
			escol = leitor.nextLine();
			
		}while(!escol.equalsIgnoreCase("sair"));
		
		System.out.println("obrigado! ");

		leitor.close();
	}
}
