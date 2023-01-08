package metodos3.game;

import java.util.Scanner;

public class InstrucaoTest {
	public static void main(String[] args) {
		InstrucaoAssistida jogo = new InstrucaoAssistida();
		
		Scanner leitor = new Scanner(System.in);

		do {
			int n1 = jogo.gerarNumero();
			int n2 = jogo.gerarNumero();
			int result  = n1 * n2;
			
			int valor=0;
			do {
				System.out.println(jogo.perguntar(n1, n2));
				valor = leitor.nextInt();
				if(valor == result) {
					System.out.println(jogo.getMensagem(Evento.ACERTOU));
				}else {
					System.out.println(jogo.getMensagem(Evento.ERROU));
				}
				
			}while(valor != result);
			
		}while(true);
		
	}
}
