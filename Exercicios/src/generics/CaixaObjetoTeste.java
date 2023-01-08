package generics;

public class CaixaObjetoTeste {
	public static void main(String[] args) {
		
		CaixaObjeto caixa = new CaixaObjeto();
		
		caixa.guardar(6.7);// Auto Box 6.7 double -> Double 
		
		
		Double coisa = (Double)caixa.abrir();
		System.out.println(coisa);
	}
}
