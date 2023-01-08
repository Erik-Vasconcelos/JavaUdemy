package classes_e_metodos.Testes;

public class AlunoTeste {

	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		a1.nome = "Erik";
		a1.cpf = "704.405.044-14";
		
		System.out.println(a1.mostrarDados());

	}

}
