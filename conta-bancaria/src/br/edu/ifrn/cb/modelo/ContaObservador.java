package br.edu.ifrn.cb.modelo;

@FunctionalInterface
public interface ContaObservador {
	public void atualizacaoOcorreu(Operacao operacao);
}
