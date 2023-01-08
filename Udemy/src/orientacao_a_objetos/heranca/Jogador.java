package orientacao_a_objetos.heranca;

public class Jogador {
	public int vida =100;
	public int x =10; 
	public int y=10;
	
	Jogador(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public boolean atacar(Jogador oponente) {
		int deltaX = Math.abs(x-oponente.x);
		int deltaY = Math.abs(y-oponente.y);
		
		boolean result =false;
		if(deltaX ==0 && deltaY ==1) {
			oponente.vida-=10;
			result= true;
		}else if(deltaX==1 && deltaY==0) {
			oponente.vida-=10;
			result =true;
		}else {
			result =false;
		}
		return result;
		
		
	}
	//Implementando o ENUM
	public boolean andar(Direcao direcao) {
		switch (direcao){
		case NORTE:
			y--;
			break;
		case SUL:
			y++;
			break;
		case LESTE:
			x++;
			break;
		case OESTE:
			x--;
			break;
		
		}
		
		return true;
	}
}
