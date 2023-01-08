package orientacao_a_objetos.heranca.desafio_1;

public class Carro {
	public int velocidadeAtual=0;
	protected final int VELOCIDADEMAXIMA;
	private int delta =5;
	
	protected Carro(int velocidadeMaxima){
		VELOCIDADEMAXIMA=velocidadeMaxima;
	}
	
	public void acelerar() {
		if(velocidadeAtual +getDelta() > VELOCIDADEMAXIMA) {
			velocidadeAtual=VELOCIDADEMAXIMA;
		}else {
			velocidadeAtual+=getDelta();
		}
		
	}
	public void frear() {
		if(velocidadeAtual>5) {
			velocidadeAtual-=5;
		}else {
			velocidadeAtual=0;
		}

	}

	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}

	
	
}
