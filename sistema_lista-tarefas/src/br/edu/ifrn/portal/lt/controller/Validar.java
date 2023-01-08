package br.edu.ifrn.portal.lt.controller;

import java.sql.Date;
import java.time.LocalDate;

public class Validar {
	
	private Validar() {
	}
	
	public static boolean Texto(String valor) {
		boolean validacao1 = false;
		boolean validacao2 = false;
		boolean validacao3 = false;
		
		if(valor != null && valor != "") {
			validacao1 = true;
		}
		if(valor.trim().length() > 1) {
			validacao2 = true;
		}
		if(!valor.isEmpty()) {
			validacao3 = true;
		}
		
		return validacao1 && validacao2 && validacao3;
	}
	
	
}
