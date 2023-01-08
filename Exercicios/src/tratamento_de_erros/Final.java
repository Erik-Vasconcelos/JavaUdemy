package tratamento_de_erros;

import java.util.Scanner;

public class Final {
	public static void main(String[] args) {
		//� executado independentimente de o codigo ter havido erro ou n�o
		
		Scanner leitor = new Scanner(System.in);
		try {
			System.out.println("Digite um n�mero: ");
			System.out.println(10/leitor.nextInt());

		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}finally {
			leitor.close();
		}
	}
}
