package padroes.observer_;

public class Namorada implements ObservadorChegadaAniversariante {

	
	public void chegou(EventoChegadaAniversariante momento) {
		System.out.println("Avisao aos conbidados");
		System.out.println("Apagar as luzes");
		System.out.println("Esperar um pouco");
		System.out.println("Surpresa");
		
	}
	

}
