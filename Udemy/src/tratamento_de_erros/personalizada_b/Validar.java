package tratamento_de_erros.personalizada_b;

import classes_e_metodos.Testes.Aluno;

public class Validar {
	
	private Validar() {}
	
	public static void aluno(Aluno aluno) throws StringVaziaException , NumeroForaIntervaloException{
		if(aluno == null ) {
			throw new IllegalArgumentException("O aluno est� nullo! ");
		}
		// .trim() > N�o pega os espa�os em branco
		if(aluno.getNome()==null | aluno.getNome().trim().isEmpty()) {
			throw new StringVaziaException("nome");
		}
		
		if(aluno.getNota() <0 || aluno.getNota() >10) {
			throw new NumeroForaIntervaloException("nota");
		}
	}
	
}
