package model;

public class Aluno {
	
	String nome;
	int idade;
	long matricula;
	double[] notas = {8.9, 8.2, 5.7, 6.0};
	
	public double getMedia() {
		double total = (notas[0] + notas[1] +notas[2] +notas[3]) /4 ;
		return total;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}
	
}
