package orientacao_obj.Interfaces;

public class Retangulo implements FormaGeometrica{
	private int ladoA;
	private int ladoB;
	
	public void recebeLados(int ladoA, int ladoB) {
		this.ladoA= ladoA;
		this.ladoB = ladoB;
	}
	
	@Override
	public int calculaArea() {
		return ladoA*ladoB;
	}
	
}
