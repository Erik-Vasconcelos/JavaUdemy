package br.edu.ifrn.portal.lv.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import br.edu.ifrn.portal.lv.controller.CapacidadeMaximaException;
import br.edu.ifrn.portal.lv.controller.LivroNaoEncontradoException;

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
	public boolean inserirLivro(Livro livro) {
		boolean condicao = !validarLivro(livro) && (livro == null ||
				livros.size() == CAPACIDADE_MAXIMA ||
				verificarExistencia(livro.getIsbn()));
		
		if(condicao) {
			throw new CapacidadeMaximaException();
			
		}else {
			livros.put(livro.getIsbn(), livro);
			return true;
		}
	}
	
	public boolean validarLivro(Livro livro) {
		boolean validacao1 = false;
		boolean validacao2 = false;
		boolean validacao3 = false;
		boolean validacao4 = false;
		
		if(livro == null) {
			return false;
		}
		if(!livro.getIsbn().toString().isEmpty()) {
			validacao1 = true;
		}
		if(!livro.getNome().isEmpty() || !livro.getNome().trim().equals("")) {
			validacao2 = true;
		}
		if(!livro.getNomeAutor().isEmpty() || !livro.getNomeAutor().trim().equals("")) {
			validacao3 = true;
		}
		if(livro.getPreco() > 0.0 ) {
			validacao4 = true;
		}
		
		return validacao1 && validacao2 
				&& validacao3 && validacao4;
	}
	 
	public boolean inserirLivros(List<Livro> livros) {
		boolean validos = livros.stream().allMatch(l -> validarLivro(l));
		if(validos) {
			livros.stream().map(l -> inserirLivro(l));
			return true;
		}
		else {
			return false;
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
		if(livros.containsKey(isbn)) {
			Livro livro = livros.get(isbn);
			return livro;
		}else {
			throw new LivroNaoEncontradoException();
		}
	}
	
	public StringBuilder listarLivros() {
		StringBuilder resultado= new StringBuilder();
		for (Livro livro : livros.values()) {
			resultado.append(livro.toString());
		}
		
		return resultado;
	}
	
	public Long getLocalLivro(Long isbn) {
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

	@Override
	public int hashCode() {
		return Objects.hash(CAPACIDADE_MAXIMA, livros, numeroEstante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estante other = (Estante) obj;
		return CAPACIDADE_MAXIMA == other.CAPACIDADE_MAXIMA && Objects.equals(livros, other.livros)
				&& Objects.equals(numeroEstante, other.numeroEstante);
	}
	
	

}
