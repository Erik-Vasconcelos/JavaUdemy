package orientacao_obj.heranca.loja;

public class Cd extends Produto{
	int numeroFaixas;
	
	
	public Cd(String nome, double preco, int numeroFaixas) {
		super(nome, preco);
		this.numeroFaixas = numeroFaixas;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" "+numeroFaixas;
	}
}
