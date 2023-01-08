package tratamento_de_erros;

import java.util.Scanner;

public class Final {
	public static void main(String[] args) {
		//É executado independentimente de o codigo ter havido erro ou não
		
		Scanner leitor = new Scanner(System.in);
		try {
			System.out.println("Digite um número: ");
			System.out.println(10/leitor.nextInt());

		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}finally {
			leitor.close();
		}
	}
}
