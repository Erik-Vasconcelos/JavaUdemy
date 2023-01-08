package principal;

public abstract class Pessoa {
	
	private String nome;
	private int peso;
	
	public Pessoa(String nome, int peso) {
		super();
		this.nome = nome;
		this.peso = peso;
	}

	public abstract void seApresentar();
	
	public void andar() {
		System.out.println("Dois passos dados");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
}
