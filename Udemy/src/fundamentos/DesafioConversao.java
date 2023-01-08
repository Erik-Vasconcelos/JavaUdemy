package fundamentos;

import java.util.Scanner;

public class DesafioConversao {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite seu Primeiro salário: ");
		String s1 = leitor.nextLine().replace(",", "."); // O replace troca um valor pelo o outro digitado como parametro
		//nesse casso em empecifico foi de trocar a virgula pelo o ponto, senão no programa poderá ocorrer uma exessão
		
		System.out.println("Digite seu segundo salário: ");
		String s2 = leitor.nextLine().replace(",", ".");
		
		System.out.println("Digite seu terceiro salário: ");
		String s3 = leitor.nextLine().replace(",", ".");
		
		// Fecha o Scanner
		leitor.close();
		double sa1=Double.parseDouble(s1);
		
		double sa2=Double.parseDouble(s2);
		
		double sa3=Double.parseDouble(s3);
		
		double media = (sa1+sa2+sa3)/3;
		
		System.out.println("a média dos salario é de: "+media);
		
	}

}
