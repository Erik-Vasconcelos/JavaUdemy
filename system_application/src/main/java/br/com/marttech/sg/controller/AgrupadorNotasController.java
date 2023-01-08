package br.com.marttech.sg.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.marttech.sg.model.dados.concreto.Nota;
import br.com.marttech.sg.model.dto.NotaDTO;
import br.com.marttech.sg.model.infra.DAONota;

public class AgrupadorNotasController {
	
	private static DAONota dao = new DAONota();
	
	public static List<NotaDTO> buscarTodas(){
		List<Nota> notas = dao.getAll(10, 0);
		
		return convertoToNotaDTO(notas);
	}
	
	private static List<NotaDTO> convertoToNotaDTO(List<Nota> notas){
		List<NotaDTO> notasDto = new ArrayList<>();
		
		if(!notas.isEmpty()) {
			notas.stream().forEach(nota -> {
				notasDto.add(new NotaDTO(nota));
			});
		}
		return notasDto;
	}
	
}
