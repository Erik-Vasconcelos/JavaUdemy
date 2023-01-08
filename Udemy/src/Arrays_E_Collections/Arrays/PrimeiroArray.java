package Arrays_E_Collections.Arrays;

import java.util.Arrays;

public class PrimeiroArray {
	public static void main(String[] args) {
		double [] notasAluno = {9.7, 8.6, 7.5, 9.1};
		
		//Imprime as notas do vetor
		System.out.println(Arrays.toString(notasAluno));
		
		System.out.println("\nFor Convencional:");
		double media = 0;
		for(int i  = 0; i<notasAluno.length;i++) {
			media+=notasAluno[i];
			
		}
		
		//pega a média e divide pelo o comprimento do vetor notasAluno
		System.out.println(media/notasAluno.length);
		
		
		//Usando o forEach(para cada)
		System.out.println("\nForEach:");
		double total =0;
		String texto= "";
		for(double nota:notasAluno) {
			total += nota;
			texto+= String.format("%.1f, ", nota);
		}
		System.out.printf("[%s]",texto);
		System.out.println("\n"+total/notasAluno.length);
	}
	
	
}
