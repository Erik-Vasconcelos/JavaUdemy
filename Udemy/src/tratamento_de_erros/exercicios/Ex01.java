package tratamento_de_erros.exercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01 {
	/*Criar uma classe java contendo o método principal para ler dois valores
	inteiros e exibir a multiplicação dos mesmos. Durante a operação de
	exibição pode ser lançada uma exceção caso não seja digitado valores
	inteiros. Você como programador deve capturar essa exceção através
	da classe InputMismatchException e deve gerar uma mensagem
	informando que o valor não é válido.*/
	
	
	public static void main(String[] args) {
		
		// Erik Vasconcelos 13 de abr. de 2022
		Scanner leitor = new Scanner(System.in);
		
		try {
			System.out.println("Digite o primero número:");
			int n1 = leitor.nextInt();
			System.out.println("Digite o segundo número:");
			int n2 = leitor.nextInt();
			
			int result= n1*n2;
			System.out.println("O resultado é: "+result);
			
		}catch(InputMismatchException e) {
			System.out.println("O valor não é válido ");
		}finally {
			leitor.close();
		}

		

	}
}
