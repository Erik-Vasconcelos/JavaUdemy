package br.edu.ifrn.portal.lv.controller;

public class LivroNaoEncontradoException extends RuntimeException{
	
	@Override
	public String getMessage() {
		return "O livro com o ISBN passado n�o foi encontrado";
	}

}
