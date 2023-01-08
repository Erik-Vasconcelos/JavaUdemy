package strem_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;


public class DesafioMap {
	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		Consumer<String> print = System.out::println;
		
		/* 1 - Número para String binária ... 6 => "110"
		 * 2 - Inverter a String... "110" => "011"
		 * 3 - Converter de vlta para inteiro... "011" => 3
		 * */
		UnaryOperator<String> inverter = s -> new StringBuilder(s).reverse().toString();
		
		Function<String, Integer> binarioDecimal = texto -> Integer.parseInt(texto, 2);
		//Transforma de binario parea decinal recebendo o 2
		
		nums.stream().map(Integer::toBinaryString)
		.map(inverter).map(binarioDecimal)
		.forEach(System.out::println);
		
		  
	
		
	}
}
