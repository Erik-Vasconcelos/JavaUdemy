package Lambdas;

public class Teste1 {
	public static void main(String[] args) {
		//Primeira funão Lambda
		Calculo calc = (x, y) ->{return x+y;};
		System.out.println(calc.executar(5, 9));
		
		calc = (x, y) -> x*y;
		System.out.println(calc.executar(5, 9));
		
		//metodos que podem ser implementados na interface funcional
		System.out.println(calc.legal());
		System.out.println(Calculo.muitoLegal());
		}
	
		
		
	}
