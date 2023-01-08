package br.edu.ifrn.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.edu.ifrn.cm.excecao.ExplosaoException;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private int minas;
	
	final List<Campo> campos = new ArrayList<>();

	public Tabuleiro(int linhas, int colunas, int minas) {
		super();
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;
		
		geraCampos();
		associaVizinhos();
		sortearMinas();
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
				campos.add(new Campo(l, c));
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
		try {
			campos.stream().filter(c->c.getLinha() == linha && c.getColuna() == coluna)
			.findFirst()
			.ifPresent(c -> c.abrir());;
			
		}catch(ExplosaoException e) {
			campos.forEach(c -> c.setAberto(true));;
			throw e;
		}
	}
	public void alterarMarcacao(int linha, int coluna) {
		campos.stream().filter(c->c.getLinha() == linha && c.getColuna() == coluna)
		.findFirst()
		.ifPresent(c -> c.alterarMarcacao());;
	}
	
	
	
	@Override
	public String toString() {
		/*Sempre que voce tiver uma serie de concatenacões use o StringBuilder 
		que é uma forma otimizada de juntar Strings*/
		
		StringBuilder sb =new StringBuilder();
		sb.append("  ");
		for(int i=0;i<colunas;i++) {
			sb.append(" "+i+" ");
				
		}
		sb.append("\n");
		int i =0;
		for(int l = 0; l<linhas;l++) {
			sb.append(l+" ");
			for(int c= 0; c<colunas;c++) {
				sb.append(" ");
				sb.append(campos.get(i));
				sb.append(" ");
				i++;
				
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
}
