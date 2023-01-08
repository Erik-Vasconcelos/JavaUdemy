package metodos3.game;

import java.security.SecureRandom;
import java.util.Scanner;

public class Jogo {
	
	public static void main(String[] args) {
		int numero = Jogo.gerarNumero();
		
		Scanner leitor = new Scanner(System.in);

		int valor=0;
		
		do {
			System.out.println("Digite o numero: ");
			valor = leitor.nextInt();
			
			if(valor==numero) {
				System.out.println("Parabens, Você conseguiu!!!");
				
			}else if(valor > numero) {
				System.out.println("Alto demais");
				
			}else if(valor < numero) {
				System.out.println("Baixo demais");
			}
		}while(valor != numero);
		
		leitor.close();
	}
	
	
	private static int gerarNumero(){
		SecureRandom random = new SecureRandom();
		return random.nextInt(1, 1000);
	}
}
