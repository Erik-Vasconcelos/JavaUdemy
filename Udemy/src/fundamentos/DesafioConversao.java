package fundamentos;

import java.util.Scanner;

public class DesafioConversao {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite seu Primeiro sal�rio: ");
		String s1 = leitor.nextLine().replace(",", "."); // O replace troca um valor pelo o outro digitado como parametro
		//nesse casso em empecifico foi de trocar a virgula pelo o ponto, sen�o no programa poder� ocorrer uma exess�o
		
		System.out.println("Digite seu segundo sal�rio: ");
		String s2 = leitor.nextLine().replace(",", ".");
		
		System.out.println("Digite seu terceiro sal�rio: ");
		String s3 = leitor.nextLine().replace(",", ".");
		
		// Fecha o Scanner
		leitor.close();
		double sa1=Double.parseDouble(s1);
		
		double sa2=Double.parseDouble(s2);
		
		double sa3=Double.parseDouble(s3);
		
		double media = (sa1+sa2+sa3)/3;
		
		System.out.println("a m�dia dos salario � de: "+media);
		
	}

}
