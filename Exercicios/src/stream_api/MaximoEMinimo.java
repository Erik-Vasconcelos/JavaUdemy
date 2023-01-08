package stream_api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximoEMinimo {
	
	/*é uma função que é implementada a partir de uma interface chamada comparator 
	 * quando se retorna 1, o primeiro é maior do que o segundo
	 * quando se retorna -1 o segundo é maior do que o primeiro
	 * quando se retorna 0 os dois são iguais de acordo com o critério definido por você
	 * Max > retorna o elemento maximo de acordo com o critério definido
	 * Min > retorna o elemento minimo de acordo com o critério definido */
	
	
	
	public static void main(String[] args) {
		Aluno a1= new Aluno("Zezinho", 8.9);
		Aluno a2= new Aluno("Flavio", 4.6);
		Aluno a3= new Aluno("Carlos", 3.4);
		Aluno a4= new Aluno("Iury", 5.1);
		Aluno a5= new Aluno("Daniel", 9.4);
		Aluno a6= new Aluno("Erik", 6.5);
		Aluno a7= new Aluno("Isaac", 9.0);
		List<Aluno> alunos = Arrays.asList(a1,a2,a3,a4,a5,a6,a7);
		
		Comparator<Aluno> melhorNota = (aluno1, aluno2)-> {
			if(aluno1.nota > aluno2.nota)return 1;
			if(aluno1.nota < aluno2.nota)return -1;
			return 0;
		};
		
		
		Aluno mN = alunos.stream().max(melhorNota).get();
		System.out.println(mN.nome+" "+mN.nota);
		
		
		Comparator<Aluno> piorNota=(aluno1, aluno2)-> {
			if(aluno1.nota < aluno2.nota)return -1;
			if(aluno1.nota > aluno2.nota)return 1;
			return 0;
			
		};
		
		
		System.out.println(alunos.stream().min(piorNota).get());
		
	}
}
