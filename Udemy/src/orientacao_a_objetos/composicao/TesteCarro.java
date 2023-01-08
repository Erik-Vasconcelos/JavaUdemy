package orientacao_a_objetos.composicao;

public class TesteCarro {
	public static void main(String[] args) {
		
		Carro c1 = new Carro();
		
		System.out.println(c1.estaLigado());
		
		c1.ligar();
		System.out.println(c1.estaLigado());
		System.out.println(c1.motor.giros());
		c1.acelerar();
		c1.acelerar();
		c1.acelerar();
		c1.acelerar();
		c1.acelerar();
		
		c1.frear();
		c1.frear();
		System.out.println(c1.motor.giros());
		
		c1.desligar();
		System.out.println(c1.motor.giros());
	}
}
