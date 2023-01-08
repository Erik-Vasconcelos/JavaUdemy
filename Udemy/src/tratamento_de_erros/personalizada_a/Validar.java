package tratamento_de_erros.personalizada_a;
/*Criando o classe Validar que tem o metodo aluno e 
gera o erro de acordo com o situação*/

/*Udemy-Java 2022
Criado por Erik Vasconcelos em 13 de abr. de 2022*/
import classes_e_metodos.Testes.Aluno;

public class Validar {
	
	private Validar() {}
	
	public static void aluno(Aluno aluno) {
		if(aluno == null ) {
			throw new IllegalArgumentException("O aluno está nullo! ");
		}
		// .trim() > Não pega os espaços em branco
		if(aluno.getNome()==null | aluno.getNome().trim().isEmpty()) {
			throw new StringVaziaException("nome");
		}
		if(aluno.getNota() <0 || aluno.getNota() >10) {
			throw new NumeroForaIntervaloException("nota");
		}
	}
}
