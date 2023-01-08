package orientacao_a_objetos.heranca.teste;

import orientacao_a_objetos.heranca.desafio_1.Civic;
import orientacao_a_objetos.heranca.desafio_1.Ferrari;

public class CarroTeste {
	public static void main(String[] args) {
		
		//Instanciando o civic
		Civic civic = new Civic(220);
		System.out.println(civic.velocidadeAtual);
		civic.acelerar();		
		civic.acelerar();		
		civic.acelerar();		
		civic.acelerar();	
		civic.frear();
		System.out.println(civic.velocidadeAtual);
		
		System.out.println();
		
		//Instanciando a ferrari
		Ferrari ferrari = new Ferrari(400);
		System.out.println(ferrari.velocidadeAtual);
		
		ferrari.acelerar();
		ferrari.acelerar();
		ferrari.acelerar();
		ferrari.acelerar();
		ferrari.acelerar();
		ferrari.acelerar();
		ferrari.acelerar();
		ferrari.ligarTurbo();
		System.out.println(ferrari.getDelta());
		/*nesse ponto chegou a velociade maxima padrão caso na construção tenha passado
		a velocidade maxima*/
		
		
		//A partir daqui so funciona se a velocidade passada for maior do que a padrão
		ferrari.acelerar();
		ferrari.acelerar();
		//ferrari.frear();
		System.out.println(ferrari.velocidadeAtual);
		
	}
}
