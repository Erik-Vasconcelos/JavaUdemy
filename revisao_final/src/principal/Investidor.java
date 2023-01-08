package principal;

public interface Investidor {
	
	final double rentabilidade = 0.02;
	
	public void investir(double valor);
	
	public default void mostrarRentabilidade() {
		System.out.println(rentabilidade);
	}
	
	void informarInvestimento();

}
