package orientacao_a_objetos.heranca;

public class Monstro extends Jogador {
	public Monstro(){
		//chamando o construtor de baixo por meio do THIS
		this(0,0);
	}
	public Monstro(int x, int y){
		super(x,y);
	}
}
