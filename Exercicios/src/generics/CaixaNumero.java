package generics;


/*Define uma classe caixa numero que recebe qualquer tipo que herde da classe Number, ou seja,
 * na hora da instancia��o de caixaNumero posso no generics passa Byte, Short, Integer,
 * Long, Float, Double. Qualquer classe que estender Number*/

public class CaixaNumero<T extends Number> extends Caixa<T>{ 
	
}
