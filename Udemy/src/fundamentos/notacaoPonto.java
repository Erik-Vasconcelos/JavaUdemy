package fundamentos;

import java.util.Scanner;

public class notacaoPonto {
	public static void main(String[] args) {
		Scanner leitor =  new Scanner(System.in);
		
		System.out.println("Digite seu nome: ");
		String nome  = leitor.next();
		String s = "Ol� seja bem-vindo X";
		
		s = s.replace("X", nome );
		s = s.concat("!!!");
		s= s.toUpperCase();
		
		System.out.println(s);
		
		System.out.println("Voce est� no ".concat("ifrn").toUpperCase().replace("IFRN", "ifrn - Instituto Federal"));
	}
}
