package generics;

public class CaixaNumero <N extends Number> extends Caixa<N>{
	//qualquer tipo que herde de Number pode ser atribuido ao generics de CaixaNumero
}
