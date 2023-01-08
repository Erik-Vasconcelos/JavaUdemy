package Testes;

import java.util.Iterator;
import java.util.Scanner;

public class EscolhaCrescenteDecrescente {
	public static void main(String[] args) {
		// Erik Vasconcelos 29 de mar. de 2022
		Scanner leitor = new Scanner(System.in);

		System.out.println("Digite o numero: ");
		int n = leitor.nextInt();
		
		System.out.println("1 - Crescente\n2 - Decerescente");
		System.out.println("Digite a opção: ");
		int op = leitor.nextInt();
		
		if(op == 1) {
			for(int i=0; i<=n;i++) {
				System.out.println(i);
			}
		}else {
			for(int j=n;j>=0;j--) {
				System.out.println(j);
			}
		}

		leitor.close();
	}
}
