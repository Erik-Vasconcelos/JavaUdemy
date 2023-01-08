package orientacao_a_objetos.exercicios.imovel;

public class Velho extends Imovel {
	double desconto =8923.8;
	
	@Override
	public double getPreco() {
		// TODO Auto-generated method stub
		return super.getPreco()-desconto;
	}
	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	
}
