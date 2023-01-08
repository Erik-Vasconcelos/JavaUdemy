package orientacao_a_objetos.heranca;

public class Heroi extends Jogador{
	
	/*Definindo de forma explicita o construtor padrão e passando os argumentos corretos
	define o construtor de heroi recebendo parâmetros e chamando o contrutor da classe
	pai e passando os parâmetros*/
	public Heroi(int x, int y){
		super(x, y);
	}
	@Override
	public boolean atacar(Jogador oponente) {
		/*rescreve o método atacar do Herói de modo que quando o heroi chamar o metodo
		ele chama o atacar 3 vezes, ou seja, ele tem o triplo de ataque do que o monstro
		que é de 10*/
		boolean ata1=super.atacar(oponente);
		boolean ata2=super.atacar(oponente);
		boolean ata3=super.atacar(oponente);
		
		return ata1 || ata2 || ata3;
	}
}
