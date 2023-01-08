package orientacao_obj.heranca.loja;

public class Dvd extends Produto{
	int tempoDuracao;
	
	public Dvd(String nome, double preco, int tempoDuracao) {
		super(nome, preco);
		this.tempoDuracao= tempoDuracao;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" "+tempoDuracao;
	}
	
}
