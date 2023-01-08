package classes_e_metodos.Testes;

public class Aluno {
	String nome;
	double nota;
	String cpf;
	
	public Aluno() {
		
	}
	
	public Aluno(String nome, double nota) {
		super();
		this.nome = nome;
		this.nota = nota;
		
	}

	String mostrarDados() {
		return String.format("O aluno %s tem o CPF: %s", nome, cpf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
	
	
	
	
}
