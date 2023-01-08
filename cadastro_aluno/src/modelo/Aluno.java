package modelo;

public class Aluno {
	private String nome;
	private String CPF;
	private int idade;
	private String endereco;
	
	
	
	
	public Aluno(String nome, String cpf, int idade, String endereco) {
		this.nome =nome;
		this.CPF= cpf;
		this.idade =idade;
		this.endereco=endereco;
	}
	
	private Long matricula = new Matricula().getMat();
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
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

	public Long getMatricula() {
		return matricula;
	}
	
	@Override
	public String toString() {
		return "Nome: "+nome+
				"\nCPF: "+CPF+
				"\nIdade: "+idade+
				"\nEndereço: "+endereco+"\n";
	}

	}
	

	
	

