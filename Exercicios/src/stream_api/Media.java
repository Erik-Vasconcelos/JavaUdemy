package stream_api;

public class Media {
	private double media;
	private int quant;
	
	public Media adicionar(double valor) {
		this.media+=valor;
		this.quant++;
		return this;
	}
	
	public double getValor() {
		return this.media/this.quant;
	}
	
	public static void main(String[] args) {
		Media m =new Media().adicionar(9.5).adicionar(8.7);
		System.out.println(m.getValor());
		
	}
}
