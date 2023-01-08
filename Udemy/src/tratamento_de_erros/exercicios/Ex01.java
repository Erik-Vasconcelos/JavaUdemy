package tratamento_de_erros.exercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01 {
	/*Criar uma classe java contendo o m�todo principal para ler dois valores
	inteiros e exibir a multiplica��o dos mesmos. Durante a opera��o de
	exibi��o pode ser lan�ada uma exce��o caso n�o seja digitado valores
	inteiros. Voc� como programador deve capturar essa exce��o atrav�s
	da classe InputMismatchException e deve gerar uma mensagem
	informando que o valor n�o � v�lido.*/
	
	
	public static void main(String[] args) {
		
		// Erik Vasconcelos 13 de abr. de 2022
		Scanner leitor = new Scanner(System.in);
		
		try {
			System.out.println("Digite o primero n�mero:");
			int n1 = leitor.nextInt();
			System.out.println("Digite o segundo n�mero:");
			int n2 = leitor.nextInt();
			
			int result= n1*n2;
			System.out.println("O resultado �: "+result);
			
		}catch(InputMismatchException e) {
			System.out.println("O valor n�o � v�lido ");
		}finally {
			leitor.close();
		}

		

	}
}
