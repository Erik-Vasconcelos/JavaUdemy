package br.com.marttech.sg.controller;

import br.com.marttech.sg.model.dto.NotaDTO;
import br.com.marttech.sg.model.infra.DAONota;

public class BotaoNotaController {
	
	private static DAONota dao = new DAONota();

	public static NotaDTO obterDadosNota(Long id) {
		return new NotaDTO(dao.bucarPorId(id));
	}

}
