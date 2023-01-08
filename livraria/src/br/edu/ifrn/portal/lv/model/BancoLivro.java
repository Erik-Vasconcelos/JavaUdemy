package br.edu.ifrn.portal.lv.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import br.edu.ifrn.portal.lv.controller.LivroNaoEncontradoException;

public class BancoLivro {
	
	/**
	 * @system_unity_description Esta calsse realiza a função de armazenar as estantes
	 *  da livraria e promover metodos de acesso ao livros pertecente às estantes
	 * @author erik vasconcelos
	 * @date 16:36:23 15 de jul. de 2022
	 */
	
	private final static Map<Long, Estante> ESTANTES = new HashMap<>();
	
	private BancoLivro() {
	}
	
	//metodos basicos- versao finalizada
	public static void inserirEstante(Estante estante) {
		ESTANTES.put(estante.getNumeroEstante(), estante);
	}
	
	private static List<Estante> getListaEstantes() {
		Function<Map<Long, Estante>, List<Estante>> listaEstantes =
				m -> new ArrayList<Estante>(m.values());
		return listaEstantes.apply(ESTANTES);
	}
	
	public static boolean verificarDuplicata(Long isbn) {
		Predicate<Estante> isPresent = e -> e.verificarExistencia(isbn);
		boolean resultado = getListaEstantes().parallelStream().anyMatch(isPresent);
		return resultado;
	}
	
	public static Livro mapearEstante(Long isbn) {
		Livro livro=null;
		for (Estante estante : ESTANTES.values()) {
			  livro = estante.getLivro(isbn);
			  if(livro instanceof Livro) {
				  break;
			  }
		}
		if(livro != null) {
			return livro;
		}else {
			throw new LivroNaoEncontradoException();
		}
	}
	
	public static Livro maiorPreco() {
		Comparator<Livro> maiorValor = (l1, l2) -> {
			if(l1.getPreco() > l2.getPreco()) return 1;
			if(l1.getPreco() < l2.getPreco()) return -1;
			return 0;
		};
		return listarTodosLivros().stream().max(maiorValor).get();
	}
	
	
	public static Estante localizarLocalLivro(Long isbn) {
		for (Estante estante : ESTANTES.values()) {
			if(estante.verificarExistencia(isbn)) {
				return estante;
			}
		}
		return null;
	}
	
	public static int getQtdLivros() {
		return getListaEstantes().stream()
		.map(e -> e.getQuantidadeLivros())
		.reduce((acm, q) -> acm +q).get();
	}
	
	public static List<Livro> getLivrosEstante(Long numeroEstante){
		if(ESTANTES.containsKey(numeroEstante)) {
			Estante estante = ESTANTES.get(numeroEstante);
			List<Livro> lista = new ArrayList(estante.getLivros().values());
			return lista;
		}else {
			return null;
		}
	}
	
	public static ArrayList<Livro> listarTodosLivros(){
		BinaryOperator<ArrayList<Livro>> compactar = (lf, sb) -> {lf.addAll(sb); return lf;};
		return getListaEstantes().stream()
				.map(e -> e.getListLivros())
				.reduce(compactar).get();
	}
	
	public static boolean containsLivro(Long isbn) {
		boolean resultado=false;
		Predicate<Estante> contemLivro = e -> e.verificarExistencia(isbn);
		resultado = getListaEstantes().stream().anyMatch(contemLivro);
		return resultado;
	}
	
	public static Livro buscarLivro(Long isbn) {
		Livro livro = null;
		if(containsLivro(isbn)){
			livro = mapearEstante(isbn);
		}
		return livro;
	}
	
	public static Livro venderLivro(Long isbn) {
		Estante estante = localizarLocalLivro(isbn);
		if(estante instanceof Estante) {
			Livro livro = mapearEstante(isbn);
			estante.venderLivro(isbn);
			return livro;
			
		}
		return null;
	}
}
