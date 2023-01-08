package orientacao_obj.Interfaces;

public class Circulo implements FormaGeometrica {
	
	private int raio;
	private final double PI= 3.14;
	
	public void recebeRaio(int raio) {
		this.raio = raio;
	}
	
	@Override
	public int calculaArea() {
		return (int) PI*(raio*raio);
	}
}
