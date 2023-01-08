package modelo;

import excecao.DadosAlunoInvalidoException;

public class Validar {
	
	public static void aluno(String nome, String cpf, Integer idade, String endereco) {
		boolean condicao = nome== null| nome.trim().isEmpty() 
				||cpf==null | cpf.trim().isEmpty() 
				||idade >0 && idade <=90 | idade.toString().trim().isEmpty()
				||endereco ==null | endereco.trim().isEmpty() ;
		
		if(condicao) {
			throw new DadosAlunoInvalidoException();
		}
			

	}
	
	public static boolean matricula(Long m) {
		Long ma = Matricula.mBase();

		if(ma.toString().length() == m.toString().length()) {
			return true;
		}
		return false;
		
	}
}
