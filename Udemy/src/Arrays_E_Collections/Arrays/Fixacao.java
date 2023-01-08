package Arrays_E_Collections.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Fixacao {
	public static void main(String[] args) {
		// Erik Vasconcelos 25 de mar. de 2022
		Scanner leitor = new Scanner(System.in);
		
		//Armazena as notas de um aluno
		/*double []notas = new double[4];
		double media =0;
		for(int i =0; i<notas.length;i++) {
			System.out.printf("Digite a nota %d do aluno:", i+1);
			media+=leitor.nextDouble();
			
		}
		media/=notas.length;
		System.out.println(media);*/
		
		
		/*double []notas = new double[4];
		double media =0;
		
		for(double nota:notas) {
			System.out.println("Digite a nota do aluno: ");
			media+=leitor.nextDouble();
		}
		
		media/=notas.length;
		System.out.println(media);*/
		
		
		
		
		double [][] notasAluno =new double[2][4];
		double media = 0;
		for(int i = 0; i<notasAluno.length; i++) {
			for(int j =0; j<notasAluno[i].length; j++) {
				System.out.printf("Digite a nota %d do aluno %d ",j+1, i+1);
				notasAluno[i][j] = leitor.nextDouble();
				media+=notasAluno[i][j];
				
			}
		}
		for(double [] nota: notasAluno) {
			System.out.println(Arrays.toString(nota));
		}
		System.out.println(media/(8));
		
		
		leitor.close();
	}
}
