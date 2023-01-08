package orientacao_a_objetos.exercicios.ingresso;

import java.util.Scanner;

public class TesteIngresso {
	public static void main(String[] args) {
		
		Ingresso ingresso= new Ingresso();
		// Erik Vasconcelos 6 de abr. de 2022
		Scanner leitor = new Scanner(System.in);
		System.out.println("Tipos de ingresso:\n1 - Normal\n2 - Vip");
		System.out.println("Digite o numero do ingresso: ");
		int op= leitor.nextInt();
		
		boolean compraCofirmada= false;
		if(op ==1) {
			ingresso =new Normal();
			compraCofirmada =true;
		}else if(op==2) {
			System.out.println("Tipos de ingresso:\n1 - Camarote superior\n2 - Camarote inferior");
			System.out.println("Digite o numero do ingresso: ");
			int opVip =leitor.nextInt();
			if(opVip==1) {
				ingresso= new CamaroteSuperior();
				compraCofirmada =true;
			}else if(opVip ==2) {
				ingresso= new CamaroteInferior();
				compraCofirmada =true;
			}
			
		}else {
				System.out.println("Opção inválida!");
		}
		
		if(compraCofirmada ==true) {
			System.out.println(ingresso.imprimeValor());
		}

		leitor.close();
		
	
		
	}
}
