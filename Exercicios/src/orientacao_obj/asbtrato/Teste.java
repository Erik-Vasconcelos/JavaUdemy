package orientacao_obj.asbtrato;

public class Teste {
	public static void main(String[] args) {
		AcerAspire3 acer  = new AcerAspire3();
		System.out.println(acer.abrirJogo());
		System.out.println(acer.mostrarImagem());
		
		
		
		DellAlienware dell = new DellAlienware();
		System.out.println(dell.getVelProcessador());
		dell.ligarTurbo();
		System.out.println(dell.abrirJogo());
		System.out.println(dell.mostrarImagem());
		
		Gamer g = new DellAlienware();
	}
}
