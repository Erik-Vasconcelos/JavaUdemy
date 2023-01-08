package orientacao_obj.heranca;

public class Carro {

	private int velociadeAtual;
	private final int VELOCIDADEMAXIMA;
	private boolean ligado;
	private boolean estacionado;
	
	Carro(int VELOCIDADEMAXIMA){
		
		this.VELOCIDADEMAXIMA = VELOCIDADEMAXIMA;
	}
	
	void ligar() {
		ligado =true;
	}
	
	void desligar() {
		ligado =false;
		this.velociadeAtual=0;
	}
	
	void acelerar() {
		if(ligado) {
			velociadeAtual +=10;
		}
	}
	
	void frear() {
		velociadeAtual-=10;
	}

	public int getVelociadeAtual() {
		return velociadeAtual;
	}

	public boolean isLigado() {
		return ligado;
	}

	public int getVELOCIDADEMAXIMA() {
		return VELOCIDADEMAXIMA;
	}



	public void setVelociadeAtual(int velociadeAtual) {
		this.velociadeAtual = velociadeAtual;
	}

	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
	
	void estacionar() {
		estacionado = true;
	}
	
	
	
	
}
