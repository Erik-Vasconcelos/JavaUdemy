package orientacao_obj.Interfaces;

public class Quadrado implements FormaGeometrica{
	
	private int lado;
	
	public void recebeLado(int lado) {
		this.lado=lado;
	}
	
	@Override
	public int calculaArea() {
		return (int)Math.pow(lado, 2);
	}

}
