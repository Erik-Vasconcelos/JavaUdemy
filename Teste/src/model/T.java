package model;

import java.util.Scanner;

public class T {
	public static void main(String[] args) {
		
		// erikv 11 de ago. de 2022
		Scanner leitor = new Scanner(System.in);

		String jogar = "";
		do {
			System.out.println("Digite: ");
			jogar = leitor.next();
		}while(!(jogar.equalsIgnoreCase("S") || jogar.equalsIgnoreCase("N")));
		
		
		if(jogar.equalsIgnoreCase("S")){
			System.out.println("Chegou");
		}
		
		leitor.close();
	}
	
	

}
