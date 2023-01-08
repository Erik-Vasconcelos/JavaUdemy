package strem_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Map {
	public static void main(String[] args) {
		
		Consumer<String> print= System.out::print;
		
		List<String> marcas = Arrays.asList("Bmw ", "Audi ", "Honda ");
		marcas.stream().map(n -> n.toUpperCase()).forEach(print);
		
		//UnaryOperator<String> maiuscula = e -> e.toUpperCase();
		UnaryOperator<String> primeiraLetra = e -> e.charAt(0) + "";
		//UnaryOperator<String> grito = e -> e+"!!! ";
		
		System.out.println("\nUsando Composição...");
		
		//marcas.stream().map(maiuscula).map(primeiraLetra).map(grito).forEach(print);
		
		//Usando tambem o Method reference :: , e pegando as operações de outa classe
		marcas.stream().map(Operacoes_Do_Map.maiuscula)
		.map(primeiraLetra).map(Operacoes_Do_Map::grito).forEach(print);
	}
}
