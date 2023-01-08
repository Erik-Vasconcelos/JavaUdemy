package orientacao_obj.interface2;

public class S21Plus implements Funcoes, Plus{
	private boolean altaRe;
	@Override
	public void escreverComSPen() {
		System.out.println("escreveu");
		
	}

	@Override
	public void foto4K() {
		altaRe = true;
		
		
	}

	@Override
	public void habilitarFrequenciaAlta() {
		System.out.println("120Hz Habilitado");
		
	}

	@Override
	public void tirarFoto() {
		if(altaRe) {
			System.out.println("Foto Tirada em :3840 x 2160");
		}else {
			System.out.println("Foto tirada");
		}
		
	}

	@Override
	public void desbloquear() {
		System.out.println("Desbloqueado com Digital");
		
	}

}
