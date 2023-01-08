package estruturas_de_controle;

import java.util.Scanner;

public class DesafioWhile {
	public static void main(String[] args) {
		 // Erik Vasconcelos 20 de mar. de 2022
		Scanner leitor = new Scanner(System.in);
		
		double notas = 0;
		double notaDigitada = 0;
		int quantNotas=0;
		
		while(notaDigitada != -1) {
			System.out.println("Digite as nota: , (-1 para sair)");
			notaDigitada = leitor.nextDouble();
			
			if(notaDigitada>= 0 && notaDigitada <= 10) {
				notas+=notaDigitada;
				quantNotas++;
			}else if (notaDigitada != -1) {
				System.out.println("Nota inválida! ");
			}
		}
		double media = notas / quantNotas;
		System.out.println("A média da turma é: "+media);
		
		leitor.close();
		
	}
	
}