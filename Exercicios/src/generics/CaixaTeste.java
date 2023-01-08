package generics;

public class CaixaTeste {
	public static void main(String[] args) {
		//Nas classes gen�ricas pode ou n�o ter o generics para especificar o tipo
		
		Caixa cA = new Caixa();// Heterogenio
		
		
		
		
		Caixa<String> cB = new Caixa<>();//Homogenio, s� recebe String
		cB.guardar("Segredo");//recebe String 
		
		System.out.println(cB.abrir());// retorna o tipo especificado
	}
}
