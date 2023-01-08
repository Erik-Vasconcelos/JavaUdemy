package collections.projetinho.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import collections.projetinho.controller.CapacidadeMaximaException;

public class Estante {
	
	/**
	 * @system_unity_description Classe responsável por armazenar os e manipular os livros
	 * contidos por ela. A classe tem um numero proprio de identificação em que é usado para
	 *  fonecer a localização do livro na hora da busca.
	 * @author erik vasconcelos
	 * @date 16:05:02 15 de jul. de 2022
	 */
	private final int CAPACIDADE_MAXIMA;
	private final Long numeroEstante;
	private Map<Long, Livro> livros = new HashMap<>();
	
	//Construtor

	public Estante(int cAPACIDADE_MAXIMA, Long numeroEstante) {
		super();
		CAPACIDADE_MAXIMA = cAPACIDADE_MAXIMA;
		this.numeroEstante = numeroEstante;
	}

	public Long getNumeroEstante() {
		return numeroEstante;
	}
	
	public int getQuantidadeLivros() {
		return livros.size();
	}

	public Map<Long, Livro> getLivros() {
		return livros;
	}
	//Metodos Basicos de manipulação
	public void inserirLivro(Livro livro) {
		if(livro != null && livros.size() != CAPACIDADE_MAXIMA) {
			livros.put(livro.getIsbn(), livro);
		}else {
			throw new CapacidadeMaximaException();
		}
	}
	
	public boolean verificarExistencia(Long isbn) {
		return livros.containsKey(isbn);
	}
	
	public Livro venderLivro(Long isbn) {
		Livro livro = getLivro(isbn);
		livros.remove(livro.getIsbn());
		return livro;
	}
	
	public Livro getLivro(Long isbn) {
		Livro livro = null;
		if(livros.containsKey(isbn)) {
			livro = livros.get(isbn);
		}
		return livro;
	}
	
	public StringBuilder listarLivros() {
		StringBuilder resultado= new StringBuilder();
		for (Livro livro : livros.values()) {
			resultado.append(livro.toString());
		}
		
		return resultado;
	}
	
	public Long existeOLivro(Long isbn) {
		if(verificarExistencia(isbn)) {
			return numeroEstante;
		}
		return 0L;
	}
	//=======================
	
	public ArrayList<Livro> getListLivros() {
		Supplier<ArrayList<Livro>> listaVazia = () -> {return new ArrayList<Livro>();}; 
		BiFunction<Map<Long, Livro>, ArrayList<Livro>, ArrayList<Livro>> preencherLista =
				(m, l) -> {l.addAll(m.values()); return l;};
				
		return preencherLista.apply(this.livros, listaVazia.get());
	}
	
	@Override
	public String toString() {
		return "Numero da estante: " + numeroEstante;
	}

}
