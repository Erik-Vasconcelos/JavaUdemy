package padroes.observer;

public class Namorada implements ObservadorChegadaAniversariante {

	public void chegou(EventoChegadaAniversariante evento) {
		System.out.println("Avisar os convidados");
		System.out.println("Apaga as luzes...");
		System.out.println("Esperar um pouco...");
		System.out.println("Surpresa!!!");
	}
}
