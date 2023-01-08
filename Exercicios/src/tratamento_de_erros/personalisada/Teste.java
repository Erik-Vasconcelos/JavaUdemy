package tratamento_de_erros.personalisada;

import stream_api.Aluno;

public class Teste {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("erik", 90.0);
		
		try {
			Validar.aluno(a1);
			
		}catch (StringVaziaException | NumeroForaDoImntervaloException e) {
			System.out.println(e.getMessage());
		}
	}
}
