package orientacao_a_objetos.heranca;

public class Heroi extends Jogador{
	
	/*Definindo de forma explicita o construtor padr�o e passando os argumentos corretos
	define o construtor de heroi recebendo par�metros e chamando o contrutor da classe
	pai e passando os par�metros*/
	public Heroi(int x, int y){
		super(x, y);
	}
	@Override
	public boolean atacar(Jogador oponente) {
		/*rescreve o m�todo atacar do Her�i de modo que quando o heroi chamar o metodo
		ele chama o atacar 3 vezes, ou seja, ele tem o triplo de ataque do que o monstro
		que � de 10*/
		boolean ata1=super.atacar(oponente);
		boolean ata2=super.atacar(oponente);
		boolean ata3=super.atacar(oponente);
		
		return ata1 || ata2 || ata3;
	}
}
