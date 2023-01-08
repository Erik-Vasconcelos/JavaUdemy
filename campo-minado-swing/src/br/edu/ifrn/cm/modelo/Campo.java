package br.edu.ifrn.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class Campo {
	private final int linha;
	private final int coluna;
	
	private boolean minado;
	private boolean aberto;
	private boolean marcado;
	
	private List<Campo> vizinhos = new ArrayList<>();
	private List<CampoObservador> observadores = new ArrayList<>();
	
	Campo(int linha, int coluna){
		this.linha=linha;
		this.coluna= coluna;
	}
	
	
	public void registrarObserver(CampoObservador observador) {
		observadores.add(observador);
	}
	
	private void notificarObservador(CampoEvento evento) {
		observadores.stream().forEach(o -> 
		o.eventoOcorreu(this, evento));
	}
	
	boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = linha != vizinho.linha ;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int deltaLinha = Math.abs(linha -vizinho.linha);
		int deltaColuna = Math.abs(coluna - vizinho.coluna);
		int deltaGeral = deltaLinha + deltaColuna;
		
		if(deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
			
		}else if(deltaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;

		}else {
			return false;
		}
	}
	
	public void alterarMarcacao() {
		if(!aberto) {
			marcado = !marcado;
			
		}
		if(marcado) {
			notificarObservador(CampoEvento.MARCAR);
		}else {
			notificarObservador(CampoEvento.DESMARCAR);
		}
		
	}
	
	public boolean abrir() {
		
		if(!aberto && !marcado) {
			aberto= true;
			if(minado) {
				notificarObservador(CampoEvento.EXPLODIR);
				return true;
			}
			
			setAberto(true);
			
			if(vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());
				
			}
			return true;
		}else {
			return false;
		}
		
	}
	
	
	boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}
	
	void minar() {
		minado =true;
	}
	
	boolean isMarcado() {
		return marcado;
	}
	boolean isAberto() {
		return aberto;
	}
	
	boolean isFechado() {
		return !isAberto();
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
	
	public boolean objetivoAlcancado() {
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;
		
		return desvendado || protegido;
	}
	
	public int minasNaVizinhanca() {
		return (int) vizinhos.stream().filter(v -> v.minado).count();
	}
	void reiniciar() {
		aberto =false;
		minado=false;
		marcado = false;
		notificarObservador(CampoEvento.REINICIAR);
	}
	
	boolean isMinado() {
		return minado;
	}
	
	
	public void setAberto(boolean aberto) {
		this.aberto = aberto;
		
		if(aberto) {
			notificarObservador(CampoEvento.ABRIR);
		}
	}


}
