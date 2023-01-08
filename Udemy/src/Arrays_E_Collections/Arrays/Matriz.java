package Arrays_E_Collections.Arrays;


import java.util.Arrays;
import java.util.Scanner;

public class Matriz {
	public static void main(String[] args) {
		// Erik Vasconcelos 25 de mar. de 2022
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite quantos Alunos terá? ");
		int al = leitor.nextInt();
		
		System.out.println("Digite quantas notas o alunos terá? ");
		int nNotas = leitor.nextInt();
		
		
		double[][] matriz = new double [al][nNotas];
		double mediaTurma=0;
		
		for(int a =0; a<matriz.length;a++) {
			
			for(int n =0; n< matriz[a].length;n++) {
				
				System.out.printf("Digite a nota %d do aluno %d: ", n+1, a+1);
				matriz[a][n] =leitor.nextDouble();
				mediaTurma+=matriz[a][n];
			}
		}
		
			
		mediaTurma/=al*nNotas;
		
		for(double []notas: matriz) {
			System.out.println(Arrays.toString(notas));
		}
		System.out.println(mediaTurma);
		leitor.close();
	}
}

