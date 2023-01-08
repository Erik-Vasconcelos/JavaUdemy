package br.com.marttech.sg.matricula;

import br.com.marttech.sg.matricula.interno.model.GeradorMatricula;

public class GeracaoMatricula {

	/**
	 * @date 21:55:06 24 de set. de 2022
	 */
	
	private static GeradorMatricula gerador;
	
	public static  Long gerar() {
		return gerador.gerarMatServ();
	}
	
}
