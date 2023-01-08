package padroes.observer_;

public class Teste {
	public static void main(String[] args) {
		Namorada namorada= new Namorada();
		
		Prteiro porteiro = new Prteiro();
		
		porteiro.registrar(namorada);
		porteiro.monitorar();
	}
}
