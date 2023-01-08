package Lambdas;

import java.util.function.BinaryOperator;

import javax.script.Invocable;

/*Udemy-Java 2022
Criado por Erik Vasconcelos em 6 de abr. de 2022*/

public class Teste2 {
	public static void main(String[] args) {
		
		//Usando a interface funcional do Java a BinaryOperator
		
		BinaryOperator<Integer> calc = (x, y) ->{return x+y;};
		System.out.println(calc.apply(5, 9));
		
		calc = (x, y) -> x*y;
		System.out.println(calc.apply(5, 9));
	
		
	}}
