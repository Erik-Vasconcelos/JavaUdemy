package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class DAOProduto extends DAO<Produto>{
	
	public DAOProduto() {
		super(Produto.class);
	}
}
