package stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		
		List<String> alunos = Arrays.asList("Riam","Carlos", "Saulo", "Paulo");
		
		System.out.println("Usando Foreach...");
		for (String aluno : alunos) {
			System.out.println(aluno);
		}
		
		
		System.out.println("Usando Iterator...");
		Iterator<String> interator = alunos.iterator();
		
		while(interator.hasNext()) {
			System.out.println(interator.next());
		}
		
		System.out.println("Usando stream...");
		alunos.stream().forEach(a -> System.out.println(a));
		/*ou */
		//alunos.stream().forEach(System.out::println);
	}
}
