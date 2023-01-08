package orientacao_obj.heranca;

public class Teste {
	public static void main(String[] args) {
		Civic c = new Civic(220);
		c.ligar();
		
		c.acelerar();
		c.acelerar();
		c.frear();
		c.acelerar();
		System.out.println(c.getVelociadeAtual());
		c.desligar();
		
		Ferrari f = new Ferrari(300);
		f.ligar();
		
		f.acelerar();
		f.acelerar();
		f.frear();
		f.acelerar();
		System.out.println(f.getVelociadeAtual());
		f.desligar();
		
		Carro car =f ;
		car.ligar();
		car.acelerar();
		car.acelerar();
		car.acelerar();
		System.out.println(car.getVelociadeAtual());
		
		//Polimorfismo
		car = new Civic(230);
		
		car.estacionar();
		
	}
}
