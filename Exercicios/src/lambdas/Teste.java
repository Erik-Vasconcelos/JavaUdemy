package lambdas;

public class Teste {
	public static void main(String[] args) {
		Calculo soma = (a, b)-> {return a+b;};
		Calculo multiplicacao = (a, b)-> {return a*b;};
		
		Calculo potencia = (a, b)-> {return Math.pow(a, b);};
		
		UnaryNumber raizQuadrada = a -> {return Math.sqrt(a);};
		UnaryNumber aoQuadrado = x -> Math.pow(x, 2);
		
		NotReturn print = t-> System.out.println(t);
		
		
		print.executar(soma.executar(5,9).toString());
		
		print.executar(multiplicacao.executar(5, 10).toString());
		
		Long res = Math.round(potencia.executar(2, 3));
		print.executar(res.toString());
		
		print.executar(raizQuadrada.realizar(144).toString());
		
		print.executar(aoQuadrado.realizar(5).toString());
		
		//usando o metodo de implementação default
		UnaryNumber vezesNumber = (n) -> n;
		print.executar(vezesNumber.fazer(5).toString());
	}
}
