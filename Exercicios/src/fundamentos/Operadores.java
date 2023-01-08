package fundamentos;

import javax.swing.JOptionPane;

public class Operadores {
	public static void main(String[] args) {
		
		//Un�rio
		int a = 100;
		//p�s fix > incrementa depois
		System.out.println(a++);
		
		//pr� fix > incrementa antes
		System.out.println(++a);
		
		int b = 10;
		// infix a+b;
		System.out.println(a+b);
		
		//fornece um resultado inteiro
		System.out.println((int) 234.5/100);
		
		// fornece um resultado double
		System.out.println( a/(double)b);
		
		//O Math.pow retorna um double e o cast est� convertendo para int
		int pot = (int)Math.pow(2, 3);
		System.out.println(pot);
		
		boolean t = true;
		//negacao
		System.out.println(!t);
		//negacao dupla
		System.out.println(!!t);
		
		//coloca aspas no texto \"
		System.out.println("Comprou Tv de 50\" ");
		
		//Operador de m�dulo (resto da divis�o inteira)
		System.out.println(10%3);
		int c = 10;
		System.out.println(c%=2);//c recebe o resultado do resto da divis�o
		
		int x = 1;
		int y =2;
		
		System.out.println(++x == y--);// 2 == 2 , y --
		
		//Tern�rio
		double media = 7.9;
		String result = media >=7? "Aprovado":
			media>=5?"Rercupera��o": "Reprovado";
		System.out.println(result);
		
		
		String nome = JOptionPane.showInputDialog(null, "Informe seu nome: ");

		nome.trim();
		System.out.println(nome);
		

		
	}
}
