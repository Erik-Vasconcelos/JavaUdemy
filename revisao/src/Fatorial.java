import java.util.Scanner;

public class Fatorial {
	public static void main(String[] args) {
		// erikv 12 de jul. de 2022
		Scanner leitor = new Scanner(System.in);

		int valor = leitor.nextInt();
		int aux =valor;
		int fatorial = 1;
		
		while(aux>1) {
			fatorial = fatorial *aux;
			aux--;
			
		}
		System.out.println(fatorial);

		leitor.close();
	}
}
