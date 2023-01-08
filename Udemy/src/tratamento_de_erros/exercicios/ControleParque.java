package tratamento_de_erros.exercicios;

public class ControleParque {
	/*11. Faça um software para controle de crianças que entram em uma roda gigante
	no parque de diversões. Para andar no brinquedo a criança deve ter altura
	maior que 1 metro. Caso a altura seja menor deve ser informado através de
	uma mensagem de EXCEÇÃO que o aluno não possui altura suficiente. Para
	tanto crie sua própria exceção chamada AlturaInsuficienteException. Faça o
	
	código que recebe a idade e chama um método para testar a altura e que pode
	gerar a sua exceção implicitamente.*/
	
	public static void main(String[] args) {
		
		//Aluno 1
		try {
			Aluno_parque a1 = new Aluno_parque();
			a1.nome="Erik";
			a1.altura = 1.67;
			
			Testa.altura(a1);
		} catch (AlturaInsuficienteException e) {
			System.out.println(e.getMessage());
		}
		
		//Aluno 2
		try {
			Aluno_parque a2 = new Aluno_parque();
			a2.nome="Gui";
			a2.altura = 0.67;
			Testa.altura(a2);
			
		}catch(AlturaInsuficienteException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
