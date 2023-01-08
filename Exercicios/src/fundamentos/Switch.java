package fundamentos;

import javax.swing.JOptionPane;

public class Switch {
	public static void main(String[] args) {
		
		int dia =Integer.parseInt(JOptionPane.showInputDialog(null, "Digite uma dia: "));
		
		switch (dia) {
			case 1:
				System.out.println("Domingo");
				break;
			case 2:
				System.out.println("Segunda");
				break;
			case 3:
				System.out.println("Terça");
				break;
			case 4:
				System.out.println("Quarta");
				break;
			case 5:
				System.out.println("Quinta");
				break;
			case 6:
				System.out.println("Sexta");
				break;
			case 7:
				System.out.println("Sabado");
				break;
			default:
				System.out.println("Dia informado inválido! ");
		}
		
		int nota =Integer.parseInt(JOptionPane.showInputDialog(null, "Digite uma nota: "));
		
		switch(nota) {
			case 10: case 9:
				System.out.println("Conceito A");
				break;
			case 8: case 7:
				System.out.println("Conceito B");
				break;
			case 6: case 5:
				System.out.println("Conceito C");
				break;
			case 4: case 3:
				System.out.println("Conceito D");
				break;
			case 2: case 1:case 0:
				System.out.println("Conceito E");
				break;
			default:
				System.out.println("Conceito não informado! ");
			
		}
		
		
		
		
	}
}
