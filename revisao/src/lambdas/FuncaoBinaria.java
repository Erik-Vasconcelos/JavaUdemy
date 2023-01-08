package lambdas;

import java.util.Arrays;
import java.util.function.BiFunction;

public class FuncaoBinaria {
	public static void main(String[] args) {
		
		BiFunction<Double[], Double[], String> resultado = (notas1, notas2) -> { 
			double total1 =0.0;
			
			for (Double nota : notas1) {
				total1+=nota;
			}
			total1 /= notas1.length;
			
			double total2 = 0.0;
			for (Double nota : notas2) {
				total2+=nota;
			}
			total2 /= notas2.length;
			
			return String.format("Bimestre 1: %.1f%nBimestre 2: %.1f%nTotal: %.1f", total1, total2, (total1+total2)/2);
			
		};
		
		
		Double[] notasB1 = {9.8, 9.7, 4.6, 8.6};
		Double[] notasB2 = {8.9, 4.1, 6.9, 9.9};
		
		System.out.println(resultado.apply(notasB1, notasB2));
	}
}
