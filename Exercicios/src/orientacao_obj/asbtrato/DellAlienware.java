package orientacao_obj.asbtrato;

public class DellAlienware extends Notebook implements Gamer{
	boolean turboLigado;
	public DellAlienware() {
		setVelProcessador(3.40); 
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ligarTurbo() {
		turboLigado = true;
		
		
	}

	@Override
	String mostrarImagem() {
		if(turboLigado) {
			return "Imagem 4K";
		}else {
			return "Imagem Full-HD";
		}
	}
	
	
	@Override
	public String abrirJogo() {
		if(turboLigado) {
			setVelProcessador(getVelProcessador()+2.0);
		}
		return super.abrirJogo();
	}

}
