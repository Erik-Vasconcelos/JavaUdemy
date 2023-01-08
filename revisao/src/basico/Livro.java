package basico;

import java.util.Iterator;
import java.util.Scanner;

public class Livro {
	
	public static void main(String[] args) {
		//System.out.println("Bem vindo ao Java");
		//System.out.printf("%s%n%s%n",
				//"Welcame to", "Java Programing!");
		//int n = 'f';
		
		//System.out.println(n  + 7);
		
//		System.out.println(7.8 % 3);
		
//		System.out.println(2* 5+7);
		
//		System.out.println((2 *(2*4) +3));
		
		/* 1 - ()
		 * 2 - * ou / ou %
		 * 3 - + ou -
		 * 4 - =*/
		
		/*m = (a+b+c+d+e) /5*/
		
		
		
		System.out.println(1+" "+ 4);
		
		if(4>1) 
			System.out.println("arroz");
		
		System.out.println(1+" "+ 4);
		
		//Java Doc
		/**
		 * Data primeira versao : 
		 * Data de modificacao : 11/07/2022
		 * @author erik vasconcelos
		 */
			
		
		System.out.println(7+3 * 6 / 2-1);
		System.out.println(2%2 + 2*2 - 2/2);
		System.out.println((3 * 9 * (3 + (9 * 3 / (3)))));
		
		/*11*/
		
		Scanner leitor = new Scanner(System.in);

		int numero = leitor.nextInt();
		//String numero2 = leitor.next();
		
		/*for(int i = 0; i<numero.length(); i++) {
			System.out.printf("%s   ",numero.charAt(i));
		}
		//System.out.println(numero);
	

		System.out.println(numero);*/
		String numeroFormatado = "";
		
		for (int i = 0; i <5; i++) {
			
			numeroFormatado += numero%10+"   ";
			numero = numero/10;
		}
		System.out.println(numeroFormatado);
	
	}
}
