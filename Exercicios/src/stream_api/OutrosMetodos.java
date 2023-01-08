package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class OutrosMetodos {
	
	public int soma(int a, int b) {
		return a+b;
	}
	public static void main(String[] args) {
		Aluno a1= new Aluno("Zezinho", 8.9);
		Aluno a2= new Aluno("Flavio", 4.6);
		Aluno a3= new Aluno("Carlos", 3.4);
		Aluno a4= new Aluno("Iury", 5.1);
		Aluno a5= new Aluno("Daniel", 9.4);
		Aluno a6= new Aluno("Erik", 6.5);
		Aluno a7= new Aluno("Isaac", 9.0);
		Aluno a8= new Aluno("Zezinho", 8.9);
		Aluno a9= new Aluno("Flavio", 4.6);
		Aluno a10= new Aluno("Carlos", 3.4);
		Aluno a11= new Aluno("Iury", 5.1);
		List<Aluno> alunos = Arrays.asList(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11);
		
		
		/*Interface funcional
		BinaryOperator<Integer> soma = (a, b) -> {return a+b;};
		System.out.println(soma.apply(9,4));*/
		
		/*distint -> Não pega os valores duplicados, mas para ele 
		funcionar precisa do equal e hashCode implementados*/
		
		alunos.stream().distinct().forEach(System.out::println);
		
		System.out.println();
		
		/*Pega os elementos de acordo com os parametros passados o skip é o elemento 
		 * inicial e o limit é o ponto de parado mas ele não é incluso*/
		alunos.stream().skip(0).limit(6).forEach(System.out::println);
		
		
		//Pega elementos emquanto determinada condição esteja sendo satisfeita
		System.out.println();
		alunos.stream().distinct().takeWhile(a -> a.nota>4).forEach(System.out::println);
		
		
	}
}
