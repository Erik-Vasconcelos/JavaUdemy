package metodos3;

import java.security.SecureRandom;

public class AleatorioSeguro {
	public static void main(String[] args) {
		
		SecureRandom random = new SecureRandom();
		
		for(int i =0; i< 5; i++ ) {
			int valorAleatorio = 1+ random.nextInt(6);
			System.out.print(valorAleatorio+" ");
			
		}
		
		int valorAleatorio = random.nextInt(5, 10);

	}
}
