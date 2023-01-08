package principal;

public class Fisiculturista extends Pessoa implements Maromba{
	
	private double massaMuscular;
	
	public Fisiculturista(String nome, int peso, double massaMuscular) {
		super(nome, peso);
		this.massaMuscular = massaMuscular;
	}
	
	@Override
	public void seApresentar() {
		System.out.println("Eu sou o "+getNome()+"e tenho " + massaMuscular + " de massa muscular");
	}

	@Override
	public void treinar() {
		massaMuscular += 0.5;
	}

}
