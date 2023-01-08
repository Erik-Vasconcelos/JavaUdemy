package generics;

public class CaixaTeste {
	public static void main(String[] args) {
		//Nas classes genéricas pode ou não ter o generics para especificar o tipo
		
		Caixa cA = new Caixa();// Heterogenio
		
		
		
		
		Caixa<String> cB = new Caixa<>();//Homogenio, só recebe String
		cB.guardar("Segredo");//recebe String 
		
		System.out.println(cB.abrir());// retorna o tipo especificado
	}
}
