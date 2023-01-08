package lambdas;

public class Teste {
	public static void main(String[] args) {
		Calculo soma = (x, y) -> {return x+y;};
		Calculo max = (x, y) -> x > y? x : y;
		
		System.out.println(soma.executar(45, 98));
		System.out.println(max.executar(45, 98));
	}
}
