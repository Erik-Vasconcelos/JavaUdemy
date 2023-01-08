package br.edu.ifrn.modelo;

@FunctionalInterface
public interface MemoriaObservador {
	void valorAlterado(String novoValor);
}
