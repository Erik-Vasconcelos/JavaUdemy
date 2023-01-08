package topicos_avancados;

public class Recursividade {

	public static void main(String[] args) {
//		System.out.println(potencia(3,  2));
		System.out.println(fibonacci(40));
//		System.out.println(fatorial(15));
//		System.out.println(somaAnteriores(100));
//		
//		Jarro jarro = new Jarro(6);
//		esvaziar(jarro);
//		
//		System.out.println(jarro.getQuantidadeFlores());
		
//		System.out.println(somaIntervalo(1, 100));
//		System.out.println(somaXaY(1, 10));
		
	}
	
	//Faça um método recursivo para resolver um fatorial
	
	public static int fatorial(int numero) {
		if(numero <= 1) {
			return 1;
		}
		
		return numero * fatorial(numero - 1);
	}
	
	/*Faça um programa (utilizando recursividade) que peça para o 
	 * usuário digitar um número, em seguida, faça a soma de todos os algarismos do número*/
	
	public static int potencia(int numero, int elevado) {
		if(elevado == 0) {
			return 1;
		}
		
		return numero * potencia(numero, elevado - 1);
	}
	
	public static int somaXaY(int numero1, int numero2) {
		
		if(numero1 == numero2) {
			return numero2;
		}
		
		return numero2 + somaXaY(numero1, numero2 - 1);
	}
	
	public static int somaIntervalo(int numero1, int numero2) {
		
		if(numero1 == numero2) {
			return numero1;
		}
		
		return somaXaY(numero1 + 1, numero2) - numero2;
	}
	
	public static int[] inverter(int[] array, int n) {
		
		if(n == 0) {
			return array;
		}
		
		int indiceInicial = array[0];
		
		array[0] = array[n - 1];
		array[n - 1]= indiceInicial;
		
		return inverter(array, n - 1);
		
	}
	
	public static int fibonacci(int numero) {
		if(numero == 0 || numero == 1) { //caso base
			return numero;
		}
		
		return fibonacci(numero - 1) + fibonacci(numero - 2);
	}
	
	public static int somaAnteriores(int numero) {
		if(numero <= 1) { //caso base
			return 1;
		}
		
		return numero + somaAnteriores(numero - 1);
	}
	
	
	public static Jarro esvaziar(Jarro jarro) {
		if(jarro.getQuantidadeFlores() == 0) {
			return jarro;
		}
		
		return esvaziar(jarro.setQuantidadeFlores(jarro.getQuantidadeFlores() - 1));
	}
	
	public static int pA(int primeiroTermo, int posicaoTermo, int razao) {
		
		if(posicaoTermo == 1) {
			return primeiroTermo;
		}
		
		return pA(primeiroTermo + razao, posicaoTermo -1, razao);
	}
	
}
