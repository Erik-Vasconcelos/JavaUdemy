package basico;

import java.util.Scanner;

public class FundamentosUdemy {
	public static void main(String[] args) {
		
		/**
		 * @author erikVasconconcelos
		 */
		
		//private final boolean ATIVO = true;
		
		//8 tipos primitivos no total
		byte b1; 	Byte b2;
		short sh1;	Short sh2;
		int i1;		Integer i2;
		long l1;	Long l2;
		
		float f1;	Float f2;
		double d1;	Double d2;
		
		String s1;	String s2;
		char ch1;	Character ch2;
		
		
		//o java detecta o tipo do dad iserido
		var a = 4.9;
		var b= "Nome";
		var c = 7;
		
		
		Byte tes = 100;
		//System.out.println(tes.byteValue());
		
		//byteValue() -> valor associado
		
		Scanner leitor= new Scanner(System.in);
		
		//String s = String.format("%d", leitor.nextInt());
		//System.out.println(s);
		
		//metodo para converção
		float f  = (float) 1.98989;
		
		int nu  = 110;
		
		byte by  = (byte) nu;
		
		i2 = 156;
		
		//mostra o comprimento da variavel
		//System.out.println(i2.toString().length());
		
		//System.out.println((""+4).toString());
		
		//printa o resultado em número flutuante
		//System.out.println(6/(double)3);
		
		//System.out.println((int)Math.pow(5, 2));
		
		for(int i =0; i<10; i++) {
			System.out.println(i);
		}
		
		boolean bo = true;
		/*
		//negacao
		System.out.println(!bo);
		//negacao dupla
		System.out.println(!!bo);
		
		//colocar aspas duplas dentro de uma String
		System.out.println("Tv de 50\"");
		
		String nome = "erik";
		 nome = "erik";
		 nome = "erik";
		 nome = "erik";
		 nome = "ERIK";
		
		 //alt +shift +a edita multiplas linhas
		 
		 //numeros da tabela unicode
		 int ae = 97;
		 int ba = 'd';
		 System.out.println(ba);
		 
		 
		 int aa = 3;
		 int bb = 4;
		 System.out.println(++aa +" "+ bb--);
		 System.out.println(bb);
		 
		 System.out.println(nome.equalsIgnoreCase("erik"));
		 
		 
		
		//fro aninhado
		 for(int i =0; i<10; i++) {
			 for(int j= 0; j<10; j++) {
				 System.out.printf("[%d, %d] ", i, j);
			 }
			 System.out.println();
		 }
		 
		 
		 //controlador do for não numérico
		 for(String s = "#"; !s.equals("######"); s+="#") {
			 System.out.println(s);
		 }
		 */
		 
		 int dia = leitor.nextInt();
		 
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
		 case 6: case 7:
			 System.out.println("Final de semana!!!!");
			 break;
		 default:
			System.out.println("Dia inválido! "+dia);
		}
		 
		 
		 String nome = "erik";
		 System.out.println(nome.charAt(3));//busca no indice passado
		 
		 //break rotulado
		 
		 externo: for(int i =0; i<10; i++) {
			 interno: for(int j= 0; j<10; j++) {
				 		
				 		if(i == 5 && j ==0) {
				 			break interno;
				 		}
				 		System.out.printf("[%d, %d] ", i, j);
			 		}
			 		System.out.println();
		 }
		 
	}
	
	
}
