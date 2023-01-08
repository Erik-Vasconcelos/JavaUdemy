package br.com.cod3r.exerciciossb.model.entities;

public class Calculadora {

	public static String somar(int a, int b) {
		return String.format("A soma de %d + %d é : %d", a, b, a + b);
	}
	
	public static String subtrair(int a, int b) {
		return String.format("A subtracao de %d - %d é : %d", a, b, a - b);
	}
	
}
