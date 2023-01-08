package orientacao_obj.heranca.loja;

public class Livro extends Produto{
	String nomeAutor;
	
	
	public Livro(String nome, double preco, String nomeAutor) {
		super(nome, preco);
		this.nomeAutor=nomeAutor;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" "+nomeAutor;
	}
}
