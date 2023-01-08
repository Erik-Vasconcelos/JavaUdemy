package fundamentos;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Rev {
	public static void main(String[] args) {
		// Erik Vasconcelos 18 de abr. de 2022
		Scanner leitor = new Scanner(System.in);
		Byte b =100;
		
		//imprime valor associado
		System.out.println(b.byteValue());
		
		//Pega o valor através do Scanner ja convertendo par Integer
		Integer i = Integer.parseInt(leitor.next());
		System.out.println(i);
		
		/*numero float tem que colocar a letrinha no final
		poque o literal padaro inteiro é o int e o padrão com
		ponto flutuante é o double*/
		float f = 1.2345F;
		
		//tranforma o b para String e imprimi o comprimento 
		System.out.println(b.toString().length());
		
		Integer num = 40;
		System.out.println((" "+num).toString());
		
		//Informa uma Mensagem
		JOptionPane.showMessageDialog(null, "Revisao", "JOptionPane", JOptionPane.INFORMATION_MESSAGE);
		//Pega uma entrada de dados
		String nome =JOptionPane.showInputDialog(null, "Digite seu nome");
		
		
		//O metodo next() pega uma palavra e o next line pega a linha inteira
		
		System.out.println(leitor.next());
		/*tem que colocar o nextLine porque o next() gera um \n e a
		proxima entada e preenchida com ele*/
		
		leitor.nextLine();
		System.out.println(leitor.nextLine());
		
		String numero = "2345.6";
		//Troca o . por ,
		numero.replace(".", ",");
		System.out.println(numero);
		
		
		
		
		leitor.close();
		
	}
}
