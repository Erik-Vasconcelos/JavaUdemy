package tratamento_de_erros;

import stream_api.Aluno;

public class Causa {

	public static void main(String[] args) {
		Causa.metodoA(new Aluno("", 0));
	}
	
	
	
	static void metodoA(Aluno a) {
		try{
			metodoB(a);
		}catch (Exception causa) {
			throw new IllegalArgumentException(causa);
		}
	}
	static void metodoB(Aluno a) {
		if(a == null) {
			throw new NullPointerException("Está nulooo");
		}
		System.out.println(a.getNome());
	}
}
