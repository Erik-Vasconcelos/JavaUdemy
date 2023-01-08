package topicos_avancados;

import java.math.BigInteger;

public class Fibonacci {
	
	public static void main(String[] args) {
		
		long antes =  System.currentTimeMillis();
		System.out.println(antes);
		for(int i = 0; i <= 40; i++) {
			System.out.printf("%d ->  %d\n", i, fibonacci(BigInteger.valueOf(i)));
		}
		long depois =  System.currentTimeMillis();
		System.out.println(depois);
		
	}
	
	public static BigInteger fibonacci(BigInteger number) {
		
		if(number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE)) {
			return number;
		}
		
		//A ordem de chamada dos métodos é da esquerda para a direita -> 
		return fibonacci(number.subtract(BigInteger.ONE))
				.add(fibonacci(number.subtract(BigInteger.TWO)));
	}
	
	/*calcular o valor de Fibonacci de 30 requer 2.692.537
	chamadas! À medida que tentar calcular valores de Fibonacci maiores,
	 você notará que cada número de Fibonacci consecutivo que
	solicita ao aplicativo para isso resulta em um aumento substancial
	 no tempo de cálculo e no número de chamadas para o método
	fibonacci. Por exemplo, o valor de Fibonacci de 31 requer 4.356.617
	 chamadas, e o de 32 requer 7.049.155 chamadas!*/
	
}
