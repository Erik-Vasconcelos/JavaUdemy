package Lambdas;

@FunctionalInterface
public interface Calculo {
	double executar(double a, double b);
	
	//na Interface Funcinal posso ter metodos default e estaticos sem problema
	default String legal() {
		return "legal";
	}
	
	static String muitoLegal(){
		return "Muito Legal";
	}
}
