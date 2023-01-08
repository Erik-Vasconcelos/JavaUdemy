package principal;

public class Televisao {

	private int volume = 1;
	private int canal = 1;
	
	public void diminuirCanal() {
		if(canal >=1) {
			canal--;
		}
	}
	
	public void aumentarCanal() {
		if(canal <= 100) {
			canal++;
		}
	}
	
	public void aumentarVolume() {
		if(volume < 50 ) {
			volume++;
		}
	}
	
	public void diminuirVolume() {
		if(volume >=1 ) {
			volume--;
		}
	}
	
	public void mudarCanal(int canal) {
		if (canal >0 && canal <= 100) {
			this.canal = canal;
		}
	}
	
	public void status() {
		System.out.println("Canal atual: "+ canal + "Volume: " + volume);
	}
	
}
