package Arrays_E_Collections;

import java.util.Scanner;

public class DesafioArrayInterativo { 
	public static void main(String[] args) {
		// Erik Vasconcelos 25 de mar. de 2022
		Scanner leitor = new Scanner(System.in);
		System.out.println("Informe quantas notas você quer armazenar: ");
		int tam = leitor.nextInt();
		
		double[] notas = new double[tam];
		
		for(int i = 0; i< notas.length;i++) {
			System.out.printf("Informe a %d nota: ", i+1);
			notas[i] = leitor.nextDouble();
		}
		
		double media = 0;
		for(double nota: notas) {
			media+=nota;
		}
		//Armazena na variável média a divisao de media por o comprimento do vetor notas
		media/=notas.length;
		System.out.printf("A média do aluno é: %.1f ",media);
		

		leitor.close();
	}
}
