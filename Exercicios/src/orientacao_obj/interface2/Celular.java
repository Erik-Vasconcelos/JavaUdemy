package orientacao_obj.interface2;

public abstract class Celular {
	String marca;
	String modelo;
	
	boolean ligado;
	
	void ligar() {
		ligado = true;
	}
	void desligar() {
		ligado= false;
	}
}
