package orientacao_a_objetos.composicao;

public class Carro {
	Motor motor = new Motor();
	
	void acelerar() {
		if(motor.fatorIngessao <2.6) {
			motor.fatorIngessao +=0.5;
		}
	}
	void frear() {
		if(motor.fatorIngessao >0.5) {
			motor.fatorIngessao -=0.5;
		}
	}
	void ligar() {
		motor.ligado = true;
	}
	
	void desligar() {
		motor.ligado = false;
	}
	
	boolean estaLigado() {
		return motor.ligado;
	}
}
