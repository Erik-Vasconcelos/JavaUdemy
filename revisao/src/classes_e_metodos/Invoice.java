package classes_e_metodos;

public class Invoice {
	private String numero;
	private String descricao;
	private int quantidade;
	private double preco;
	
	public Invoice(String numero, String descricao, int quantidade, double preco) {
		super();
		this.numero = numero;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		if(quantidade <0) {
			this.quantidade = 0;
			
		}else {
			this.quantidade = quantidade;
		}
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if(preco <0) {
			this.preco = 0.0;
		}else {
			this.preco = preco;
		}
	}
	
	public double getInvoiceAmount() {
		return preco * quantidade;
	}
	
	
}
