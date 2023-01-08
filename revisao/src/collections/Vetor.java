package collections;

import java.util.Arrays;

public class Vetor {
	public static void main(String[] args) {
		
		int[] numeros = new int[10];
		
		for(int i=0; i<10; i++) {
			numeros[i] = i+1;
		}
		
		System.out.println(Arrays.toString(numeros));
		System.out.println(numeros[numeros.length - 1]);
		
		double notas[] = {9.8, 7.5, 8.1, 8.9};
		
		double total=0.0;
		for (double nota : notas) {
			total+=nota;
		}
		
		System.out.println(total/notas.length);
	}
}
