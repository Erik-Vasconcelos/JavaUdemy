package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class MapFuncao {
	public static void main(String[] args) {
//		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8);
//		nums.stream().map(e -> e+2).forEach(System.out::println);
		
		Consumer<String> print = System.out::println;
		List<String> marcas  = Arrays.asList("bmw", "audi", "honda");
		
		marcas.stream().map(m -> m.toUpperCase()).forEach(print);
		
		UnaryOperator<String> toMaiuscula = e-> e.toUpperCase(); 
		UnaryOperator<String> alegria = e-> e +"!!!";
		UnaryOperator<String> legenda = e -> "Comprei um automóvel "+e;
		
		System.out.println("\nUsando composição...");
		marcas.stream().map(toMaiuscula).map(alegria).map(legenda).forEach(print);
		
		
	}
}
