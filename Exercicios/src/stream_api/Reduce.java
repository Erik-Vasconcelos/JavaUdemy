package stream_api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BinaryOperator;

public class Reduce {
	public static void main(String[] args) {
		//Transforma uma Stream em outra coisa 
		//Array de notas > Soma de todas as notas
		List<Double> notas = Arrays.asList(4.5, 8.9, 5.6, 9.0);
		List<Double> notas2 = Arrays.asList(4.5, 4.9, 3.8, 5.0);
		
		
		BinaryOperator<Double> soma = (acm,n) -> acm+n;
		
		//retorna um Optional<Double>
		Double no = notas.stream().reduce(soma).get();
		System.out.println(no);
		
		//Ja retorna um Double 
		Double no1 = notas.stream().reduce(100.0, soma);
		System.out.println(no1);
		
		//Depois do reduce você não consegue encadear outras funções como map e filter
		//Porque o reduce é uma operação terminal
		
		//ifPresent > se estiver presente executa a função
		notas2.stream().filter(n -> n>5).reduce(soma).ifPresent(System.out::println);
		
		
		Map<Integer,String> pessoas = new HashMap<>();
		pessoas.put(01, "Erik");
		pessoas.put(02, "Riam");
		pessoas.put(03, "Joao");
		System.out.println(pessoas.values());
		
		for(Entry<Integer, String> pessoa: pessoas.entrySet()) {
			System.out.print(pessoa.getKey()+" ");
			System.out.println(pessoa.getValue());
	
	}
		
		
}}
