package principal;

import java.security.SecureRandom;

public class Recursividade {
	
	private static SecureRandom secureRandom  = new SecureRandom();
	
	public static void main(String[] args) {
		int result = potencia(5, 5);
		
		//printRange(100, 0);
		
		
		//System.out.println(generatedPassword(10).toString());
		
		Pessoa p1 = new Pessoa("Carlos");
		Pessoa p2 = p1;
		
		p1 = new Pessoa("Erik");
		
		
		System.out.println("p1: " + p1.nome);
		System.out.println("p2: " + p2.nome);
		
	}

	public static int potencia(int base, int expoente) {
		if(expoente == 0) {
			return 1;
		}
		
		return base * potencia(base, expoente - 1);
	}
	
	public static void printRange(int x, int y) {
		if(x == y) {
			System.out.println(x);
			return;
		}
		
		if (x < y) {
			System.out.println(x + ", ");
			printRange(x + 1, y);
		}else {
			System.out.println(x + ", ");
			printRange(x - 1, y);
		}
		
	}
	
	public static StringBuilder generatedPassword(int length) {
		if(length == 0) {
			return new StringBuilder("");
		}
		
		int random = secureRandom.nextInt(0, 50);
		
		char caracter = ' ';
		
		if (random % 2 == 0) {
			caracter = (char) (secureRandom.nextInt(26) + 'a');
			
			return new StringBuilder(caracter + generatedPassword(length - 1).toString());
			
		}else{
			caracter = (char) (secureRandom.nextInt(24) + '!');
			
			return new StringBuilder(caracter + generatedPassword(length - 1).toString());
		}
		
		
	}
	
}
