package generics;

public class TesteCaixaNumero {
	public static void main(String[] args) {
		CaixaNumero<Double> caixaDou = new CaixaNumero<>();
		caixaDou.guardar(4.5);
		
		CaixaNumero<Integer> caixaInt = new CaixaNumero<>();
		caixaInt.guardar(4);
		
	}
}
