package br.com.marttech.sg.controller;

import br.com.marttech.sg.model.infra.DAOServidor;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;

public class ContentUsuarioController {
	
	private static DAOServidor dao = new DAOServidor();
	
	public static boolean deleteUsuario(Long id){
		try {
			Servidor servidor = dao.bucarPorId(id);
			dao.abrirT()
			.excluir(servidor)
			.fecharT();
			
			return true;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
