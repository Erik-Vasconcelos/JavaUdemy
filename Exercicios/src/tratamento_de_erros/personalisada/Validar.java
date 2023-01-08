package tratamento_de_erros.personalisada;

import stream_api.Aluno;

public class Validar {
	private Validar() {
		
	}

	public static void aluno(Aluno a) {
		if(a.getNome()== null || a.getNome().trim().isEmpty()) {
			throw new StringVaziaException();
		}
		if(a.getNota()<0 || a.getNota()> 10) {
			throw new NumeroForaDoImntervaloException();
		}
	}
}
