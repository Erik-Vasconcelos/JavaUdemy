package principal;

public class Elevador {
	
	private int andarAtual;
	private int totalAndades;
	private int capaciadeElevador;
	private int nPessoas;
	
	public void inicializa(int capacidadeElevador, int totalAndares) {
		this.capaciadeElevador = capacidadeElevador;
		this.totalAndades = totalAndares;
		this.andarAtual = 0;
		this.nPessoas = 0;
	}
	
	public void entar() {
		if(capaciadeElevador < nPessoas) {
			nPessoas++;
		}
	}
	
	public void sair() {
		if (capaciadeElevador >= 1) {
			nPessoas--;
			
		}
	}
	
	public void subir() {
		if(totalAndades <= andarAtual) {
			andarAtual++;
		}
	}
	
	public void desce() {
		if(totalAndades <= andarAtual) {
			andarAtual--;
		}
	}

	public int getAndarAtual() {
		return andarAtual;
	}

	public void setAndarAtual(int andarAtual) {
		this.andarAtual = andarAtual;
	}

	public int getTotalAndades() {
		return totalAndades;
	}

	public void setTotalAndades(int totalAndades) {
		this.totalAndades = totalAndades;
	}

	public int getCapaciadeElevador() {
		return capaciadeElevador;
	}

	public void setCapaciadeElevador(Integer capaciadeElevador) {
		this.capaciadeElevador = capaciadeElevador;
	}

	public int getnPessoas() {
		return nPessoas;
	}

	public void setnPessoas(int nPessoas) {
		this.nPessoas = nPessoas;
	}
	
	
	
	
	
	
}
