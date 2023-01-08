package fundamentos;

public class DesafioTemperatura {
	public static void main(String[] args) {

		
		final double AJUSTE, FATOR;
		AJUSTE = 32;
		FATOR =(double) 5/9; 
		double fah = 86;
		final double celsius = (fah-AJUSTE)*FATOR;
		System.out.println("O resultado é : "+celsius+"°C");
		
	}
}
