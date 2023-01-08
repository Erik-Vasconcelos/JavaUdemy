package br.com.marttech.sg.controller;

import br.com.marttech.sg.model.dados.concreto.Nota;
import br.com.marttech.sg.model.dto.NotaDTO;
import br.com.marttech.sg.model.infra.DAONota;
import br.com.marttech.sg.model.memoria.ServidorMemory;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;

public class NotaController {
	private static DAONota dao = new DAONota();

	public static boolean salvar(NotaDTO notaDto) {
		try {
			Servidor usuario = ServidorMemory.getInstance();
			notaDto.setServidor(usuario);
			
			dao.incluirAtomico(new Nota(notaDto));
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean atualizar(NotaDTO nota) {
		try {
			Servidor usuario = ServidorMemory.getInstance();
			nota.setServidor(usuario);
			
			dao.abrirT().
				atualizar(new Nota(nota))
				.fecharT();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean exluir(NotaDTO nota) {
		try {
			Servidor usuario = ServidorMemory.getInstance();
			nota.setServidor(usuario);
			
			dao.abrirT().
				excluir(new Nota(nota))
				.fecharT();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean exluir(Long id) {
		try {
			dao.abrirT();
			dao.excluirPorId(id);
			dao.fecharT();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
