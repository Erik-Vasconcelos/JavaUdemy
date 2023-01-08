package lambdas;

public interface UnaryNumber {
	Double realizar(double a);
	
	
	/*Posso ter metodo default na interface 
	desde que sempre esteja obedecendo a regra de sempre ter um método abstrato*/
	
	default Double fazer(double a) {
		return a*2;
	}
	
}
