package br.edu.ifrn.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Tabuleiro implements CampoObservador{
	private final int linhas;
	private final int colunas;
	private final int minas;
	
	
	
	/**
	 * @return the linhas
	 */
	public int getLinhas() {
		return linhas;
	}

	/**
	 * @return the colunas
	 */
	public int getColunas() {
		return colunas;
	}
	
	public void paraCadaCampo(Consumer<Campo> funcao) {
		
		campos.forEach(funcao);
	}

	private final List<Campo> campos = new ArrayList<>();
	private final List<Consumer<ResultadoEvento>> observadores= new ArrayList<>();
	

	public Tabuleiro(int linhas, int colunas, int minas) {
		super();
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;
		
		geraCampos();
		associaVizinhos();
		sortearMinas();
	}
	
	public void resgistrarObservadores(Consumer<ResultadoEvento> observador) {
		observadores.add(observador);
	}
	
	public void notificarObservador(boolean resultado) {
		observadores.stream()
		.forEach(o -> o.accept(new ResultadoEvento(resultado)));
	}


	private void associaVizinhos() {
		for(Campo c1:campos) {
			for(Campo c2:campos) {
				c1.adicionarVizinho(c2);
			}
		}
	}

	private void geraCampos() {
		for(int l =0; l<linhas;l++) {
			for(int c=0;c<colunas;c++) {
				
				Campo campo =new Campo(l, c);
				campo.registrarObserver(this);
				campos.add(campo);
			}
		}
	}
	private void sortearMinas() {
		long minasArmadas =0;
		Predicate<Campo> minado = c -> c.isMinado();
		do {
			int aleatorio = (int)(Math.random()*campos.size());
			campos.get(aleatorio).minar();
			minasArmadas = campos.stream().filter(minado).count();
			
		}while(minasArmadas < minas);
	}
	
	public boolean objetivoAlcancado() {
		return campos.stream().allMatch(c -> c.objetivoAlcancado());
	}
	public void reiniciar() {
		campos.stream().forEach(c-> c.reiniciar());
		sortearMinas();
		
	}
	public void abrir(int linha, int coluna) {
		
			campos.stream().filter(c->c.getLinha() == linha && c.getColuna() == coluna)
			.findFirst()
			.ifPresent(c -> c.abrir());;

	}
	public void mostrarMinas() {
		campos.stream()
		.filter(c-> c.isMinado())
		.filter(c-> !c.isMarcado())
		.forEach(c-> c.setAberto(true));
	}
	
	
	public void alterarMarcacao(int linha, int coluna) {
		campos.stream().filter(c->c.getLinha() == linha && c.getColuna() == coluna)
		.findFirst()
		.ifPresent(c -> c.alterarMarcacao());
	}
	
	@Override
	public void eventoOcorreu(Campo campo, CampoEvento evento) {
		if(evento == CampoEvento.EXPLODIR) {
			mostrarMinas();
			notificarObservador(false);
		}else if(objetivoAlcancado()) {
			notificarObservador(true);
		}
		
	}
	
}
