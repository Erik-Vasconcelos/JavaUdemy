package topicos_avancados;

import java.util.ArrayList;

public class ModelTorre {
	
	private int discos;

	public enum Torre{
		TORRE1,
		TORRE2,
		TORRE3;
	}
	
	private ArrayList<Disco> torre1= new ArrayList<>();
	private ArrayList<Disco> torre2= new ArrayList<>();
	private ArrayList<Disco> torre3= new ArrayList<>();
	
	private Torre torreInicial;
	private Torre torreDestino;
	private Torre torreTemp;
	
	public ModelTorre(int discos, Torre torreInicial, Torre torreDestino, Torre torreTemp) {
		this.discos = discos;
		this.torreInicial = torreInicial;
		this.torreDestino = torreDestino;
		this.torreTemp = torreTemp;
		
		preencherTorre(buscarTorre(torreInicial), discos);
	}
	
	private ArrayList<Disco> buscarTorre(Torre torre){
		switch (torre) {
		case TORRE1: 
			return torre1;
		case TORRE2: 
			return torre2;
		case TORRE3: 
			return torre3;
		default: 
			return torre1;
		}
	}
	
	private void preencherTorre(ArrayList<Disco> torre, int discos) {
		for (int i = 0; i < discos; i++) {
			torre.add(new Disco(i));
		}
	}

}
