package modelo.umpramuitos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import modelo.basico.Produto;

@Entity
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne //Muitos itens de pedido est�o para um pedido
	private Pedido pedido;
	/* O Meny � do lado da classe que voc� est� annotando e ToOne do lado do pedido.
	 * Um pedido pode ter muitos itens de pedido, um item de pedido est� relacionado
	 * a �nico produto
	 * */

	@ManyToOne(fetch = FetchType.EAGER)//Por padrao o fetch de uma relacao ManyToOne � EAGER, ou seja tr�s de forma imediata
	private Produto produto;
	/* Um produto pode estar relacionado a muitos itens de pedidos,
	 * mas um item de pedido obrigatoriamente est� relacionado a um unico pedido
	 * */
	
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false)
	private Double preco;//recebe o pre�o do produto passado

	public ItemPedido() {
		
	}
	
	public ItemPedido(Pedido pedido, Produto produto, int quantidade) {
		super();
		this.setPedido( pedido);
		/*Faz o processo de setar o produto e o pre�o do produtono atributo preco*/
		this.setProduto(produto);
		this.setQuantidade(quantidade);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		if(produto != null && this.preco == null) {
			this.setPreco(produto.getPreco());
			/*Setta no atributo preco da classe o pre�o do produto que foi passado*/
		}
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
