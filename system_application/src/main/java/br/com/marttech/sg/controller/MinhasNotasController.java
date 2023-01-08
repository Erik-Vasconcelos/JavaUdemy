package br.com.marttech.sg.controller;

import br.com.marttech.sg.model.infra.DAONota;

public class MinhasNotasController {
	
	private static DAONota dao = new DAONota();
	
	public static boolean verificarLimite() {
		return dao.limiteAtingido();
	}
	
}
