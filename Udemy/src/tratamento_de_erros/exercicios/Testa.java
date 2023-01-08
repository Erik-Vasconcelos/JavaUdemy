package tratamento_de_erros.exercicios;

public class Testa {
	
	private Testa() {
		
	}
	public static void altura(Aluno_parque aluno) throws AlturaInsuficienteException{
		if(aluno.altura <1.00) {
			throw new AlturaInsuficienteException(aluno);
		}else {
			System.out.println("O usuário pode prosseguir");
		}
	}
}
