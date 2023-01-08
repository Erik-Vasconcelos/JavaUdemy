package padroes.observer;

public class AniversarioSurpresa {
	public static void main(String[] args) {
		Namorada namorada =new Namorada();
		Porteiro porteiro = new Porteiro();
		porteiro.registrarObservador(namorada);
		
		//Usando Lambda
		porteiro.registrarObservador(o ->{
		System.out.println("Surpresa usando Lambda");});
		
		porteiro.monitorar();
		
	}
}
