package orientacao_obj.Interfaces;

public class Triangulo implements FormaGeometrica{
	private int base;
	private int altura;
	
	
	public void recebeDados(int base, int altura) {
		this.base =base;
		this.altura= altura;
	}
	
	@Override
	public int calculaArea() {
		return (int) (base* altura )/2;
	}
	
}
