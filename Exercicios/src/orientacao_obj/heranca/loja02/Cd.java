package orientacao_obj.heranca.loja02;

public class Cd extends Produto{
	int numeroFaixas;
	
	
	public Cd(String nome, double preco, int numeroFaixas, Long codigo) {
		super(nome, preco, codigo);
		this.numeroFaixas = numeroFaixas;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" "+numeroFaixas;
	}
}
