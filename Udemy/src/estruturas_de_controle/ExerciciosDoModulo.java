package estruturas_de_controle;

import java.util.Scanner;

public class ExerciciosDoModulo {
	public static void main(String[] args) {
		// Erik Vasconcelos 21 de mar. de 2022
		Scanner leitor = new Scanner(System.in);

		
	//1. Criar um programa que receba um nu�?mero e verifique se ele está entre 0 e 10 e e�? par;
		/*int num = 0;
		System.out.println("Digite um número: ");
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
				result = "O número digitado está entre 0 e 10 e é par";
			}else {
				result = "O número digitado está entre 0 e 10  mas é impar";
			}
			
		}else {
			result = "O número digitado NÃO está entre 0 e 10 ";
		}
			System.out.println(result);*/
		

	//2. Criar um programa informa se o ano atual e�? um ano bissexto;
		/*System.out.println("Digite o ano atual: ");
		int ano = leitor.nextInt();
		
		if(ano % 4 ==0 ) {
			System.out.println("O ano é bissexto");
		}else {
			System.out.println("O ano NÃO é bissexto");
			
		}*/
		
		
		/*System.out.println("Digite os dias do ano atual: ");
		int dias = leitor.nextInt();
		
		if(dias == 366) {
			System.out.println("O ano é Bissexto!");
		}else if(dias == 365) {
			System.out.println("O ano não é Bissexto! ");
		}else {
			System.out.println("Dias incorretos!");
		}
		*/
		
	//3. Criar um programa que receba duas notas parciais, calcular a me�?dia final. Se a nota do aluno for maior ou igual a 7.0 imprime no console "Aprovado", se a nota for menor que 7.0 e maior do que 4.0 imprime no console "Recuperação", caso contra�?rio imprime no console "Reprovado".
		
		/*System.out.println("Digite a primeira nota: ");
		double n1 = leitor.nextDouble();
		System.out.println("Digite a segunda nota: ");
		double n2 = leitor.nextDouble();
		double mediaParcial = (n1+n2)/2;
		String result = "";
		
		if(mediaParcial >=7) {
			result = "Aprovado! Parabens";
		}else if(mediaParcial > 4 && mediaParcial <7) {
			result= "Recuperação";
		}else {
			result="Reprovado";
		}
		
		System.out.println(result);
		*/
		
	//4. Criar um programa que receba um número e diga se ele e�? um número primo.
		/*System.out.println("Digite um número: ");
		int num = leitor.nextInt();
		int divi=0;
		
		for(int i=1; i<=num;i++) {
			if(num % i ==0 ) {
				divi++;
			}
		}
		System.out.println(divi);
		if(divi ==2) {
			System.out.printf("O número %d é primo! ", num);
		}else {
			System.out.printf("O número %d NÃO é primo! ",num);
		}*/
		
	//5. Refatorar o exerci�?cio 04, utilizando a estrutura switch.
		/*System.out.println("Digite um número: ");
		int num = leitor.nextInt();
		int divi=0;
		for(int i=1; i<=num;i++) {
			if(num % i ==0 ) {
				divi++;
			}
		}
		
		
		switch(divi) {
		case 2 :
			System.out.println("é primo ");
			break;
		default:
			System.out.println("Não é primo!");
		}
		*/

	//6. Jogo da adivinhação: Tentar adivinhar um número entre 0 - 100. Armazene um numero aleatório em uma varia�?vel. O Jogador tem 10 tentativas para adivinhar o número gerado. Ao final de cada tentativa, imprima a quantidade de tentativas restantes, e imprima se o número inserido e�? maior ou menor do que o número armazenado.
		
		/*System.out.println("Jogo da advinhação");
		int valor = 67;
		int num;
		for(int i = 9; i>= 0; i--) {
			System.out.println("Digite um número entre 0 - 100 : ");
			num = leitor.nextInt();
			if(num == valor) {
				System.out.println("Parabens, você acertou! ");
				break;
			}
			if(num > valor) {
				System.out.println("Está acima do valor");
			}
			else {
				System.out.println("Está abaixo do valor");
			}
			System.out.printf("Você tem %d tentativas restantes\n", i);
			
		}*/
		
	//7. Criar um programa que enquanto estiver recebendo números positivos, imprime no console a soma dos números inseridos, caso receba um número negativo, encerre o programa. Tente utilizar a estrutura do while.
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
	//9. Crie um programa que recebe 10 valores e ao final imprima o maior número.
		/*int maior =0;
		int n= 0;
		for(int i =10;i>0;i--) {
			System.out.println("Digite um número: ");
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
