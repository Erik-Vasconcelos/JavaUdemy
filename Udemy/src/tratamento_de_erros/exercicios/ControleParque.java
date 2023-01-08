package tratamento_de_erros.exercicios;

public class ControleParque {
	/*11. Fa�a um software para controle de crian�as que entram em uma roda gigante
	no parque de divers�es. Para andar no brinquedo a crian�a deve ter altura
	maior que 1 metro. Caso a altura seja menor deve ser informado atrav�s de
	uma mensagem de EXCE��O que o aluno n�o possui altura suficiente. Para
	tanto crie sua pr�pria exce��o chamada AlturaInsuficienteException. Fa�a o
	
	c�digo que recebe a idade e chama um m�todo para testar a altura e que pode
	gerar a sua exce��o implicitamente.*/
	
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
