package tratamento_de_erros;

import classes_e_metodos.Testes.Aluno;

public class Causa {
	
	public static void main(String[] args) {
		try {
			metodoA(null);
		}catch(IllegalArgumentException e) {
			//Retorna a exceção inicial do problema
			System.out.println(e.getCause().getMessage());
		}
	}
	
	static void metodoA(Aluno aluno) {
		
		try {
			metodoB(aluno);
		} catch (Exception causa) {
			throw new IllegalArgumentException(causa);
		}
	}
	static void metodoB(Aluno aluno) {
		if(aluno==null) {
			throw new NullPointerException("Está nuloooo!");
		}
		System.out.println(aluno.getNome());
	}
}
