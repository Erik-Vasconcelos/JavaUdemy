package strem_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class reduce01 {
	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		BinaryOperator<Integer> somaNums = (acum, e) -> acum + e;
		
		Integer result1 =nums.stream().reduce(somaNums).get();
		System.out.println(result1);
		
		Integer result2 = nums.parallelStream().reduce(100, somaNums); 
		/*Como já foi fornecido um valor inteiro (>100<, soma), ele já retorna um Integer
		 como foi colocado o Stream parallel ele aplica um valor 
		inicial para cada elemento*/
		System.out.println(result2);
		
		nums.stream().filter(n -> n>5).reduce(somaNums).ifPresent(System.out::println);
		//Se estiver presente ele imprime
	}
}
