package modelo.umpramuitos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Date data;
	
	//Criando uma relação Bidirecional
	//Um pra muitos, Um é do lado da classe
	/*Por padrao na relacao ToMany o fetch da relacao é LAZY, porque é uma lista de itens,
	e nessa lista pode haver dezenas centenas e milhares de itens*/
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)//Esse é o valor defoult do fetch
	private List<ItemPedido> itens;
	
	/*Dessa forma ele irá trazer de uma unica vez, o pedido e os itens de pedido*/
	/*@OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
	private List<ItemPedido> itens;*/
	
	/*OBS: Ao usar o EAGER voce estara trazendo TODOS os elementos se uma so vez, ou seja ,
	 * isso interfere na performance do JPA */

	
	
	public Pedido() {
		//passa a data atual para o costrutor de baixo
		this(new Date());
	}
	
	public Pedido(Date data) {
		super();
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
}