package basico;

import java.util.Scanner;

public class Avaliacao {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		/*
		//1
		int numero = 0;
		
		do {
			System.out.println("Digite um número: ");
			numero = leitor.nextInt();
			
			if(numero %2 ==1) {
				System.out.println(numero);
			}
			
		} while (numero <=100 || numero<0);
		
		
		//2
		int[] valores = new int[7];
		
		for(int i =0; i<7; i++) {
			System.out.printf("Digite o numero %d: ", i+1); 
			valores[i]= leitor.nextInt();
		}
		Arrays.sort(valores);
		System.out.println("Menor: "+valores[0] 
				+"\nMaior: "+ valores[valores.length-1]);
		*/
		/*
		//4
		for(int i= 239; i>=101; i-=3) {
			System.out.println(i);
		}*/
		
		//3
		int cont =0;
		for(int i =0; i<5; i++) {
			System.out.println("Digite o número");
			cont += leitor.nextInt()%2 ==0? 1: 0;
		}
		System.out.println(cont);
	}
	
	
}
