package orientacao_obj.heranca.loja02;

public class Livro extends Produto{
	String nomeAutor;
	
	
	public Livro(String nome, double preco, String nomeAutor, Long codigo) {
		super(nome, preco, codigo);
		this.nomeAutor=nomeAutor;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" "+nomeAutor;
	}
}
