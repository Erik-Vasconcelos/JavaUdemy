package orientacao_a_objetos.exercicios.imovel;

public class Novo extends Imovel {
	double valorAdi= 5467.9;
	
	@Override
	public double getPreco() {
		
		return super.getPreco()+valorAdi;
	}
	
	public double getValorAdi() {
		return valorAdi;
	}

	public void setValorAdi(double valorAdi) {
		this.valorAdi = valorAdi;
	}
	
	
	
}
