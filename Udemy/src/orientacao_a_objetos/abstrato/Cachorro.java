package orientacao_a_objetos.abstrato;

public class Cachorro extends Mamifero{
	/*Nao pode ser sobreescrever o metodo porque ele foi definido como final na classe 
	mamifero*/
//	@Override
//	public String mover() {
//		return "Usando as patas";
//	}
	@Override
	public String mamar() {
		return "Usando leite";
	}
}
