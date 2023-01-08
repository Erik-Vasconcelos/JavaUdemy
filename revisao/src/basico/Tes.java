package basico;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Tes {
	public static void main(String[] args) {
		
		Scanner leitor  = new Scanner(System.in);
		/*System.out.println(new Date());
		
		System.out.println(leitor.nextInt());
		
		float nu = 8.9F;
		long numero =(long)3.8;
		
		Integer idade = 6;
		Integer idade2 = new Integer(12);
		
		System.out.println(String.format("A sua idade é: %d", leitor.nextInt()));
		
		
		System.out.println(String.format("resto: %d", leitor.nextInt()%2));
		
		System.out.println(9/2);
		System.out.println(Math.round(9.5));
		
		int numero = leitor.nextInt();
		
		System.out.println(String.format("o numero é: %s ", numero %2 ==0 ? "Par": "Impar" ));
		
		String no1="Fabio";
		String no2="Fabio";
		String no3 = new String("Fabio");
		
		System.out.println(String.format("%s", no1==no3? "Igual":"Diferente"));
		System.out.println(String.format("%s", no1.equals(no3)? "Igual":"Diferente"));
		
		int valor = 0;
		while(valor!=999) {
			valor = leitor.nextInt();
			
			if(valor %2 ==1) {
				continue;
			}
			System.out.println("Número par: "+valor);
		}
		
		int valor = leitor.nextInt();
		int cont = valor;
		int fatorial = 1;
		
		while(cont>0) {
			fatorial *= cont;
			cont--;
			System.out.println(cont);
		}
		System.out.println(fatorial);
		
		System.out.println("Digite o tamanho do vetor: ");
		int ta = leitor.nextInt();
		
		int [] numeros = new int[ta];
		
		for(int i=0; i<numeros.length;i++) {
			System.out.printf("Digite o n%d: ", i);
			numeros[i] = leitor.nextInt();
		}
		
		for(int numero: numeros) {
			System.out.println(numero);
		}
		
		int[] vetor = {2,8,32,6};

		Arrays.sort(vetor);
		
		for (int i : vetor) {
			System.out.println(i);
		}
		
		//trás o indice do elemento passado
		System.out.println(Arrays.binarySearch(vetor, 8));
		
		
		int[] idades = new int[5];
		//preenche todos os idices com o valor passado
		Arrays.fill(idades, 6);
		
		for (int i : idades) {
			System.out.println(i);
		}
		
		soma(3,  6);*/
		
		
		//posso passar um método como parâmetro para outro método
		Tes tes = new Tes();
		tes.printar(soma2(2, 5));
		
	}
	
	//void - procedimento
	public static void soma(int a, int b) {
		Tes t = new Tes();
		t.printar(a+b);
		
	}
	
	public void printar(int valor) {
		System.out.println("O resultado é: "+valor);
		
	}
	
	public static int soma2(int a, int b) {
		return a+b;
	}
	
	
}
