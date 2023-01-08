package model;

public class Aluno {
	int id;
	String nome;
	int idade;
	String matricula;
	String endereco;
	
	public Aluno(String nome, int idade, String matricula,String endereco) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
