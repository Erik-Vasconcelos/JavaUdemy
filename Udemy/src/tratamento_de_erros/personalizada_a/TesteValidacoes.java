package tratamento_de_erros.personalizada_a;

import classes_e_metodos.Testes.Aluno;

public class TesteValidacoes {
	public static void main(String[] args) {
	
		try {
			Aluno a1= new Aluno("ana", -7);
			//Gera uma exceção
			Validar.aluno(a1);
			//Validar.aluno(null);
		} catch (StringVaziaException e) {
			System.out.println(e.getMessage());
		}catch(NumeroForaIntervaloException e) {
			System.out.println(e.getMessage());
		}
		//Uma possibilidade de tratar dois erros de uma mesma forma
		 /*catch (StringVaziaException |IllegalArgumentException e) {
				System.out.println(e.getMessage());*/
		
		System.out.println("Fim:) ");
	}
}
