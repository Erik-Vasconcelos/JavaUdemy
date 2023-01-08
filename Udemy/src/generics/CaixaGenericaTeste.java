package generics;

public class CaixaGenericaTeste {
	public static void main(String[] args) {
		Caixa<String> caixaA = new Caixa<>();
		caixaA.guardar("Erik");
		
		String coisaA = caixaA.abrir();
		System.out.println(coisaA);
		
		
		Caixa<Double> caixaB  =new Caixa<>();
		caixaB.guardar(5.8);
		
		Double coisaB = caixaB.abrir();
		System.out.println(coisaB);
	}
}
