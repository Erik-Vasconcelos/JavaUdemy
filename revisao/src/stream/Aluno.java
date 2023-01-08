package stream;

public class Aluno {
	private String nome;
	private double nota;
	
	public Aluno(String nome, double nota) {
		super();
		this.nome = nome;
		this.nota = nota;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		return String.format("Nome: %s  Nota: %.2f", nome, nota);
	}
	
}
