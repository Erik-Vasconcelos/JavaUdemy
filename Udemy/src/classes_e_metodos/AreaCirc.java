package classes_e_metodos;

public class AreaCirc {
	double raio;
	final static double PI = Math.PI;
	
	AreaCirc(double raioIni){
		raio =raioIni;
	}
	
	double calcularArea() {
		return PI* Math.pow(raio, 2);
	}
}
