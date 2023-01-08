package orientacao_a_objetos.heranca.teste;

import orientacao_a_objetos.heranca.Direcao;
import orientacao_a_objetos.heranca.Heroi;
import orientacao_a_objetos.heranca.Monstro;

public class Jogo {
	public static void main(String[] args) {
		Heroi heroi = new Heroi(10,11);
		
		
		Monstro Monstro = new Monstro();
		
		
		heroi.andar(Direcao.NORTE);
		System.out.println(heroi.atacar(Monstro));
		
		
		System.out.println(Monstro.vida);
		
		
		//System.out.println("x="+j1.x+"\ny="+j1.y);
	}
}
