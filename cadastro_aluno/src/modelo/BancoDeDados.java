package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import excecao.AlunoNaoEncontradoException;
import excecao.BaseDeDadosVaziaException;

public class BancoDeDados {
	
	private static Map<Long, Aluno> alunos = new HashMap<>();
	
	private BancoDeDados(){
	}
	
	public static Long cadastrarAluno(Aluno aluno) {
		
		alunos.put(aluno.getMatricula(), aluno);
		return aluno.getMatricula();
	}
	
	public static void removerAluno(Aluno aluno) {
		
		alunos.remove(aluno.getMatricula(), aluno);
	}
	
	public static Aluno buscarAluno(Long matr) throws AlunoNaoEncontradoException{
		for(Entry<Long, Aluno> aluno:alunos.entrySet()) {
			if(matr.equals(aluno.getKey())) {
				return aluno.getValue();
			}
		}
		throw new AlunoNaoEncontradoException();
	}
	
	public static boolean isVazio() {
		if(alunos.isEmpty()) {
			throw new BaseDeDadosVaziaException();
		}
		return false;
	}
	
}
