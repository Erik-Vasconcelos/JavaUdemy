package orientacao_a_objetos.exercicios.imovel;

import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		// Erik Vasconcelos 6 de abr. de 2022
		
		Scanner leitor = new Scanner(System.in);
		Imovel imovel = new Imovel();
		System.out.println("====corretora de imóveis ====".toUpperCase());
		System.out.println("Opções de imóveis:\n1- Novo\n2 - Velho");
		System.out.println("Digite qual será o seu imóvel: ");
		int op = leitor.nextInt();
		
		boolean compraValidada= false;
		if(op==1) {
			imovel=new Novo();
			compraValidada= true;
		}else if(op==2) {
			imovel= new Velho();
			compraValidada= true;
		}
		if(compraValidada == true) {
			System.out.println(imovel.getPreco());
		}
		leitor.close();
	}
}
