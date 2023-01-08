package orientacao_a_objetos.exercicios.controle;

public class MeuControle implements ControleRemoto {
	private boolean ligado;
	private int canal=1;
	
	@Override
	public void liga() {
		ligado =true;
		
	}
	@Override
	public void desliga() {
		ligado=false;
		
	}
	
	@Override
	public void aumentarCanal() {
		if(ligado) {
			canal+=1;			
		}
		
	}
	@Override
	public void diminuirCanal() {
		if(ligado) {
			if(canal>=2) {
				canal-=1;
			}
		}
	}
	public boolean isLigado() {
		return ligado;
	}
	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
	public int getCanal() {
		return canal;
	}
	public void setCanal(int canal) {
		this.canal = canal;
	}
	
	
}
