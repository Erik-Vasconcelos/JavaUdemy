package topicos_avancados;

public class Jarro {
	
	private int quantidadeFlores = 0;
	
	public Jarro(int quantidadeFlores) {
		super();
		this.quantidadeFlores = quantidadeFlores;
	}

	public int getQuantidadeFlores() {
		return quantidadeFlores;
	}

	public Jarro setQuantidadeFlores(int quantidadeFlores) {
		this.quantidadeFlores = quantidadeFlores;
		
		return this;
	}
	
}
