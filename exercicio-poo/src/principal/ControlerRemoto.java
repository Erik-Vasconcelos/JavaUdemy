package principal;

import javax.swing.JOptionPane;

public class ControlerRemoto {
	
	private Televisao televisao;

	public ControlerRemoto(Televisao televisao) {
		this.televisao = televisao;
	}

	public void aumentarVolume() {
		televisao.aumentarVolume();
	}
	
	public void diminuirVolume() {
		televisao.diminuirVolume();
	}
	
	public void aumentarCanal() {
		televisao.aumentarCanal();
	}
	
	public void diminuirCanal() {
		televisao.diminuirCanal();
	}
	
	public void settarCanal() {
		int canal = Integer.valueOf(JOptionPane.showInputDialog("Digite o canal: "));
		televisao.mudarCanal(canal);
	}
	
	public void status() {
		televisao.status();
	}
}
