package tratamento_de_erros;

import classes_e_metodos.Testes.Aluno;

public class Basico {
	public static void main(String[] args) {
		
		//Exece��o de numero dividido por 0
		try {
			System.out.println(6/0);
		}catch(Exception e){
			System.out.println("Ocorreu um erro: " +e.getMessage()  );
		}
		
		//exce��o de imprimir um atributo de objeto em que ele est� null
		Aluno a1 = null;
		
		try {
			imprimeNomeAluno(a1);
		}catch(Exception e) {
			System.out.println("Ocorreu um erro: "+e.getMessage());
		}
		
	}
	public static void imprimeNomeAluno(Aluno aluno) {
		System.out.println(aluno.getNome());
	}
}
