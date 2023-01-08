package estruturas_de_controle;

import java.util.Scanner;

public class ExerciciosDoModulo {
	public static void main(String[] args) {
		// Erik Vasconcelos 21 de mar. de 2022
		Scanner leitor = new Scanner(System.in);

		
	//1. Criar um programa que receba um nuﾌ?mero e verifique se ele estﾃ｡ entre 0 e 10 e eﾌ? par;
		/*int num = 0;
		System.out.println("Digite um nﾃｺmero: ");
		num = leitor.nextInt();
		String result = "";
		int recebe=0;
		
		for(int i= 1; i<10;i++) {
			if(num == i) {
				recebe =i;
				break;
			}
		}
		
		if(num == recebe && num !=0) {
			if( num %2 ==0) {
				result = "O nﾃｺmero digitado estﾃ｡ entre 0 e 10 e ﾃｩ par";
			}else {
				result = "O nﾃｺmero digitado estﾃ｡ entre 0 e 10  mas ﾃｩ impar";
			}
			
		}else {
			result = "O nﾃｺmero digitado Nﾃグ estﾃ｡ entre 0 e 10 ";
		}
			System.out.println(result);*/
		

	//2. Criar um programa informa se o ano atual eﾌ? um ano bissexto;
		/*System.out.println("Digite o ano atual: ");
		int ano = leitor.nextInt();
		
		if(ano % 4 ==0 ) {
			System.out.println("O ano ﾃｩ bissexto");
		}else {
			System.out.println("O ano Nﾃグ ﾃｩ bissexto");
			
		}*/
		
		
		/*System.out.println("Digite os dias do ano atual: ");
		int dias = leitor.nextInt();
		
		if(dias == 366) {
			System.out.println("O ano ﾃｩ Bissexto!");
		}else if(dias == 365) {
			System.out.println("O ano nﾃ｣o ﾃｩ Bissexto! ");
		}else {
			System.out.println("Dias incorretos!");
		}
		*/
		
	//3. Criar um programa que receba duas notas parciais, calcular a meﾌ?dia final. Se a nota do aluno for maior ou igual a 7.0 imprime no console "Aprovado", se a nota for menor que 7.0 e maior do que 4.0 imprime no console "Recuperacﾌｧaﾌバ", caso contraﾌ?rio imprime no console "Reprovado".
		
		/*System.out.println("Digite a primeira nota: ");
		double n1 = leitor.nextDouble();
		System.out.println("Digite a segunda nota: ");
		double n2 = leitor.nextDouble();
		double mediaParcial = (n1+n2)/2;
		String result = "";
		
		if(mediaParcial >=7) {
			result = "Aprovado! Parabens";
		}else if(mediaParcial > 4 && mediaParcial <7) {
			result= "Recuperaﾃｧﾃ｣o";
		}else {
			result="Reprovado";
		}
		
		System.out.println(result);
		*/
		
	//4. Criar um programa que receba um nﾃｺmero e diga se ele eﾌ? um nﾃｺmero primo.
		/*System.out.println("Digite um nﾃｺmero: ");
		int num = leitor.nextInt();
		int divi=0;
		
		for(int i=1; i<=num;i++) {
			if(num % i ==0 ) {
				divi++;
			}
		}
		System.out.println(divi);
		if(divi ==2) {
			System.out.printf("O nﾃｺmero %d ﾃｩ primo! ", num);
		}else {
			System.out.printf("O nﾃｺmero %d Nﾃグ ﾃｩ primo! ",num);
		}*/
		
	//5. Refatorar o exerciﾌ?cio 04, utilizando a estrutura switch.
		/*System.out.println("Digite um nﾃｺmero: ");
		int num = leitor.nextInt();
		int divi=0;
		for(int i=1; i<=num;i++) {
			if(num % i ==0 ) {
				divi++;
			}
		}
		
		
		switch(divi) {
		case 2 :
			System.out.println("ﾃｩ primo ");
			break;
		default:
			System.out.println("Nﾃ｣o ﾃｩ primo!");
		}
		*/

	//6. Jogo da adivinhaﾃｧﾃ｣o: Tentar adivinhar um nﾃｺmero entre 0 - 100. Armazene um numero aleatﾃｳrio em uma variaﾌ?vel. O Jogador tem 10 tentativas para adivinhar o nﾃｺmero gerado. Ao final de cada tentativa, imprima a quantidade de tentativas restantes, e imprima se o nﾃｺmero inserido eﾌ? maior ou menor do que o nﾃｺmero armazenado.
		
		/*System.out.println("Jogo da advinhaﾃｧﾃ｣o");
		int valor = 67;
		int num;
		for(int i = 9; i>= 0; i--) {
			System.out.println("Digite um nﾃｺmero entre 0 - 100 : ");
			num = leitor.nextInt();
			if(num == valor) {
				System.out.println("Parabens, vocﾃｪ acertou! ");
				break;
			}
			if(num > valor) {
				System.out.println("Estﾃ｡ acima do valor");
			}
			else {
				System.out.println("Estﾃ｡ abaixo do valor");
			}
			System.out.printf("Vocﾃｪ tem %d tentativas restantes\n", i);
			
		}*/
		
	//7. Criar um programa que enquanto estiver recebendo nﾃｺmeros positivos, imprime no console a soma dos nﾃｺmeros inseridos, caso receba um nﾃｺmero negativo, encerre o programa. Tente utilizar a estrutura do while.
		/*int soma = 0;
		int valorDigi = 1;
		while(valorDigi >0) {
			System.out.println("Digite: ");
			valorDigi = leitor.nextInt();
			if(valorDigi>0) {
				soma+=valorDigi;
			}
		}
		System.out.println(soma);
		*/
	//8. Criar um programa que receba uma palavra e imprime no console letra por letra.
		/*System.out.println("Digite uma palavra: ");
		String palavra = leitor.next();
		
		for(int i=0;i<palavra.length();i++) {
			System.out.println(palavra.charAt(i));
		}*/
	//9. Crie um programa que recebe 10 valores e ao final imprima o maior nﾃｺmero.
		/*int maior =0;
		int n= 0;
		for(int i =10;i>0;i--) {
			System.out.println("Digite um nﾃｺmero: ");
			n = leitor.nextInt();
			if(n>maior) {
				maior = n;
			}
		}
		System.out.println(maior);
		*/
		
		leitor.close();
	}
}
