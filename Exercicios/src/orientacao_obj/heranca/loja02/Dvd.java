package orientacao_obj.heranca.loja02;

public class Dvd extends Produto{
	int tempoDuracao;
	
	public Dvd(String nome, double preco, int tempoDuracao, Long codigo) {
		super(nome, preco, codigo);
		this.tempoDuracao= tempoDuracao;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" "+tempoDuracao;
	}
	
}
